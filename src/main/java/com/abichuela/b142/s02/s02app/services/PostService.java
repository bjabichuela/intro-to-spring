package com.abichuela.b142.s02.s02app.services;

import com.abichuela.b142.s02.s02app.models.Post;

public interface PostService {
    void createPost(Post newPost, Long userId);
    void updatePost(Long id, Post updatedPost);
    void deletePost(Long id);
    Iterable<Post> getPosts();
    Iterable<Post> getMyPost(Long userId);
}

