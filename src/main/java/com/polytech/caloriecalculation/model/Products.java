package com.polytech.caloriecalculation.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "products")
public class Products {
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "products")
    Set<User> users;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "products")
    Set<Ingredient> ingredients;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "image")
    private String image;
}

