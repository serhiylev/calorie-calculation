//package com.polytech.caloriecalculation.model;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Entity
//@Getter
//@Setter
//@Table(name = "user_sets")
//public class UserSets {
//
//    @Id
//    @JsonIgnore
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @ManyToOne
//    @JsonManagedReference(value = "user-s-s")
//    @JoinColumn(name = "set_id")
//    private Sets sets;
//
//    @ManyToOne
//    @JsonBackReference(value = "user-s-user")
//    @JoinColumn(name = "user_id")
//    private User user;
//
//}
