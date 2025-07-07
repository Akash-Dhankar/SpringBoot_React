package com.example.todoapp.service;

import org.springframework.stereotype.Service;
import com.example.todoapp.controller.TaskController;
import com.example.todoapp.model.Task;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private List<Task> tasks = new ArrayList<>();
    private int counter = 1;

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTaskById(int id) {
        return tasks.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    public Task addTask(Task task) {
        task.setId(counter++);
        task.setStage("Yet to Start");
        tasks.add(task);
        return task;
    }

    public Task updateTask(int id, Task updatedTask) {
        Task existing = getTaskById(id);
        if (existing != null) {
            existing.setTitle(updatedTask.getTitle());
            existing.setDescription(updatedTask.getDescription());
        }
        return existing;
    }

    public boolean deleteTask(int id) {
        return tasks.removeIf(t -> t.getId() == id);
    }

    public Task moveStage(int id, String newStage) {
        Task task = getTaskById(id);
        if (task != null && (newStage.equals("Yet to Start") || newStage.equals("In Progress") || newStage.equals("Completed"))) {
            task.setStage(newStage);
        }
        return task;
    }
}
