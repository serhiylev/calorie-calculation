package com.polytech.caloriecalculation.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime updated;
    @NonNull
    private UserDTO userDTO;
}
