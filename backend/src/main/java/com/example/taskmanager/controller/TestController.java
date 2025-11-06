package com.example.taskmanager.controller;

import com.example.taskmanager.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/test-email")
    public String sendTestEmail() {
        emailService.sendEmail(
                "matheshkrish006@gmail.com", // recipient
                "Task Manager Test Mail",
                "✅ Hello! Your email configuration is working perfectly."
        );
        return "Test email sent successfully!";
    }
}
