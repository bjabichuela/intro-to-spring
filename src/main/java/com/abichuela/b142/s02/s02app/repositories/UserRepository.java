package com.abichuela.b142.s02.s02app.repositories;

import com.abichuela.b142.s02.s02app.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Object> {
}
