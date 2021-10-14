package com.abichuela.b142.s02.s02app.services;

import com.abichuela.b142.s02.s02app.models.User;

public interface UserService {
    void createUser(User user);
    void updateUser(Long id, User user);
    void deleteUser(Long id);
    Iterable<User> getUsers();
}
