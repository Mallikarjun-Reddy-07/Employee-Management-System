# EMS – Spring Boot Security & Employee Management System

A Spring Boot-based **Employee Management System (EMS)** secured using **Spring Security**. The project provides user registration, OTP verification, authentication, and protected employee APIs.

## 🚀 Features

* User Registration
* Email OTP Verification
* OTP Validation
* Spring Security integration
* HTTP Basic Authentication
* Role-based authorization
* Admin and User roles
* Protected Employee APIs
* RESTful APIs
* Password encryption using `PasswordEncoder`
* In-memory user authentication

## 🛠️ Technologies Used

* Java
* Spring Boot
* Spring Security
* Spring Web
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* REST API
* Git & GitHub

## 🔐 Security

The application uses **Spring Security** with HTTP Basic Authentication.

### Public APIs

```text
POST /users/register
POST /users/verify-otp
```

These endpoints are accessible without authentication.

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

Passwords are encoded using Spring Security's `PasswordEncoder`.

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

Employee endpoints are protected using Spring Security.

```text
GET    /employees
GET    /employees/{id}
POST   /employees
PUT    /employees/{id}
DELETE /employees/{id}
```

Authentication is required for these endpoints.

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
             │   └── UserController.java
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

The application permits registration and OTP verification without authentication:

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

HTTP Basic Authentication is enabled using:

```java
.httpBasic(Customizer.withDefaults());
```

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone https://github.com/YOUR-USERNAME/ems-springboot-security-employee-management.git
```

### 2. Navigate to the project

```bash
cd ems-springboot-security-employee-management
```

### 3. Configure MySQL

Create a database:

```sql
CREATE DATABASE ems;
```

Update your `application.properties` with your database credentials.

### 4. Run the application

Using Maven:

```bash
mvn spring-boot:run
```

Or run the main Spring Boot application from IntelliJ IDEA/Eclipse.

## 🧪 Testing

You can test the APIs using:

* Postman
* Thunder Client
* Browser for GET requests with authentication

For protected APIs, provide **Basic Auth** credentials.

Example:

```text
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
Login / Authentication
  ↓
Access Employee APIs
```

## 📈 Future Enhancements

* JWT Authentication
* Database-based user authentication
* Role-based endpoint authorization
* Refresh Tokens
* Forgot Password
* Password Reset using OTP
* Global Exception Handling
* Swagger/OpenAPI documentation
* Docker deployment

## 👩‍💻 Author

**Madiha Azam Ahmed**

Java Full Stack Developer | Spring Boot | React.js | MySQL
