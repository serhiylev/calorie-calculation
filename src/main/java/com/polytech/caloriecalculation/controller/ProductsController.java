package com.polytech.caloriecalculation.controller;

import com.polytech.caloriecalculation.model.ProductType;
import com.polytech.caloriecalculation.model.Products;
import com.polytech.caloriecalculation.service.ProductsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductsController {
    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping()
    public List<Products> getProducts(@RequestParam String type) {
        System.out.println(type);
        return productsService.getProductsByType(String.valueOf(ProductType.getByName(type)));
//        return productsService.getProductsByType(String.valueOf(ProductType.valueOf(type)));
    }
}
