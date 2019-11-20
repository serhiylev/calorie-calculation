//package com.polytech.caloriecalculation.controller;
//
//import com.polytech.caloriecalculation.model.Sets;
//import com.polytech.caloriecalculation.repository.ProductsSetRepository;
//import com.polytech.caloriecalculation.service.SetsService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin("*")
//@RequestMapping("/sets")
//public class SetsController {
//
//
//    private final ProductsSetRepository productsSetRepository;
//    private final SetsService setsService;
//
//    public SetsController(ProductsSetRepository productsSetRepository, SetsService setsService) {
//        this.productsSetRepository = productsSetRepository;
//        this.setsService = setsService;
//    }
//
//    @Transactional
//    @DeleteMapping("deleteProduct/{setId}/{productId}")
//    public ResponseEntity<HttpStatus> deleteProductFromSet(@PathVariable("setId") Integer setId, @PathVariable("productId") Integer productId) {
//        productsSetRepository.deleteProductsBySetsIdAndProductId(setId, productId);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @GetMapping()
//    public List<Sets> getSetsByUserId(@RequestParam Integer userId) {
//        return setsService.getAllByUserId(userId);
//    }
//}
