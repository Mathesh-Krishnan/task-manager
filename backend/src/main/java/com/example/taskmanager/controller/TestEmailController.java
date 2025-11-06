package com.example.taskmanager.controller;

import com.example.taskmanager.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test-email")
public class TestEmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping
    public String sendTestEmail() {
        emailService.sendEmail(
                "matheshkrish006@gmail.com",  // ✅ change to your real Gmail
                "✅ Test Email from Task Manager",
                "Hello! This is a test email from your Task Manager app."
        );
        return "Test email sent!";
    }
}
