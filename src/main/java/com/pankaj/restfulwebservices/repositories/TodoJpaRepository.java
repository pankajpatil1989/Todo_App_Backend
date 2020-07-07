package com.pankaj.restfulwebservices.repositories;

import java.util.List;

import com.pankaj.restfulwebservices.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoJpaRepository extends JpaRepository<Todo, Long>{
    List<Todo> findByUserName(String username);
}
