//package com.polytech.caloriecalculation.repository;
//
//import com.polytech.caloriecalculation.model.UserSets;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//public interface UserSetsRepository extends JpaRepository<UserSets, Integer> {
//    @Query(value = "SELECT set_id from caloriecalculation1.user_sets where user_id = (:userId)",nativeQuery = true)
//    Integer[] getUserSetsIdByUserId(Integer userId);
//}
