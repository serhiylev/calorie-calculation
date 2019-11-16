package com.polytech.caloriecalculation.service;

import com.polytech.caloriecalculation.dto.AuthorizationUserDTO;

public interface AuthorizationUserService {

    AuthorizationUserDTO getUser(String username);

//    void updateUser(AuthorizationUserDTO user);

//    void checkAttempts(AuthorizationUserDTO userDTO);

//    boolean checkLastFailTime(AuthorizationUserDTO userDTO);

//    void setDefaultAttemptValue(AuthorizationUserDTO user);

//    String getWaitTime(Duration duration);
}
