package com.example.todoapp.controller;

import com.example.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.todoapp.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable int id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id) {
        boolean deleted = taskService.deleteTask(id);
        return deleted ? "Task deleted" : "Task not found";
    }

    @PutMapping("/{id}/move")
    public Task moveTaskStage(@PathVariable int id, @RequestBody String newStage) {
        return taskService.moveStage(id, newStage);
    }
}
