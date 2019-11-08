package com.polytech.caloriecalculation.service;

import com.polytech.caloriecalculation.model.Dishes;
import com.polytech.caloriecalculation.repository.DishesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    private final DishesRepository dishesRepository;

    public DishService(DishesRepository dishesRepository) {
        this.dishesRepository = dishesRepository;
    }

    public List<Dishes> getDishesByType(String type) {
        return dishesRepository.findAllByType(type);
    }
}
