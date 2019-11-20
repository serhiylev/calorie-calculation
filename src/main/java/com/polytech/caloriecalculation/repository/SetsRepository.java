package com.polytech.caloriecalculation.repository;

import com.polytech.caloriecalculation.model.Sets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SetsRepository extends JpaRepository<Sets, Integer> {
    Sets getOne(Integer id);

    List<Sets> getAllById(Integer[] id);

}
