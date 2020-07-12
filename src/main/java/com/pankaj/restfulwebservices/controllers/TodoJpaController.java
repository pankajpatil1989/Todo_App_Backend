package com.pankaj.restfulwebservices.controllers;

import com.pankaj.restfulwebservices.model.Todo;
import com.pankaj.restfulwebservices.repositories.TodoJpaRepository;
import com.pankaj.restfulwebservices.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class TodoJpaController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private TodoJpaRepository todoJpaRepository;


    @GetMapping("/jpa/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){
        return todoJpaRepository.findByUserName(username);
    }

    @GetMapping("/jpa/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id) {
        return todoJpaRepository.findById(id).get();
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/jpa/users/{username}/todos")
    public ResponseEntity<Void> createTodo(
            @PathVariable String username, @RequestBody Todo todo){

        todo.setUserName(username);
        Todo createdTodo = todoJpaRepository.save(todo);

        //Location
        //Get current resource url
        ///{id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    //Edit/Update a Todo
    @PutMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable String username,
            @PathVariable long id, @RequestBody Todo todo){

        Todo todoUpdated = todoJpaRepository.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    //DELETE /users/{username}/todos/{id}
    @DeleteMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(
            @PathVariable String username, @PathVariable long id){

        todoJpaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
