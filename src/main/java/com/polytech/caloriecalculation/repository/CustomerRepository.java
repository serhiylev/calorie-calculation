package com.polytech.caloriecalculation.repository;

import com.polytech.caloriecalculation.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
