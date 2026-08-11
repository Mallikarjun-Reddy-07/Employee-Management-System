
# Employee Management System (EMS) – Day 7: JWT Authentication

A Spring Boot-based Employee Management System implementing **JWT (JSON Web Token) authentication and authorization** using Spring Security.

## 📌 Day 7 – JWT Authentication

In this phase of the EMS project, authentication is upgraded from HTTP Basic Authentication to **JWT-based authentication**.

JWT allows users to authenticate once and use the generated token to access protected APIs.

## 🔐 Features

* JWT-based authentication
* JWT token generation
* JWT token validation
* Spring Security integration
* Role-based authorization
* ADMIN and USER roles
* Password encryption using PasswordEncoder
* Secured Employee APIs
* Stateless authentication

## 👥 Roles

### ADMIN

* Can access all employee operations
* Can create employees
* Can update employees
* Can delete employees
* Can view employees

### USER

* Can view employee information
* Cannot perform admin-only operations

## 🔑 Authentication Flow

```text
User
  ↓
Login API
  ↓
Username & Password Validation
  ↓
JWT Token Generated
  ↓
Client Stores Token
  ↓
Token Sent in Authorization Header
  ↓
JWT Filter Validates Token
  ↓
Spring Security
  ↓
Protected API
```

## 🛠️ Technologies Used

* Java 21
* Spring Boot
* Spring Security
* JWT
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* REST API
* Git & GitHub

## 📂 Project Structure

```text
src
└── main
    └── java
        └── com.tcs.ems
            ├── config
            │   └── SecurityConfig.java
            ├── controller
            ├── service
            ├── repository
            ├── entity
            ├── dto
            └── security
                ├── JwtService.java
                └── JwtAuthenticationFilter.java
```

## 🔑 JWT Authentication

After successful login, the server generates a JWT token.

The token is sent with subsequent requests using:

```text
Authorization: Bearer <JWT_TOKEN>
```

The JWT filter extracts and validates the token before allowing access to protected APIs.

## 🧪 Testing with Postman

### 1. Login

Send the user's username and password to the login endpoint.

Example:

```text
POST /auth/login
```

Request:

```json
{
  "username": "admin",
  "password": "admin123"
}
```

The response contains a JWT token.

### 2. Access Protected API

Add the token in Postman:

```text
Authorization: Bearer <JWT_TOKEN>
```

Then access the protected Employee APIs.

## 🔒 Role-Based Authorization

| Role  | GET Employees | POST | PUT | DELETE |
| ----- | ------------- | ---- | --- | ------ |
| ADMIN | ✅             | ✅    | ✅   | ✅      |
| USER  | ✅             | ❌    | ❌   | ❌      |

## 🚀 How to Run

### 1. Clone the repository

```bash
git clone https://github.com/madihaazamahmed-droid/ems-day7-jwt-authentication.git
```

### 2. Configure MySQL

Update `application.properties` with your database configuration.

### 3. Build the project

```bash
mvn clean install
```

### 4. Run the application

```bash
mvn spring-boot:run
```

## 🎯 Learning Outcome

This project demonstrates how to implement **stateless authentication using JWT** with Spring Security and how to combine JWT authentication with **role-based authorization** for securing REST APIs.

## 👩‍💻 Author

**Madiha Azam Ahmed**

GitHub: `madihaazamahmed-droid`
