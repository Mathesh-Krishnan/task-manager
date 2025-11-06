package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Save a new task
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Get task by ID
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    // Delete task
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    // ✅ New method for ReminderScheduler
    public List<Task> getTasksDueBetween(LocalDateTime start, LocalDateTime end) {
        return taskRepository.findByDueDateBetween(start, end);
    }
}
