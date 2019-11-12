package com.polytech.caloriecalculation.controller;

import com.polytech.caloriecalculation.model.ProductType;
import com.polytech.caloriecalculation.model.Products;
import com.polytech.caloriecalculation.service.ProductsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("dishes")
public class DishesController {

    private final ProductsService dishService;

    public DishesController(ProductsService dishService) {
        this.dishService = dishService;
    }

    @GetMapping()
    public List<Products> getDish(@RequestParam String type) {
        return dishService.getProductsByType(String.valueOf(ProductType.valueOf(type)));
    }
}
