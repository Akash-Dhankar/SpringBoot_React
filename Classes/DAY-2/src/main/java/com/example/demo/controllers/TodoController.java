package com.example.demo.controllers;

import com.example.demo.models.Todo;
import com.example.demo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    //ALREADY PRESENT IN EMPLOYEECONTROLLER.JAVA , SO COMMENTING THESE

//    @GetMapping("/employee/{empId}/todos")
//    public List<Todo> getTodosByEmployee(@PathVariable int empId) {
//        return todoService.getTodosByEmployeeId(empId);
//    }
//
//    @PostMapping("/employee/{empId}/todos")
//    public String addTodo(@PathVariable int empId, @RequestBody Todo todo) {
//        return todoService.addTodoToEmployee(empId, todo);
//    }

    @PutMapping("/todos/{todoId}/status")
    public String updateStatus(@PathVariable int todoId, @RequestParam String status) {
        return todoService.updateTodoStatus(todoId, status);
    }

    @DeleteMapping("/todos/{todoId}")
    public String deleteTodo(@PathVariable int todoId) {
        return todoService.deleteTodoById(todoId);
    }
}
