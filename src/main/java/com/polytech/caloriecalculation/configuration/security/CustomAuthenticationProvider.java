package com.polytech.caloriecalculation.configuration.security;

import com.polytech.caloriecalculation.dto.AuthorizationUserDTO;
import com.polytech.caloriecalculation.service.AuthorizationUserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider, AuthenticationManager {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final AuthorizationUserService authorizationUserService;
    private static final String WRONG_CREDENTIALS_MSG = "Wrong login or password!!!";

    public CustomAuthenticationProvider(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService,
                                        BCryptPasswordEncoder passwordEncoder,
                                        AuthorizationUserService authorizationUserService) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.authorizationUserService = authorizationUserService;
    }

    @Override
    public Authentication authenticate(final Authentication authentication) {
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = userDetailsService.loadUserByUsername(login);
        AuthorizationUserDTO user = authorizationUserService.getUser(login);

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException(WRONG_CREDENTIALS_MSG);
        }else {
            return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
