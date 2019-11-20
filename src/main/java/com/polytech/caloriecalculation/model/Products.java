package com.polytech.caloriecalculation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "image")
    private String image;
    @Column(name = "kcal")
    private int kcal;
    @Column(name = "proteins")
    private int proteins;
    @Column(name = "fats")
    private int fats;
    @Column(name = "carbohydrates")
    private int carbohydrates;

    @JsonBackReference(value = "p_s-product")
    @OneToMany(mappedBy = "product")
    Set<ProductsSets> productsSets;



}
