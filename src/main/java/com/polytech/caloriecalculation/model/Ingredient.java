package com.polytech.caloriecalculation.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "calories_100g")
    private int calories;//todo not sure about name(should be the same or not)

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ingredients",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    List<Products> products;
}
