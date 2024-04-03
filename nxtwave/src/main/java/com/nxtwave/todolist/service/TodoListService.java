package com.nxtwave.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.nxtwave.todolist.model.TodoList;
import com.nxtwave.todolist.repository.TodoListRepository;

@Service
public class TodoListService {

    @Autowired
    private TodoListRepository repository;

    public TodoList createTodoList(TodoList list) {
        return repository.save(list);
    }

    public List<TodoList> getAllLists() {
        return repository.findAll();
    }

    public TodoList getTodoById(int id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found with id: " + id));
    }

    public String deleteList(int id) {
        TodoList todo = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found with id: " + id));
        repository.delete(todo);
        return "Deleted";
    }

    public TodoList updateList(int id, TodoList list) {
        return repository.findById(id)
            .map(todoList -> {
              
                todoList.setStatus(list.getStatus());
           
                return repository.save(todoList);
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo List not found with id: " + id));
    }
}
