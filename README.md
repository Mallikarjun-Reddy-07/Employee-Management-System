# ems-day1-day2-user-registration-email-otp
Employee Management System (EMS) | Day 1: User Registration | Day 2: Email OTP Verification using Spring Boot, Spring Data JPA, JavaMailSender, and MySQL.


A Spring Boot-based Employee Management System (EMS) developed as a day-wise learning project.

## 📅 Project Progress

### ✅ Day 1 - User Registration

- User Registration API
- Save user details in MySQL
- Duplicate email validation
- Spring Data JPA integration
- RESTful API implementation

### ✅ Day 2 - Email OTP Verification

- Generate secure 6-digit OTP
- Send OTP via email using JavaMailSender
- Store OTP in the database
- OTP expiry (5 minutes)
- Email verification during user registration

## 🛠️ Technologies Used

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Mail
- MySQL
- Lombok
- Maven

## 📂 Project Structure

```
src
├── controller
├── dto
├── entity
├── repository
├── service
└── util
```

## 🚀 API Endpoint

### Register User

```http
POST /users/register
```

#### Request Body

```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "password123"
}
```

#### Response

```
Please check your email for OTP.
```

## 📌 Upcoming Days

- 🔄 Day 3 - OTP Verification API
- 🔐 Day 4 - Spring Security & BCrypt Password Encryption
- 🔑 Day 5 - JWT Authentication
- 👤 Day 6 - Login API
- 🔁 Day 7 - Forgot Password & Resend OTP
- 🧑‍💼 Employee CRUD Operations
- 🎭 Role-Based Authorization

## 👩‍💻 Author

**Madiha Azam Ahmed**
