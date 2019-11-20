//package com.polytech.caloriecalculation.service;
//
//import com.polytech.caloriecalculation.model.Sets;
//import com.polytech.caloriecalculation.repository.SetsRepository;
//import com.polytech.caloriecalculation.repository.UserSetsRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class SetsService {
//    private final SetsRepository setsRepository;
//    private final UserSetsRepository userSetsRepository;
//
//    public SetsService(SetsRepository setsRepository, UserSetsRepository userSetsRepository) {
//        this.setsRepository = setsRepository;
//        this.userSetsRepository = userSetsRepository;
//    }
//
//
//    public List<Sets> getAllByUserId(Integer userId) {
//        Integer[] setsId = userSetsRepository.getUserSetsIdByUserId(userId);
//        List<Sets> allById = setsRepository.getAllById(setsId);
//        System.out.println(allById.toString());
//        return allById;
//    }
//}
