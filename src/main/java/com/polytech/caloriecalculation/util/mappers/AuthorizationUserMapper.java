package com.polytech.caloriecalculation.util.mappers;

import com.polytech.caloriecalculation.dto.AuthorizationUserDTO;
import com.polytech.caloriecalculation.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface AuthorizationUserMapper {
    @Mapping(target = "userLogin", source = "username")
    AuthorizationUserDTO userToAuthorizationUserDTO(User user);

    @Mapping(target = "username", source = "userLogin")
    User authorizationUserDTOToUser(AuthorizationUserDTO authorizationUserDTO);
}
