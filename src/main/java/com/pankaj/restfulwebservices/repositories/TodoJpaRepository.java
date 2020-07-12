package com.pankaj.restfulwebservices.repositories;

import com.pankaj.restfulwebservices.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoJpaRepository extends JpaRepository<Todo, Long>{
    List<Todo> findByUserName(String username);
}
