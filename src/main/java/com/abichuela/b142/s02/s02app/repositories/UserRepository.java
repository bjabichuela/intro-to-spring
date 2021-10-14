package com.abichuela.b142.s02.s02app.repositories;

import com.abichuela.b142.s02.s02app.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Object> {
    User findByUserName(String username);
}
