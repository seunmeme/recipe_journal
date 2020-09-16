package com.seunmeme.recipesjournal.repository;

import com.seunmeme.recipesjournal.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByEmail(String email);
    boolean existsByEmail(String email);

}
