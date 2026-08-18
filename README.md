

# Employee Management System

A complete **Employee Management System (EMS)** built using **Java and Spring Boot**, providing secure REST APIs for employee management, user registration, email OTP verification, authentication, authorization, validation, and global exception handling.

---

## 📌 Project Overview

The Employee Management System is a Spring Boot REST API application developed to manage employee-related operations securely and efficiently.

The project was developed progressively, starting with user registration and email OTP verification and extending to employee CRUD operations, Spring Security, JWT authentication, Bean Validation, and centralized exception handling.

### Main Objectives

* User registration
* Email OTP verification
* Secure authentication
* Role-based authorization
* Employee management
* CRUD operations
* Request validation
* Global exception handling
* Clean REST API architecture
* Secure password handling

---

## 🛠️ Technologies Used

### Backend

* Java 21
* Spring Boot
* Spring MVC
* Spring Data JPA
* Hibernate
* Spring Security
* JWT
* Bean Validation
* Jakarta Validation
* Maven

### Database

* MySQL

### Development Tools

* IntelliJ IDEA / Eclipse
* Git
* GitHub
* Postman
* Maven

---

## 🏗️ Project Architecture

The application follows a layered architecture:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

Additional layers:

```text
Client
   ↓
Controller
   ↓
Validation
   ↓
Service
   ↓
Repository
   ↓
MySQL

Exception
   ↓
Global Exception Handler
   ↓
Standardized Error Response
```

---

## 📂 Project Structure

```text
src
└── main
    ├── java
    │   └── com.tcs.ems
    │       ├── config
    │       ├── controller
    │       ├── dto
    │       ├── entity
    │       ├── exception
    │       ├── repository
    │       ├── security
    │       └── service
    │
    └── resources
        ├── application.properties
        └── static
```

---

# 🚀 Features

## 1. User Registration

New users can register using their details.

The registration process includes:

* User details validation
* Password encryption
* Email verification
* OTP generation
* OTP storage
* OTP verification

---

## 2. Email OTP Verification

An OTP is generated and sent to the user's registered email address.

The user must enter the OTP to verify the account.

### OTP Flow

```text
User Registration
       ↓
Generate OTP
       ↓
Send OTP to Email
       ↓
User Enters OTP
       ↓
Verify OTP
       ↓
Account Verified
```

---

## 3. Authentication

The application provides secure authentication using Spring Security and JWT.

After successful login:

```text
Username + Password
        ↓
Authentication
        ↓
JWT Token
        ↓
Authenticated Requests
```

The JWT token is used to access protected APIs.

---

## 4. Password Encryption

Passwords are never stored as plain text.

A `PasswordEncoder` is used to securely encode passwords before storing them in the database.

---

## 5. Spring Security

Spring Security protects the application endpoints.

Public endpoints can be accessed without authentication, while protected endpoints require valid authentication.

Example:

```text
/register       → Public
/verify-otp     → Public
/login          → Public

/employees/**   → Protected
```

---

## 6. Role-Based Authorization

The application supports role-based access control.

Example roles:

```text
ADMIN
USER
```

### ADMIN

An administrator can perform employee management operations such as:

* Create employee
* Update employee
* Delete employee
* View employee information

### USER

A normal user can access permitted employee information according to the configured security rules.

---

# 👨‍💼 Employee Management

The Employee module provides complete CRUD functionality.

## Create Employee

```text
POST /employees
```

Creates a new employee.

---

## Get All Employees

```text
GET /employees
```

Returns all employees.

---

## Get Employee By ID

```text
GET /employees/{id}
```

Returns employee details for the specified ID.

---

## Update Employee

```text
PUT /employees/{id}
```

Updates existing employee information.

---

## Delete Employee

```text
DELETE /employees/{id}
```

Deletes an employee.

---

# ✅ Bean Validation

The application uses Jakarta Bean Validation to validate incoming request data.

Common validation annotations include:

```java
@NotBlank
@NotNull
@Email
@Size
@Min
@Max
```

Example:

```java
@NotBlank(message = "Name is required")
private String name;

@Email(message = "Invalid email format")
private String email;
```

Validation prevents invalid data from entering the application.

---

# ⚠️ Global Exception Handling

The application uses centralized exception handling to provide meaningful error responses.

Custom exceptions include examples such as:

```text
UserNotFoundException
InvalidOtpException
EmployeeNotFoundException
```

A global exception handler handles application exceptions in one place.

---

## MethodArgumentNotValidException

Validation errors are handled using:

```java
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String, String>> invalidData(
        MethodArgumentNotValidException exception) {

    Map<String, String> message = new HashMap<>();

    List<FieldError> errors =
            exception.getBindingResult().getFieldErrors();

    for (FieldError fe : errors) {
        message.put(fe.getField(), fe.getDefaultMessage());
    }

    return new ResponseEntity<>(
            message,
            HttpStatus.BAD_REQUEST
    );
}
```

### Example Response

If the request contains invalid data:

```json
{
    "name": "Name is required",
    "email": "Invalid email format"
}
```

This provides clear validation messages to API clients.

---

# 🔐 Security Flow

The overall authentication flow is:

```text
Register
   ↓
Email OTP Verification
   ↓
Login
   ↓
Username + Password
   ↓
Spring Security
   ↓
JWT Token Generated
   ↓
Client Stores Token
   ↓
Token Sent With Requests
   ↓
Protected API Access
```

---

# 🗄️ Database

The project uses **MySQL** as the relational database.

Typical entities include:

```text
User
Employee
```

Spring Data JPA and Hibernate are used for database interaction.

---

# 🔄 Employee CRUD Flow

```text
Client
  ↓
EmployeeController
  ↓
EmployeeService
  ↓
EmployeeRepository
  ↓
Hibernate / JPA
  ↓
MySQL
```

---

# 📡 REST API

The project follows RESTful API principles.

| Method | Endpoint          | Purpose            |
| ------ | ----------------- | ------------------ |
| POST   | `/register`       | Register user      |
| POST   | `/verify-otp`     | Verify OTP         |
| POST   | `/login`          | Authenticate user  |
| POST   | `/employees`      | Create employee    |
| GET    | `/employees`      | Get all employees  |
| GET    | `/employees/{id}` | Get employee by ID |
| PUT    | `/employees/{id}` | Update employee    |
| DELETE | `/employees/{id}` | Delete employee    |

> Endpoint names may vary depending on the final controller mappings in the project.

---

# 📋 API Testing

APIs can be tested using **Postman**.

Recommended testing sequence:

```text
1. Register User
        ↓
2. Receive OTP
        ↓
3. Verify OTP
        ↓
4. Login
        ↓
5. Copy JWT Token
        ↓
6. Add Bearer Token in Postman
        ↓
7. Access Employee APIs
```

---

# ⚙️ Configuration

Update `application.properties` with your local database configuration.

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ems
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

For email OTP functionality, configure your SMTP settings:

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=YOUR_EMAIL
spring.mail.password=YOUR_APP_PASSWORD

spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

### ⚠️ Security

Never upload real passwords, Gmail App Passwords, JWT secrets, API keys, or other credentials to GitHub.

Use environment variables or a local configuration file that is excluded from Git.

---

# ▶️ How to Run the Project

## 1. Clone the Repository

```bash
git clone https://github.com/madihaazamahmed-droid/employee_management_system.git
```

## 2. Open the Project

Open the project using:

* IntelliJ IDEA
* Eclipse
* Spring Tool Suite

---

## 3. Configure MySQL

Create a database:

```sql
CREATE DATABASE ems;
```

Update your database username and password in:

```text
application.properties
```

---

## 4. Build the Project

Using Maven:

```bash
mvn clean install
```

---

## 5. Run the Application

```bash
mvn spring-boot:run
```

Or run the main Spring Boot application class from your IDE.

---

# 🧪 Testing

The APIs can be tested using:

* Postman
* Browser for GET endpoints
* Unit tests
* Integration testing

Important test cases include:

* Valid registration
* Invalid registration data
* Duplicate email
* Invalid OTP
* Expired/incorrect OTP
* Valid login
* Invalid login
* Missing JWT token
* Invalid JWT token
* Unauthorized role
* Employee not found
* Invalid employee data

---

# 📈 Learning Progression

This project was developed progressively as an Employee Management System learning project.

```text
Day 1-2
User Registration + Email OTP
        ↓
Day 3
OTP Verification
        ↓
Day 4
LMS / Project Integration
        ↓
Day 5
Employee CRUD Operations
        ↓
Day 6
Spring Security
        ↓
JWT Authentication
        ↓
Validation
        ↓
Global Exception Handling
        ↓
Complete Employee Management System
```

---

# 🎯 Key Concepts Learned

Through this project, the following concepts were implemented:

* Java
* Object-Oriented Programming
* Spring Boot
* REST APIs
* Dependency Injection
* Spring MVC
* Spring Data JPA
* Hibernate
* MySQL
* DTOs
* Repository Pattern
* Service Layer
* Controller Layer
* CRUD Operations
* Email Integration
* OTP Verification
* Password Encryption
* Spring Security
* JWT Authentication
* Role-Based Authorization
* Bean Validation
* Custom Exceptions
* Global Exception Handling
* HTTP Status Codes
* Postman API Testing
* Maven
* Git
* GitHub

---

# 💡 Project Highlights

### 🔹 Secure Authentication

Implemented authentication using Spring Security and JWT.

### 🔹 Role-Based Access

Different access permissions can be configured for ADMIN and USER roles.

### 🔹 Data Validation

Invalid request data is rejected using Bean Validation.

### 🔹 Centralized Exception Handling

Application exceptions and validation errors are handled centrally.

### 🔹 Database Integration

Employee and user information is persisted using Spring Data JPA, Hibernate, and MySQL.

### 🔹 RESTful Architecture

The application exposes REST APIs for client interaction.

---

# 📌 Future Enhancements

Possible future improvements:

* Pagination and sorting
* Search employees by name/email
* Employee department management
* Employee salary management
* Profile management
* Refresh tokens
* Password reset through email
* Swagger/OpenAPI documentation
* Unit and integration tests
* Docker support
* Frontend using React.js
* Deployment using AWS/Azure
* CI/CD using GitHub Actions

---

# 👩‍💻 Author

**Madiha Azam Ahmed**

GitHub:

[https://github.com/madihaazamahmed-droid](https://github.com/madihaazamahmed-droid)

---

# ⭐ Project

**Employee Management System**

Built with:

```text
Java
Spring Boot
Spring Security
JWT
JPA / Hibernate
MySQL
Bean Validation
Global Exception Handling
Maven
Git & GitHub
```

If you found this project useful, consider giving the repository a ⭐.
