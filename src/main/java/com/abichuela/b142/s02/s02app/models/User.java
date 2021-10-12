package com.abichuela.b142.s02.s02app.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String username;

    @Column(nullable = false, length = 64)
    private String password;

    public User(){}

    public User(String username, String password){
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
    public String setUsername(String newUsername){
        return this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword (String newPassword){
        this.password = password;
    }
}
