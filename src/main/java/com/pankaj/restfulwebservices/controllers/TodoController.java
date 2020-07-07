package com.pankaj.restfulwebservices.controllers;

import com.pankaj.restfulwebservices.model.Todo;
import com.pankaj.restfulwebservices.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){
        return todoService.findAll();
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> saveTodo(
            @PathVariable String username, @RequestBody Todo todo){

        Todo createdTodo = todoService.save(todo);

        //Location
        //Get current resource url
        ///{id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public Todo updateTodo(
            @PathVariable String username,
            @PathVariable long id, @RequestBody Todo todo){

        Todo todoUpdated = todoService.save(todo);

        return todoUpdated;
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public Todo deleteTodo(@PathVariable String username, @PathVariable long id){
        Todo todo = todoService.deleteById(id);

        if(todo!=null) {
            return todo;
        }
        return null;
    }
}
