package com.polytech.caloriecalculation.configuration.security;

import com.polytech.caloriecalculation.model.Role;
import com.polytech.caloriecalculation.model.User;
import org.springframework.stereotype.Component;

@Component
public class AccessPermission {

    private boolean isCustomer(User user) {
        return user.getRoles().contains(Role.CUSTOMER);
    }

    private boolean isProvider(User user) {
        return user.getRoles().contains(Role.PROVIDER);
    }
}
