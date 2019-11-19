package com.polytech.caloriecalculation.repository;

import com.polytech.caloriecalculation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();

    Optional<User> findByUsernameOrEmail(String username, String email);

    User getOne(Integer integer);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<User> findByActivationCode(String activationCode);

}
