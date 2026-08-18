# EMS - Day 11: Validation & Global Exception Handling

## 📌 Project Overview

This project is part of the **Employee Management System (EMS)** series developed using **Spring Boot**.

Day 11 focuses on implementing **Bean Validation and Global Exception Handling** to provide proper validation messages and handle application exceptions in a centralized way.

## 🚀 Features

* Employee validation using Jakarta Bean Validation
* Email format validation
* Required field validation
* Salary validation
* Global exception handling using `@RestControllerAdvice`
* Custom exception handling using `@ExceptionHandler`
* Validation error handling using `MethodArgumentNotValidException`
* Custom responses with appropriate HTTP status codes

## 🛠️ Technologies Used

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* MySQL
* Jakarta Validation
* Lombok
* Maven
* Git & GitHub

## 📂 Validations Implemented

| Field      | Validation            |
| ---------- | --------------------- |
| Email      | `@Email`, `@NotBlank` |
| Name       | `@NotBlank`           |
| Salary     | `@PositiveOrZero`     |
| Department | `@NotBlank`           |

## ⚠️ Exception Handling

The application handles exceptions such as:

* `MethodArgumentNotValidException`
* `UserNotFoundException`
* `InvalidOtpException`
* `OtpVerifiedException`
* `OtpExpiredException`
* `OtpAlreadyVerified`

Global exception handling is implemented using:

```java
@RestControllerAdvice
```

and

```java
@ExceptionHandler
```

## 📋 Example Validation Request

```json
{
    "email": "abc",
    "name": "",
    "salary": -500,
    "department": ""
}
```

### Example Response

```json
{
    "email": "enter valid email id",
    "name": "it cannot be null, empty, space",
    "salary": "salary should be >= 0",
    "department": "it cannot be null, empty, space"
}
```

## 📁 Project Structure

```text
src
└── main
    └── java
        └── com.tcs.ems
            ├── controller
            ├── entity
            ├── repository
            ├── service
            └── exception
                ├── GlobalExceptionHandling.java
                ├── UserNotFoundException.java
                ├── InvalidOtpException.java
                ├── OtpVerifiedException.java
                ├── OtpExpiredException.java
                └── OtpAlreadyVerified.java
```

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone https://github.com/madihaazamahmed-droid/ems-day11-validation-exception-handling.git
```

### 2. Open the project

Open the project in **Eclipse** or **IntelliJ IDEA**.

### 3. Configure MySQL

Update your database details in:

```text
src/main/resources/application.properties
```

### 4. Run the application

Run the Spring Boot application.

The APIs can be tested using **Postman**.

## 🎯 Day 11 Learning

Through this project, I learned how to:

* Implement Jakarta Bean Validation
* Create custom validation messages
* Handle validation errors globally
* Create custom exceptions
* Use `@RestControllerAdvice`
* Use `@ExceptionHandler`
* Return appropriate HTTP status codes
* Build cleaner and more maintainable Spring Boot applications

## 👩‍💻 Author

**Madiha Azam Ahmed**

GitHub: `madihaazamahmed-droid`
