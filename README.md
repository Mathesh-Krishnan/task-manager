<-- 📝 Task Manager — Spring Boot + React -->

## 📌 Overview
**Task Manager** is a full-stack application built using **Spring Boot (Java)** for the backend and **React** for the frontend.  
It allows users to **add and manage tasks with specific due dates**, and automatically **sends an email reminder** when a task’s due date arrives.  

This project demonstrates full-stack development with RESTful APIs, frontend-backend integration, and email automation.

<-- 🚀 Features -->
✅ Add new tasks with title, description, and due date  
✅ View and manage your tasks in an intuitive UI  
✅ Automated email reminder when the due date arrives  
✅ Spring Boot backend with REST API  
✅ React frontend with clean UI and form validation  

<-- 🧰 Tech Stack -->
**Frontend:** React, HTML, CSS, JavaScript  
**Backend:** Spring Boot, Java, Maven  
**Database:** (You can specify — e.g., MySQL / H2)  
**Email:** JavaMailSender (SMTP with Gmail)  

<-- 🧑‍💻 How to Run the Project -->

🔹 Backend (Spring Boot)
1. Open the **backend** folder in **IntelliJ IDEA** or **VS Code**.
2. Configure environment variables in your run configuration.
3. Run the Spring Boot application.

The Backend will start on localhost.

🔹 Frontend (React)
1. Open the **frontend** folder in a new terminal.
2. Install dependencies.
3. Start the development Server.

<-- 📧 Email Reminder Setup -->
To enable email reminders:
1. Use a Gmail account with **App Passwords** enabled.  
2. Set these environment variables.
    EMAIL_USER = YOUR EMAIL
    EMAIL_PASS = YOUR APP PASSWORD (not you gmail login password)

<-- 🛡️ Security Note -->
Sensitive credentials (SMTP, API keys, etc.) are **never committed** to the repository.  
They are securely managed using **environment variables**.



