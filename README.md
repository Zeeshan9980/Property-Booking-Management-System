# Property Booking Management System

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-Backend-green)
![Database](https://img.shields.io/badge/Database-MySQL-blue)
![Build](https://img.shields.io/badge/Build-Maven-red)

A backend application for managing property bookings, room inventory, guest information, and payment processing.  
The system is built using **Spring Boot** and follows a clean **layered architecture** with secure authentication and REST APIs.

This project simulates an enterprise-level booking platform where users can browse properties, manage guests, and complete bookings securely.

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

- Java
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

1 Clone repository
git clone https://github.com/Zeeshan9980/Property-Booking-Management-System.git

2 Configure database in
application.properties

3 Run project
mvn spring-boot:run

---

## 👨‍💻 Author

**Zeeshan Ahmed**

Java Backend Developer  

Skills:
Java • Spring Boot • Hibernate/JPA • REST APIs  • SQL(MYSQL) • Microservices Architecture 

LinkedIn:  
https://www.linkedin.com/in/zeeshan-ahmed-b9a2a222b/




