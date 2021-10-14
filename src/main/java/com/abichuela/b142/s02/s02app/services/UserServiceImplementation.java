package com.abichuela.b142.s02.s02app.services;

import com.abichuela.b142.s02.s02app.models.User;
import com.abichuela.b142.s02.s02app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;

    // Create a new user
    public void createUser(User user) { userRepository.save(user); }

    // Retrieve all existing users
    public Iterable<User> getUsers() { return userRepository.findAll(); }

    // Update an existing user
    public void updateUser(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id).get();
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setPassword(updatedUser.getPassword());
        userRepository.save(existingUser);
    }

    // Delete an existing user
    public void deleteUser(Long id) { userRepository.deleteById(id); }


    public Optional<User> findByUserName(String username) {
        return Optional.ofNullable(userRepository.findByUserName(username));
    }
}

