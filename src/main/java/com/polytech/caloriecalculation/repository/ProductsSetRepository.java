package com.polytech.caloriecalculation.repository;

import com.polytech.caloriecalculation.model.ProductsSets;
import org.springframework.data.repository.CrudRepository;

public interface ProductsSetRepository extends CrudRepository<ProductsSets, Integer> {
//    void deleteProductsIdaAndProductId(int setId, int productId);

    void deleteProductsBySetsIdAndProductId(int setId, int productId);
}
