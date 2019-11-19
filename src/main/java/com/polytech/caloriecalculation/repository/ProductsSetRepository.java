package com.polytech.caloriecalculation.repository;

import com.polytech.caloriecalculation.model.ProductsSets;
import org.springframework.data.repository.CrudRepository;

public interface ProductsSetRepository extends CrudRepository<ProductsSets, Integer> {

    ProductsSets save(ProductsSets productsSets);

    void deleteProductsBySetsIdAndProductId(int setId, int productId);

}
