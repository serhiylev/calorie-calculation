package com.polytech.caloriecalculation.util.mappers;

import com.polytech.caloriecalculation.dto.CustomerDTO;
import com.polytech.caloriecalculation.model.Customer;
import com.polytech.caloriecalculation.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mappings({
            @Mapping(target = "user", source = "userDTO"),
            @Mapping(target = "user.email", source = "customerDTO.email")
    })
    Customer customerDTOToCustomer(CustomerDTO customerDTO);

    @Mappings({
            @Mapping(target = "id", source = "userDTO.id"),
            @Mapping(target = "username", source = "userDTO.username"),
            @Mapping(target = "password", source = "userDTO.password"),
            @Mapping(target = "email", source = "email"),
    })
    User customerDTOToUser(CustomerDTO customerDTO);


    @Mappings({
            @Mapping(target = "userDTO", source = "user"),
            @Mapping(target = "email", source = "customer.user.email")

    })
    CustomerDTO customerToCustomerDTO(Customer customer);
}
