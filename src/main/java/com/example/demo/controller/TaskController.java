package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/tasks")   // Base URL
public class TaskController {


    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Post new task
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    // Post bulk amount of tasks
    @PostMapping("/bulk")
    public List<Task> createTasks(@RequestBody List<Task> tasks) {
        return taskService.createTasks(tasks);
    }

    // Return all tasks
    @GetMapping
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    // Return specific task
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    // Update specific task
    @PutMapping("/{id}")
    public Task updateTaskById(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTaskById(id, task);
    }

    // Delete specific task
    @DeleteMapping("/{id}")
    public Task deleteTaskById(@PathVariable Long id) {
        return taskService.deleteTaskById(id);
    }
}