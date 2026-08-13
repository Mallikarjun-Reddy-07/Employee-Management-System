


# EMS Day 9 - Global Exception Handling

Employee Management System (EMS) - **Day 9** focuses on implementing **Global Exception Handling** in Spring Boot using custom exceptions and `@RestControllerAdvice`.

The application handles different exceptions centrally and returns appropriate HTTP status codes and error messages to the client.

## 📅 Day 9 - Global Exception Handling

### 🚀 Features

* Global exception handling
* Custom `UserNotFoundException`
* Custom `InvalidOtpException`
* `@RestControllerAdvice`
* `@ExceptionHandler`
* `ResponseEntity`
* Appropriate HTTP status codes
* Centralized error handling

## 🛠️ Technologies Used

* Java
* Spring Boot
* Spring Web
* Spring MVC
* Spring Data JPA
* MySQL
* Maven
* REST API
* Postman

## 📂 Project Structure

```text
ems-day9-global-exception-handling/
│
├── src/
│   └── main/
│       └── java/
│           └── com/tcs/ems/
│               │
│               ├── exception/
│               │   ├── GlobalExceptionHandling.java
│               │   ├── UserNotFoundException.java
│               │   └── InvalidOtpException.java
│               │
│               ├── controller/
│               ├── service/
│               ├── repository/
│               └── entity/
│
├── pom.xml
└── README.md
```

## 🔥 Custom Exceptions

### 1. UserNotFoundException

`UserNotFoundException` is used when a requested user does not exist in the system.

```java
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
```

The exception returns:

```text
HTTP 404 - NOT_FOUND
```

### 2. InvalidOtpException

`InvalidOtpException` is used when the OTP entered by the user is invalid.

```java
public class InvalidOtpException extends RuntimeException {

    public InvalidOtpException(String message) {
        super(message);
    }
}
```

The exception returns:

```text
HTTP 400 - BAD_REQUEST
```

## 🌐 Global Exception Handler

The `GlobalExceptionHandling` class is annotated with:

```java
@RestControllerAdvice
```

It provides centralized exception handling for REST APIs.

### User Not Found

```java
@ExceptionHandler(UserNotFoundException.class)
public ResponseEntity<String> userNotFound(
        UserNotFoundException userNotFoundException) {

    return new ResponseEntity<>(
            userNotFoundException.getMessage(),
            HttpStatus.NOT_FOUND
    );
}
```

### Invalid OTP

```java
@ExceptionHandler(InvalidOtpException.class)
public ResponseEntity<String> invalidOtp(
        InvalidOtpException invalidOtpException) {

    return new ResponseEntity<>(
            invalidOtpException.getMessage(),
            HttpStatus.BAD_REQUEST
    );
}
```

## 📊 Exception & HTTP Status

| Exception               | HTTP Status       | Meaning             |
| ----------------------- | ----------------- | ------------------- |
| `UserNotFoundException` | `404 NOT_FOUND`   | User does not exist |
| `InvalidOtpException`   | `400 BAD_REQUEST` | OTP is invalid      |

## 🧪 Example Responses

### User Not Found

Request:

```http
GET /users/100
```

Response:

```text
HTTP 404 NOT_FOUND

User not found
```

### Invalid OTP

Request:

```http
POST /users/verify-otp
```

Response:

```text
HTTP 400 BAD_REQUEST

Invalid OTP
```

## 🎯 Learning Objectives

Through Day 9, the following concepts are covered:

* Understanding exception handling in Spring Boot
* Creating custom exceptions
* Extending `RuntimeException`
* Using `@RestControllerAdvice`
* Using `@ExceptionHandler`
* Returning `ResponseEntity`
* Choosing appropriate HTTP status codes
* Centralizing exception handling
* Handling REST API errors

## 🔄 EMS Learning Progress

```text
Day 1 - User Registration
Day 2 - Email OTP Verification
Day 3 - OTP Verification
Day 4 - LMS Project
Day 5 - Employee CRUD Operations
Day 6 - Spring Security
Day 7 - REST API / Project Development
Day 8 - Spring Security & Role-Based Authentication
Day 9 - Global Exception Handling
```

## ▶️ How to Run

1. Clone the repository:

```bash
git clone https://github.com/madihaazamahmed-droid/ems-day9-global-exception-handling.git
```

2. Open the project in Eclipse or IntelliJ IDEA.

3. Update Maven dependencies.

4. Configure MySQL if required.

5. Run the Spring Boot application.

6. Test the APIs using Postman.

## 🧪 Testing

Use Postman to test the APIs and verify that:

* Existing users return successful responses.
* Non-existing users return `404 NOT_FOUND`.
* Invalid OTPs return `400 BAD_REQUEST`.

## 👩‍💻 Author

**Madiha Azam Ahmed**

GitHub: `madihaazamahmed-droid`
