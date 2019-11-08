package com.polytech.caloriecalculation.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "dishes")
public class Dishes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;

    @ManyToMany(fetch = FetchType.EAGER)
    Set<User> users;
    @ManyToMany(fetch = FetchType.EAGER)
    Set<Ingredient> ingredients;
}

