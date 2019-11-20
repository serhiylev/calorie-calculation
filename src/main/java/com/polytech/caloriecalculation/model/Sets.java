package com.polytech.caloriecalculation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "sets")
public class Sets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @JsonBackReference("users-sets")
    @ManyToMany(mappedBy = "userSets", fetch = FetchType.LAZY)
    Set<User> users;

//    @JsonBackReference("user-s-s")
//    @OneToMany(mappedBy = "sets")
//    Set<UserSets> userSets;

    @JsonManagedReference("sets-product_sets")
    @OneToMany(mappedBy = "sets")
    Set<ProductsSets> productsDetails;

}
