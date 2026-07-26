# UPL Tutorial Management System

A Spring Boot based backend application for managing online tutorials, courses, instructors, students, enrollments, and learning progress with secure JWT authentication and role-based authorization.

## 🚀 Features

### Authentication & Security
- JWT based authentication
- Role-based authorization
- Secure API endpoints
- ADMIN, INSTRUCTOR, and STUDENT roles

### Admin Module
- Approve/reject instructor registrations
- Manage courses
- Delete courses
- Manage system users

### Instructor Module
- Register as instructor
- Create courses
- Create tutorials
- Manage tutorial content

### Student Module
- View available courses
- Enroll in courses
- Complete tutorials
- Track learning progress
- View course completion percentage

## 🛠️ Technologies Used

### Backend
- Java 21
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA
- Hibernate

### Database
- MySQL

### Tools
- IntelliJ IDEA
- Postman
- MySQL Workbench
- Git & GitHub

## 🏗️ Project Architecture

```
Controller Layer
        |
        ↓
Service Layer
        |
        ↓
Repository Layer
        |
        ↓
MySQL Database
```

## 📂 Project Modules

```
upl-tutorial-backend

├── authentication
├── user management
├── instructor management
├── course management
├── tutorial management
├── enrollment management
└── student progress tracking
```

## 🔐 Security Flow

```
User Login
     |
     ↓
JWT Token Generation
     |
     ↓
JWT Filter Validation
     |
     ↓
Role Authorization
     |
     ↓
Protected API Access
```

## 🗄️ Database Tables

- user_master
- course_master
- tutorial_master
- instructor_approval_log
- course_edit_history
- tutorial_edit_history
- student_course_enrollment
- student_progress

## ▶️ How to Run the Project

### Clone Repository

```
git clone https://github.com/Sandeep-GV/upl-tutorial-backend.git
```

### Configure Database

Update:

```
application.properties
```

with your MySQL configuration.

### Run Application

Using Maven:

```
mvn spring-boot:run
```

Application runs on:

```
http://localhost:8080
```

## 📌 API Testing

API testing was performed using:

- Postman

Implemented APIs:

- Authentication APIs
- Course APIs
- Tutorial APIs
- Enrollment APIs
- Student Dashboard APIs

## 👨‍💻 Author

Sandeep G V

Information Science and Engineering Student

GitHub:
https://github.com/Sandeep-GV