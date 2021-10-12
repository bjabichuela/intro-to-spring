package com.abichuela.b142.s02.s02app.repositories;

import com.abichuela.b142.s02.s02app.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Object> {

}
