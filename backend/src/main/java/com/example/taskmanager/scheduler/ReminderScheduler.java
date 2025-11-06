package com.example.taskmanager.scheduler;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import com.example.taskmanager.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ReminderScheduler {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmailService emailService;

    // Runs every hour (adjust cron as needed)
    @Scheduled(cron = "0 0 * * * *")
    public void sendReminders() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime next24Hours = now.plusHours(24);

        // ✅ Using LocalDateTime here (matches repository method)
        List<Task> upcomingTasks = taskRepository.findByDueDateBetween(now, next24Hours);

        for (Task task : upcomingTasks) {
            if (task.getUser() != null && task.getUser().getEmail() != null) {
                emailService.sendEmail(
                        task.getUser().getEmail(),
                        "Task Reminder: " + task.getTitle(),
                        "Don't forget! Your task \"" + task.getTitle() + "\" is due on " + task.getDueDate()
                );
            }
        }
    }
}
