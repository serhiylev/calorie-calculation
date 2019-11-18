package com.polytech.caloriecalculation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ProductsSets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "grams")
    private int grams;

    @JsonManagedReference(value = "p_s-product")
    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    Products product;

    @JsonBackReference(value = "sets-product_sets")
    @ManyToOne
    @MapsId("set_id")
    @JoinColumn(name = "set_id")
    Sets sets;

}
