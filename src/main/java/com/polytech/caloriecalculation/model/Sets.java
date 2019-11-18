package com.polytech.caloriecalculation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonIgnore;

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
    @ManyToMany(mappedBy = "userSets")
    Set<User> users;

    @JsonManagedReference("sets-product_sets")
    @OneToMany(mappedBy = "sets")
    Set<ProductsSets> productsDetails;
}
