# E-Learning System (Java)

A console-based Java application demonstrating Object-Oriented Programming (OOP) through a simple e-learning workflow.

## Features

- Role-based access for Admin and Student users
- Admin can create and list courses
- Students can view available courses
- Students can enroll in courses
- Students can update learning progress from 0–100%
- Students can view enrolled courses and progress
- Input validation for menu choices and progress values

## Java / OOP Concepts Used

- Classes and objects
- Inheritance (`User` -> `Admin`, `Student`)
- Abstraction using an abstract `User` class
- Encapsulation using private fields and controlled methods
- Method overriding (`getRole()`)
- Collections: `Map`, `LinkedHashMap`, `HashMap`, `Set`
- Separation of responsibilities through `LearningService`

## Project Structure

```text
e-learning-system/
├── README.md
└── src/
    └── ELearningSystem.java
```

## Requirements

- JDK 17 or later (the project uses modern switch expressions)

## Run

From the repository root:

```bash
cd e-learning-system/src
javac ELearningSystem.java
java ELearningSystem
```

## Example Workflow

1. Select **Admin** and add a new course.
2. Return to the role menu and select **Student**.
3. List available courses and enroll using a course ID.
4. Update progress for the enrolled course.
5. Open **My Learning** to view progress.

## Purpose

This project was developed as a compact demonstration of core Java programming, OOP design, role-based functionality, collections, and console input handling.
