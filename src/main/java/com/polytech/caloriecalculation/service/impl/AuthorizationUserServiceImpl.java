package com.polytech.caloriecalculation.service.impl;

import com.polytech.caloriecalculation.dto.AuthorizationUserDTO;
import com.polytech.caloriecalculation.model.User;
import com.polytech.caloriecalculation.repository.UserRepository;
import com.polytech.caloriecalculation.service.AuthorizationUserService;
import com.polytech.caloriecalculation.util.mappers.AuthorizationUserMapper;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationUserServiceImpl implements AuthorizationUserService {

    private final UserRepository userRepository;
    private final AuthorizationUserMapper authorizationUserMapper;

    public AuthorizationUserServiceImpl(UserRepository userRepository, AuthorizationUserMapper authorizationUserMapper) {
        this.userRepository = userRepository;
        this.authorizationUserMapper = authorizationUserMapper;
    }

    @Override
    public AuthorizationUserDTO getUser(String username) {
        User user = userRepository.findByUsernameOrEmail(username, username).get();
        return authorizationUserMapper.userToAuthorizationUserDTO(user);
    }

}
