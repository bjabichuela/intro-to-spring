package com.abichuela.b142.s02.s02app.controllers;

import com.abichuela.b142.s02.s02app.models.Post;
import com.abichuela.b142.s02.s02app.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class PostController {
    @Autowired
    PostService postService;

    // Create a new post
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public ResponseEntity<Object> createPost(@RequestHeader(value = "Authorization") String token, @RequestBody Post newPost) {
        postService.createPost(newPost, token);
        return new ResponseEntity<>("New post was created.", HttpStatus.CREATED);
    }

    // Retrieve all posts
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ResponseEntity<Object> getPosts() {
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }

    // Retrieve all posts by an existing user
    @RequestMapping(value = "/my-posts", method = RequestMethod.GET)
    public ResponseEntity<Object> getMyPosts(@RequestHeader(value = "Authorization") String token) {
        return new ResponseEntity<>(postService.getMyPost(token), HttpStatus.OK);
    }

    // Update an existing post
    @RequestMapping(value="/posts/{postId}", method=RequestMethod.PUT)
    public ResponseEntity<Object> updatePost(@PathVariable Long postId, @RequestBody Post updatedPost, @RequestHeader(value = "Authorization") String token) {
        return postService.updatePost(postId, updatedPost, token);
    }

    // Delete an existing post
    @RequestMapping(value="/posts/{postId}", method=RequestMethod.DELETE)
    public ResponseEntity<Object> deletePost(@PathVariable Long postId, @RequestHeader(value = "Authorization") String token) {
        return postService.deletePost(postId, token);
    }
}
