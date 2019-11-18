package com.polytech.caloriecalculation.controller;

import com.polytech.caloriecalculation.model.User;
import com.polytech.caloriecalculation.repository.ProductsSetRepository;
import com.polytech.caloriecalculation.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("customer")
public class CustomerController {

    private final UserRepository userRepository;
    private final ProductsSetRepository productsSetRepository;

    public CustomerController(UserRepository userRepository, ProductsSetRepository productsSetRepository) {
        this.userRepository = userRepository;
        this.productsSetRepository = productsSetRepository;

    }

    @GetMapping()
    public User getUser(@RequestParam Integer id) {
        return userRepository.getOne(id);
    }

    @Transactional
    @DeleteMapping("deleteProduct/{setId}/{productId}")
    public HttpStatus deleteProductFromSet(@PathVariable("setId") Integer setId, @PathVariable("productId") Integer productId) {
        productsSetRepository.deleteProductsBySetsIdAndProductId(setId,productId);
        return HttpStatus.OK;
    }
}
