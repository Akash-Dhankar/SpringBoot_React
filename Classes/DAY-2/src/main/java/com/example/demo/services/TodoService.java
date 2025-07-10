package com.example.demo.services;

import com.example.demo.models.Todo;
import com.example.demo.models.RegisterDetails;
import com.example.demo.repository.RegisterDetailsRepository;
import com.example.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private RegisterDetailsRepository registerDetailsRepository;

    public List<Todo> getTodosByEmployeeId(int empId) {
        return todoRepository.findByEmployeeEmpId(empId);
    }

    public String addTodoToEmployee(int empId, Todo todo) {
        RegisterDetails emp = registerDetailsRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        todo.setEmployee(emp);
        todoRepository.save(todo);
        return "Todo Added Successfully!";
    }

    public String deleteTodoById(int todoId) {
        todoRepository.deleteById(todoId);
        return "Todo Deleted";
    }

    public String updateTodoStatus(int todoId, String status) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setStatus(status);
        todoRepository.save(todo);
        return "Todo Updated!";
    }
}
