package com.nxtwave.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nxtwave.todolist.model.TodoList;
import com.nxtwave.todolist.service.TodoListService;

@RestController
public class TodoListController {

	@Autowired
	private TodoListService service;

	// Endpoint to create a new todo list
	@PostMapping("/todos")
	public TodoList createTodoList(@RequestBody TodoList list) {
		return service.createTodoList(list);

	}

	// Endpoint to get all todo lists
	@GetMapping("/todos")
	public List<TodoList> getAllLists() {
		return service.getAllLists();

	}

	// Endpoint to get a todo list by ID
	@GetMapping("/todos/{id}")
	public TodoList getTodoById(@PathVariable int id) {

		return service.getTodoById(id);

	}

	// Endpoint to update a todo list by ID
	@PutMapping("/todos/{id}")
	public TodoList updateList(@PathVariable int id, @RequestBody TodoList list) {
		return service.updateList(id, list);

	}

	// Endpoint to delete a todo list by ID
	@DeleteMapping("/todos/{id}")
	public String deleteList(@PathVariable int id) {
	
		return service.deleteList(id);
			
	}
}
