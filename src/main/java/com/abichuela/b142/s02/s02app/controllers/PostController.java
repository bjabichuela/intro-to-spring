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
    @RequestMapping(value = "/users/{userId}/posts", method = RequestMethod.POST)
    public ResponseEntity<Object> createPost(@RequestBody Post newPost, @PathVariable Long userId) {
        postService.createPost(newPost, userId);
        return new ResponseEntity<>("New post was created.", HttpStatus.CREATED);
    }

    // Retrieve all posts
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ResponseEntity<Object> getPosts() {
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }

    // Retrieve all posts by an existing user
    @RequestMapping(value = "/users/{userId}/posts", method = RequestMethod.GET)
    public ResponseEntity<Object> getPosts(@PathVariable Long userId) {
        return new ResponseEntity<>(postService.getMyPost(userId), HttpStatus.OK);
    }

    // Update an existing post
    @RequestMapping(value="/posts/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Object> updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        postService.updatePost(id, updatedPost);
        return new ResponseEntity<>("Post was updated.", HttpStatus.OK);
    }

    // Delete an existing post
    @RequestMapping(value="/posts/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Object> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>("Post was deleted.", HttpStatus.OK);
    }
}
