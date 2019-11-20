package com.polytech.caloriecalculation.controller;

import com.polytech.caloriecalculation.model.User;
import com.polytech.caloriecalculation.repository.ProductsSetRepository;
import com.polytech.caloriecalculation.repository.UserRepository;
import com.polytech.caloriecalculation.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(UserRepository userRepository, ProductsSetRepository productsSetRepository, CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public User getUser(@RequestParam Integer id) {
        return customerService.getCustomerById(id);
    }

}
