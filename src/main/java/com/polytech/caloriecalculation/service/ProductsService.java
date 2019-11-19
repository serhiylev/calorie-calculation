package com.polytech.caloriecalculation.service;

import com.polytech.caloriecalculation.model.Products;
import com.polytech.caloriecalculation.model.ProductsSets;
import com.polytech.caloriecalculation.repository.ProductsRepository;
import com.polytech.caloriecalculation.repository.ProductsSetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;
    private final ProductsSetRepository productsSetRepository;

    public ProductsService(ProductsRepository productsRepository, ProductsSetRepository productsSetRepository) {
        this.productsRepository = productsRepository;
        this.productsSetRepository = productsSetRepository;
    }

    public List<Products> getProductsByType(String type) {
        return productsRepository.findAllByType(type);
    }

    public ProductsSets saveProductSets(ProductsSets productsSets) {

        return productsSetRepository.save(productsSets);
    }
}
