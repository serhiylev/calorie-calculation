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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name" )
    private String name;
    @Column(name = "email" )
    private String email;
    @Column(name = "password" )
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_dishes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    List<Dishes> dishes;

}
