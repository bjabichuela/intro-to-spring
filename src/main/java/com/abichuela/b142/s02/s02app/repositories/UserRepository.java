package com.abichuela.b142.s02.s02app.repositories;

import com.abichuela.b142.s02.s02app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
