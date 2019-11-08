package com.polytech.caloriecalculation.controller;

import com.polytech.caloriecalculation.model.DishType;
import com.polytech.caloriecalculation.model.Dishes;
import com.polytech.caloriecalculation.service.DishService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("dishes")
public class DishesController {

    private final DishService dishService;

    public DishesController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping()
    public List<Dishes> getDish(@RequestParam String type) {
        return dishService.getDishesByType(String.valueOf(DishType.valueOf(type)));
    }
}
