package com.pankaj.restfulwebservices.repositories;

import com.pankaj.restfulwebservices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserName(String userName);
}
