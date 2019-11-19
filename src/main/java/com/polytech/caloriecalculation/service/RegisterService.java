package com.polytech.caloriecalculation.service;

import com.polytech.caloriecalculation.dto.CustomerDTO;
import com.polytech.caloriecalculation.model.Customer;
import com.polytech.caloriecalculation.model.Role;
import com.polytech.caloriecalculation.model.User;
import com.polytech.caloriecalculation.repository.CustomerRepository;
import com.polytech.caloriecalculation.repository.UserRepository;
import com.polytech.caloriecalculation.util.mappers.CustomerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@Slf4j
public class RegisterService {

    private static final String WELCOME = "Welcome!";
    private static final String SIGNING_UP = "Thank you for signing up!";
    private static final String HAVE_VERIFIED_YOUR_EMAIL = "You have verified your email!!";
    private static final String VERIFYING_YOUR_EMAIL = "Thank you for verifying your email!";
    private static final String FAILED_TO_VERIFY_MESSAGE = "Failed to verify! Your activation code is already used!";


    private static final String USERNAME_EXISTS = "This username already exist";
    private static final String EMAIL_EXISTS = "This email already used";

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;



    public RegisterService(UserRepository userRepository, EmailService emailService, PasswordEncoder passwordEncoder, CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }


    @Transactional
    public CustomerDTO createCustomer(final CustomerDTO customerDTO) {
        User user = userRepository.save(createUser(customerMapper.customerDTOToUser(customerDTO), Role.CUSTOMER));
        log.info(user.getPassword());
        sendVerificationCode(user);

        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        customer.setUser(user);
        return customerMapper.customerToCustomerDTO(customerRepository.save(customer));
    }


    private User createUser(User user, Role role) {
        validateForEmailAndUsername(user.getEmail(), user.getUsername());
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }

    private void validateForEmailAndUsername(String email, String username) {
        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException(USERNAME_EXISTS);
        }
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException(EMAIL_EXISTS);
        }
    }

    @Transactional
    public User sendVerificationCode(final User user) {
        user.setActivationCode(UUID.randomUUID().toString());
        emailService.sendVerificationEmailTo(user);
        return user;
    }

    @Transactional
    public boolean verifyUser(final String activationCode) {
        User user = userRepository.findByActivationCode(activationCode)
                .orElseThrow(() -> new RuntimeException(FAILED_TO_VERIFY_MESSAGE));
        user.setActivated(true);
        user.setActivationCode(null);
        return true;
    }
}
