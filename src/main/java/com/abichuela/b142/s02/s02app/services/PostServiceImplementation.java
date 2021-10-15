package com.abichuela.b142.s02.s02app.services;

import com.abichuela.b142.s02.s02app.configs.JwtToken;
import com.abichuela.b142.s02.s02app.models.Post;
import com.abichuela.b142.s02.s02app.models.User;
import com.abichuela.b142.s02.s02app.repositories.PostRepository;
import com.abichuela.b142.s02.s02app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImplementation implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    JwtToken jwtToken;

    public void createPost(Post newPost, String token) {
        User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(token));
        Post post = new Post();
        post.setTitle(newPost.getTitle());
        post.setContent(newPost.getContent());
        post.setUser(author);
        postRepository.save(post);
    }

    public ResponseEntity updatePost(Long postId, Post updatedPost, String token) {
        Post existingPost = postRepository.findById(postId).get();
        String authorName = existingPost.getUser().getUsername();
        String authUsername = jwtToken.getUsernameFromToken(token);
        if (authUsername.equals(authorName)) {
            existingPost.setTitle(updatedPost.getTitle());
            existingPost.setContent(updatedPost.getContent());
            postRepository.save(existingPost);
            return new ResponseEntity<>("Post updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("You are not authorized to edit this post.", HttpStatus.UNAUTHORIZED);
        }
    }

    public ResponseEntity deletePost(Long postId, String token) {
        Post existingPost = postRepository.findById(postId).get();
        String authorName = existingPost.getUser().getUsername();
        String authUsername = jwtToken.getUsernameFromToken(token);
        if (authUsername.equals(authorName)) {
            postRepository.deleteById(postId);
            return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("You are not authorized to delete this post.", HttpStatus.UNAUTHORIZED);
        }
    }

    public Iterable<Post> getPosts() {
        return postRepository.findAll();
    }

    public Iterable<Post> getMyPosts(String token) {
        User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(token));
        return author.getPosts();
    }
}