package com.abichuela.b142.s02.s02app.models;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    // Properties (columns)
    @Id
    @GeneratedValue
    private Long id; // primary key
    @Column
    private String title;
    @Column
    private  String content;

    // Constructors
    public Post() {}

    public Post(String title, String content){
        this.title = title;
        this.content = content;
    }

    // Getters & Setters
    public String getTitle(){
        return title;
    }

    public String setTitle(String newTitle){
       return this.title = title;
    }

    public  String getContent(){
        return content;
    }

    public String setContent(String newContent){
        return this.content = content;
    }

    // Methods
}
