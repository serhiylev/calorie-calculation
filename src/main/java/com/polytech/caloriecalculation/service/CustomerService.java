package com.polytech.caloriecalculation.service;

import com.polytech.caloriecalculation.model.User;
import com.polytech.caloriecalculation.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final UserRepository userRepository;

    public CustomerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getCustomerById(Integer id) {
        return userRepository.getOne(id);
    }
}
