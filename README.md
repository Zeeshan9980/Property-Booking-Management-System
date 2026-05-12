# Property Booking Management System

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-Backend-green)
![Database](https://img.shields.io/badge/Database-MySQL-blue)
![Build](https://img.shields.io/badge/Build-Maven-red)

An enterprise-grade property booking platform built with **Spring Boot**, featuring **JWT authentication**, 
**Stripe payment integration**, and **dynamic pricing** using the Strategy Design Pattern. 
Follows clean layered architecture with secure REST APIs and global exception handling.

---

## 🚀 Features

- Secure authentication using **JWT**
- Property / hotel management
- Room inventory management
- Guest management
- Booking workflow
- Payment integration using **Stripe**
- Dynamic pricing using **Strategy Design Pattern**
- Global exception handling
- RESTful APIs following layered architecture

---

## 🛠 Tech Stack

- Java 21
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA
- Hibernate
- MySQL / PostgreSQL
- Maven
- Stripe Payment Gateway

---

## 📡 API Endpoints

### Authentication

POST /auth/signup  
Register a new user.

POST /auth/login  
Authenticate user and generate JWT token.

---

### Users

GET /users/profile  
Get logged-in user details.

---

### Hotels (Admin)

POST /hotels  
Create a new hotel.

PUT /hotels/{hotelId}  
Update hotel details.

DELETE /hotels/{hotelId}  
Delete hotel.

GET /hotels/{hotelId}  
Get hotel details.

---

### Browse Hotels

GET /browse/hotels  
Browse available hotels.

GET /browse/hotels/{hotelId}/rooms  
Get available rooms.

---

### Rooms (Admin)

POST /admin/rooms  
Create a room.

PUT /admin/rooms/{roomId}  
Update room details.

DELETE /admin/rooms/{roomId}  
Delete room.

---

### Inventory

POST /inventory  
Create room inventory.

GET /inventory/{roomId}  
Check room availability.

---

### Bookings

POST /bookings  
Create booking.

GET /bookings/{bookingId}  
Get booking details.

GET /bookings/user  
Get bookings of logged-in user.

---

### Payments

POST /checkout  
Create Stripe checkout session.

POST /webhook  
Handle Stripe payment webhook.

API testing was performed using Postman.

----

## 🏗 Architecture

The project follows a **layered architecture**.

Controller
↓
Service
↓
Repository
↓
Database

---

## 📂 Project Structure
src/main/java

controller
service
repository
entity
dto
security
config
exception
strategy
util

---

## 🎯 Design Patterns Used

- Strategy Pattern (Dynamic Pricing)
- DTO Pattern
- Layered Architecture

---

## ▶ How to Run

### Prerequisites
- Java 21 installed
- MySQL installed and running
- Maven installed
- Stripe account (for payment testing)
- Postman (optional, for API testing)

### Steps

1. Clone the repository
git clone https://github.com/Zeeshan9980/Property-Booking-Management-System.git

2. Navigate to project directory
cd Property-Booking-Management-System

3. Configure database
- Create a MySQL database named `property_booking_db`
- Open `src/main/resources/application.properties`
- Update the following:

spring.datasource.url=jdbc:mysql://localhost:3306/property_booking_db
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
jwt.secret=your_jwt_secret_key
stripe.api.key=your_stripe_secret_key

4. Run the project
mvn spring-boot:run

5. Access Swagger UI (API Documentation)
http://localhost:8080/swagger-ui/index.html

---

## 👨‍💻 Author

**Zeeshan Ahmed**

Java Backend Developer  

Skills:
Java • Spring Boot • Hibernate/JPA • REST APIs  • SQL(MYSQL) • Microservices Architecture 

LinkedIn:  
https://www.linkedin.com/in/zeeshan-ahmed-b9a2a222b/




