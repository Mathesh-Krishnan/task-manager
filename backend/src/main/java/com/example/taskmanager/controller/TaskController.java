package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import com.example.taskmanager.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:3000") // allow frontend access
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmailService emailService;

    // ✅ Create new task + send email
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        Task savedTask = taskRepository.save(task);

        // Send email after saving the task
        try {
            emailService.sendEmail(
                    "receiver@example.com",  // 👉 Replace with user email (dynamic if your User has email field)
                    "📋 New Task Assigned: " + savedTask.getTitle(),
                    "Hello,\n\nYou have a new task assigned:\n\n" +
                            "📝 Title: " + savedTask.getTitle() + "\n" +
                            "📄 Description: " + savedTask.getDescription() + "\n" +
                            "📅 Due Date: " + savedTask.getDueDate() + "\n\n" +
                            "Please complete it before the deadline.\n\nRegards,\nTask Manager"
            );
        } catch (Exception e) {
            System.out.println("⚠️ Failed to send email: " + e.getMessage());
        }

        return savedTask;
    }

    // ✅ Get all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // ✅ Delete task by ID
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}
