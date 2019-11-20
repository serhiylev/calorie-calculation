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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "login")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "is_activated")
    private boolean isActivated;

    @Column(name = "activation_code")
    private String activationCode;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @JsonManagedReference("users-sets")
    @ManyToMany
    @JoinTable(
            name = "user_sets",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "set_id"))
    Set<Sets> userSets;

//    @JsonManagedReference("user-s-user")
//    @OneToMany(mappedBy = "user")
//    Set<UserSets> userSets;
}
