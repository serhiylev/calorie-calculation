package com.polytech.caloriecalculation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ProductsSets {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "grams")
    private int grams;

    @JsonManagedReference(value = "p_s-product")
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;

    @JsonBackReference(value = "sets-product_sets")
    @ManyToOne
    @JoinColumn(name = "set_id")
    private Sets sets;

}
