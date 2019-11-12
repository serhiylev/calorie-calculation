package com.polytech.caloriecalculation.service;

import com.polytech.caloriecalculation.model.Products;
import com.polytech.caloriecalculation.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Products> getProductsByType(String type) {
        return productsRepository.findAllByType(type);
    }
}
