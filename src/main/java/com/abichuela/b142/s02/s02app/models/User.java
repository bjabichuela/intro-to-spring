package com.abichuela.b142.s02.s02app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
public class User {
    // Properties (columns)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Post> posts;

    // Constructor
    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters & Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public Long getId(){
        return id;
    }
}
