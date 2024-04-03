package com.nxtwave.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nxtwave.todolist.model.TodoList;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList , Integer>
{

	

}
