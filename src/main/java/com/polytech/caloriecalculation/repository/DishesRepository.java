package com.polytech.caloriecalculation.repository;

import com.polytech.caloriecalculation.model.Dishes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishesRepository extends JpaRepository<Dishes, Integer> {
    List<Dishes> findAllByType(String type);
    List<Dishes> getAllByType(String type);
}
