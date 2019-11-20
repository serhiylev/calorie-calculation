package com.polytech.caloriecalculation.controller;

import com.polytech.caloriecalculation.model.ProductType;
import com.polytech.caloriecalculation.model.Products;
import com.polytech.caloriecalculation.model.ProductsSets;
import com.polytech.caloriecalculation.repository.ProductsSetRepository;
import com.polytech.caloriecalculation.service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductsController {
    private final ProductsService productsService;
    private final ProductsSetRepository productsSetRepository;

    public ProductsController(ProductsService productsService, ProductsSetRepository productsSetRepository) {
        this.productsService = productsService;
        this.productsSetRepository = productsSetRepository;
    }

    @GetMapping()
    public List<Products> getProducts(@RequestParam String type) {
        return productsService.getProductsByType(String.valueOf(ProductType.getByName(type)));
    }

//    @PostMapping("save")
//    @ResponseStatus(HttpStatus.CREATED)
////    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PROVIDER')")
//    public ProductsSets saveProductSets(@RequestBody ProductsSets productsSets) {
//        return productsService.saveProductSets(productsSets);
//    }

    @PutMapping("addToSet/{setId}/{productId}/{grams}")
    public ResponseEntity<HttpStatus> addProductToSet(
            @PathVariable("setId") Integer setId,
            @PathVariable("productId") Integer productId,
            @PathVariable("grams") Integer grams) {
            productsService.saveProductSets(setId, productId, grams);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("deleteProduct/{setId}/{productId}")
    public ResponseEntity<HttpStatus> deleteProductFromSet(@PathVariable("setId") Integer setId, @PathVariable("productId") Integer productId) {
        productsSetRepository.deleteProductsBySetsIdAndProductId(setId, productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
