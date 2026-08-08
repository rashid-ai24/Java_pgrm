# SMCE

A simple Spring Boot student management REST API.

## Overview

This project provides CRUD operations for a `Student` entity using Spring Boot.
It includes a basic REST controller, service layer, repository, and entity model.

## Features

- List all students
- Get a student by ID
- Add a student
- Update a student
- Delete a student

## Project Structure

- `src/main/java/com/example/smce/SmceApplication.java` - Spring Boot application entry point
- `src/main/java/com/example/smce/controller/StudentController.java` - REST endpoints for students
- `src/main/java/com/example/smce/service/StudentService.java` - business logic layer
- `src/main/java/com/example/smce/entity/Student.java` - student model
- `src/main/java/com/example/smce/repository/StudentRepository.java` - data access layer

## Requirements

- Java 17
- Maven

## Run

From the project root:

```powershell
./mvnw.cmd spring-boot:run
```

Or on systems with execute permissions:

```bash
./mvnw spring-boot:run
```

## API Endpoints

- `GET /students` - get all students
- `GET /students/{id}` - get student by ID
- `POST /students` - add a new student
- `PUT /students` - update a student
- `DELETE /students/{id}` - delete a student by ID

## Notes

This project currently relies on an in-memory repository for student data.
A database implementation can be added later if persistent storage is required.
