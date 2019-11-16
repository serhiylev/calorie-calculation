package com.polytech.caloriecalculation.dto;

import com.polytech.caloriecalculation.model.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class AuthorizationUserDTO {
    private Integer id;
    private String userLogin;
    private String image;
    private Set<Role> roles;
    private Integer attempts;
    private LocalDateTime lastFail;
}
