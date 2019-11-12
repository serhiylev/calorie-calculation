package com.polytech.caloriecalculation.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductsRepository dishesRepository;

    @Test
    public void getAllUsersTest() {
        System.out.println("salads =   "+dishesRepository.findAllByType("salad"));
        System.out.println("salads =   "+dishesRepository.getAllByType("salad"));
        System.out.println("salads =   " + dishesRepository.findById(1));
        System.out.println(userRepository.findAll());
        userRepository.findAll();
    }
}
