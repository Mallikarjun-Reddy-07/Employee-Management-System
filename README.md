# EMS – Day 6: Spring Security

A Spring Boot-based **Employee Management System (EMS)** implementing Spring Security, HTTP Basic Authentication, user registration, OTP verification, and protected employee APIs.

## 🚀 Features

* User Registration
* Email OTP Verification
* OTP Validation
* Spring Security
* HTTP Basic Authentication
* Role-based Authorization
* Admin and User Roles
* Protected Employee APIs
* RESTful APIs
* Password Encryption
* In-memory Authentication

## 🛠️ Technologies Used

* Java 21
* Spring Boot
* Spring Security
* Spring Web
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* JavaMailSender
* Git & GitHub

## 🔐 Security

The application uses **Spring Security** with HTTP Basic Authentication.

### Public APIs

```text
POST /users/register
POST /users/verify-otp
```

These APIs are accessible without authentication.

### Protected APIs

```text
/employees/**
```

Employee APIs require authentication.

## 👤 Default Users

### Admin

```text
Username: admin
Password: admin123
Role: ADMIN
```

### User

```text
Username: user
Password: user123
Role: USER
```

Passwords are encoded using `PasswordEncoder`.

## 📌 API Endpoints

### 1. Register User

```http
POST /users/register
```

Example request:

```json
{
  "name": "Madiha",
  "email": "madiha@gmail.com",
  "password": "123456"
}
```

### 2. Verify OTP

```http
POST /users/verify-otp
```

Example request:

```json
{
  "email": "madiha@gmail.com",
  "otp": "123456"
}
```

### 3. Employee APIs

```text
GET    /employees
GET    /employees/{id}
POST   /employees
PUT    /employees/{id}
DELETE /employees/{id}
```

Authentication is required for employee APIs.

## 📂 Project Structure

```text
src
└── main
    └── java
        └── com.tcs.ems
            ├── config
            │   └── SecurityConfig.java
            │
            ├── controller
            │   ├── UserController.java
            │   └── EmployeeController.java
            │
            ├── dto
            │   ├── RegisterRequest.java
            │   └── VerifyOtpRequest.java
            │
            ├── service
            │   ├── UserService.java
            │   └── OtpService.java
            │
            ├── entity
            │   └── Employee.java
            │
            └── repository
                └── EmployeeRepository.java
```

## 🔑 Security Configuration

Registration and OTP verification are publicly accessible:

```java
.requestMatchers(
    "/users/register",
    "/users/verify-otp"
).permitAll()
```

Employee APIs require authentication:

```java
.requestMatchers("/employees/**").authenticated()
```

HTTP Basic Authentication:

```java
.httpBasic(Customizer.withDefaults());
```

## ▶️ How to Run

### Clone the repository

```bash
git clone https://github.com/madihaazamahmed-droid/ems-day6-spring-security.git
```

### Navigate to the project

```bash
cd ems-day6-spring-security
```

### Configure MySQL

Create the database:

```sql
CREATE DATABASE ems;
```

Update your `application.properties` with your MySQL credentials.

### Run the application

```bash
mvn spring-boot:run
```

Or run the application from IntelliJ IDEA or Eclipse.

## 🧪 Testing

Use **Postman** or **Thunder Client** to test the APIs.

For protected employee APIs, use:

```text
Authentication Type: Basic Auth

Username: admin
Password: admin123
```

## 🔒 Authentication Flow

```text
User
  ↓
Register
  ↓
OTP Sent
  ↓
Verify OTP
  ↓
User Verified
  ↓
Authentication
  ↓
Access Employee APIs
```

## 📈 Future Enhancements

* JWT Authentication
* Database-based User Authentication
* Role-Based Endpoint Authorization
* Refresh Tokens
* Forgot Password
* Resend OTP
* Global Exception Handling
* Swagger/OpenAPI Documentation
* Docker Deployment

## 👩‍💻 Author

**Madiha Azam Ahmed**

Java Full Stack Developer | Spring Boot | React.js | MySQL
