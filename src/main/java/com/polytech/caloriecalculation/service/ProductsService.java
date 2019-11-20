package com.polytech.caloriecalculation.service;

import com.polytech.caloriecalculation.model.Products;
import com.polytech.caloriecalculation.model.ProductsSets;
import com.polytech.caloriecalculation.model.Sets;
import com.polytech.caloriecalculation.repository.ProductsRepository;
import com.polytech.caloriecalculation.repository.ProductsSetRepository;
import com.polytech.caloriecalculation.repository.SetsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;
    private final ProductsSetRepository productsSetRepository;
    private final SetsRepository setsRepository;

    public ProductsService(ProductsRepository productsRepository, ProductsSetRepository productsSetRepository, SetsRepository setsRepository) {
        this.productsRepository = productsRepository;
        this.productsSetRepository = productsSetRepository;
        this.setsRepository = setsRepository;
    }

    public List<Products> getProductsByType(String type) {
        return productsRepository.findAllByType(type);
    }

    public void saveProductSets(int setId,int productId,int grams) {
        ProductsSets productsSets = new ProductsSets();
        productsSets.setGrams(grams);
        productsSets.setProduct(productsRepository.getOne(productId));
        productsSets.setSets(setsRepository.getOne(setId));
        productsSetRepository.save(productsSets);
    }
}
