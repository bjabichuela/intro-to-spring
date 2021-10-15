package com.abichuela.b142.s02.s02app.services;

import com.abichuela.b142.s02.s02app.models.Post;
import org.springframework.http.ResponseEntity;

public interface PostService {
    void createPost(Post newPost, String token);
    ResponseEntity updatePost(Long postId, Post updatedPost, String token);
    ResponseEntity deletePost(Long postId, String token);
    Iterable<Post> getPosts();
    Iterable<Post> getMyPost(String token);
}

