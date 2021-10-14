package com.abichuela.b142.s02.s02app.services;

import com.abichuela.b142.s02.s02app.models.Post;

public interface PostService {
    void createPost(Post newPost, Long userId);
    void updatePost(Long userId, Long postId, Post updatedPost);
    void deletePost(Long postId);
    Iterable<Post> getPosts();
    Iterable<Post> getMyPost(Long userId);
}

