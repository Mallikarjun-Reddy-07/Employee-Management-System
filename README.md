

## 📚 Day 5 Topic

### Employee CRUD Operations

CRUD stands for:

- **C** - Create
- **R** - Read
- **U** - Update
- **D** - Delete

The project implements all four operations for managing employee records.

---

## 🛠️ Technologies Used

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Jakarta Validation
- REST API
- Postman

---

## 📚 Topics Covered

### 1. Entity Creation

Created an `Employee` entity using:

```java
@Entity
@Table
@Id
@GeneratedValue
````

Employee fields:

* ID
* Email
* Name
* Salary
* Department

---

### 2. Spring Data JPA

Created `EmployeeRepository` by extending:

```java
JpaRepository<Employee, Long>
```

Used built-in methods such as:

```text
save()
findById()
findAll()
deleteById()
```

---

### 3. Controller-Service-Repository Architecture

Implemented a layered architecture:

```text
Client / Postman
       ↓
EmployeeController
       ↓
EmployeeService
       ↓
EmployeeRepository
       ↓
MySQL Database
```

---

### 4. Create Employee

**POST**

```text
POST /employees
```

Example:

```json
{
    "email": "madiha@gmail.com",
    "name": "Madiha",
    "salary": 40000,
    "department": "IT"
}
```

---

### 5. Get All Employees

**GET**

```text
GET /employees
```

Returns all employee records stored in the database.

---

### 6. Get Employee By ID

**GET**

```text
GET /employees/{id}
```

Example:

```text
GET http://localhost:8083/employees/1
```

Returns the employee associated with the given ID.

---

### 7. Update Employee

**PUT**

```text
PUT /employees/{id}
```

Example:

```text
PUT http://localhost:8083/employees/1
```

Request body:

```json
{
    "email": "madiha.updated@gmail.com",
    "name": "Madiha Azam",
    "salary": 50000,
    "department": "Development"
}
```

---

### 8. Delete Employee

**DELETE**

```text
DELETE /employees/{id}
```

Example:

```text
DELETE http://localhost:8083/employees/1
```

Deletes the employee with the specified ID.

---

## 🔗 API Endpoints

| HTTP Method | Endpoint          | Operation          |
| ----------- | ----------------- | ------------------ |
| POST        | `/employees`      | Create Employee    |
| GET         | `/employees`      | Get All Employees  |
| GET         | `/employees/{id}` | Get Employee By ID |
| PUT         | `/employees/{id}` | Update Employee    |
| DELETE      | `/employees/{id}` | Delete Employee    |

---

## 📂 Project Structure

```text
src/main/java/com/tcs/ems

├── controller
│   └── EmployeeController.java
│
├── entity
│   └── Employee.java
│
├── repository
│   └── EmployeeRepository.java
│
├── service
│   └── EmployeeService.java
│
└── EmsApplication.java
```

---

## 🗄️ Database Configuration

Create a MySQL database:

```sql
CREATE DATABASE ems;
```

Configure `application.properties`:

```properties
spring.application.name=ems

server.port=8083

spring.datasource.url=jdbc:mysql://localhost:3306/ems
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Replace `YOUR_PASSWORD` with your MySQL password.

---

## 🧪 API Testing

All CRUD APIs were tested using **Postman**.

### Create

```text
POST http://localhost:8083/employees
```

### Get All

```text
GET http://localhost:8083/employees
```

### Get By ID

```text
GET http://localhost:8083/employees/1
```

### Update

```text
PUT http://localhost:8083/employees/1
```

### Delete

```text
DELETE http://localhost:8083/employees/1
```

---

## ✅ Validation

The project uses Jakarta Validation annotations:

```java
@NotBlank
@Email
@Positive
```

These validations are used for employee details such as:

* Email
* Name
* Salary
* Department

---

## 🎯 Day 5 Learning Outcomes

Through this project, I learned:

* How to build REST APIs using Spring Boot
* How to implement CRUD operations
* How to use Spring Data JPA
* How Hibernate works with JPA
* How to connect Spring Boot with MySQL
* How to use `JpaRepository`
* How to use `@PathVariable`
* How to use `@RequestBody`
* How to implement Controller-Service-Repository architecture
* How to test REST APIs using Postman
* How to validate entity fields

---

## 📌 Future Improvements

* Global exception handling
* DTO implementation
* Pagination and sorting
* Search employees by name
* Search employees by department
* Spring Security
* JWT authentication
* Swagger/OpenAPI documentation
* Unit testing

---

## 👩‍💻 Author

**Madiha Azam Ahmed**

Java | Spring Boot | REST API | MySQL

````

### GitHub Topics

Add these to the repository:

```text
java
spring-boot
spring-data-jpa
hibernate
mysql
rest-api
crud
employee-management
spring-mvc
maven
postman
backend
````


