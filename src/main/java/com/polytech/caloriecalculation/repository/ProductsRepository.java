package com.polytech.caloriecalculation.repository;

import com.polytech.caloriecalculation.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {
    List<Products> findAllByType(String type);
    List<Products> getAllByType(String type);
}
