# 🏨 Property Booking Management System

[![Java](https://img.shields.io/badge/Java-21-orange)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.3-brightgreen)](https://spring.io/projects/spring-boot)
[![Spring Security](https://img.shields.io/badge/Spring%20Security-JWT-blue)](https://spring.io/projects/spring-security)
[![MySQL](https://img.shields.io/badge/Database-MySQL-blue)](https://www.mysql.com/)
[![Stripe](https://img.shields.io/badge/Payments-Stripe-purple)](https://stripe.com/)
[![Maven](https://img.shields.io/badge/Build-Maven-red)](https://maven.apache.org/)
[![Swagger](https://img.shields.io/badge/API%20Docs-Swagger%20UI-85EA2D)](https://swagger.io/)

A production-ready **Spring Boot** backend application simulating an enterprise-level property booking platform. Supports multi-role access, real-time inventory management, JWT-secured endpoints, and live payment processing via Stripe.

---

## 🚀 Key Highlights

- 🔐 **JWT Authentication** with role-based access control (Admin / Guest)
- 💳 **Stripe Payment Gateway** with webhook support for real-time payment confirmation
- 📦 **Strategy Design Pattern** for dynamic pricing logic (extensible, plug-and-play)
- 📑 **Swagger UI** integrated for live API documentation and testing
- 🏗️ **Clean Layered Architecture** — Controller → Service → Repository → Database
- ⚠️ **Global Exception Handling** with meaningful HTTP error responses
- 🔄 **ModelMapper** for clean DTO-Entity mapping

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 4.0.3 |
| Security | Spring Security + JWT (JJWT 0.12.6) |
| ORM | Spring Data JPA + Hibernate |
| Database | MySQL |
| Payments | Stripe API |
| API Docs | SpringDoc OpenAPI (Swagger UI) |
| Build Tool | Maven |
| Utilities | Lombok, ModelMapper |

---

## 🏗️ System Architecture

```
Client (Postman / Frontend)
        |
        v
[ Spring Security Filter ] ← JWT Token Validation
        |
        v
[ Controller Layer ]  ← REST API Endpoints
        |
        v
[ Service Layer ]     ← Business Logic + Strategy Pattern (Pricing)
        |
        v
[ Repository Layer ]  ← Spring Data JPA
        |
        v
[ MySQL Database ]
        |
[ Stripe API ] ← Payment Processing + Webhook Events
```

---

## 📂 Project Structure

```
src/main/java/com/zeeshan/propertybooking/
├── controller/       # REST controllers (Auth, Hotel, Room, Booking, Payment)
├── service/          # Business logic interfaces + implementations
├── repository/       # Spring Data JPA repositories
├── entity/           # JPA entity models
├── dto/              # Data Transfer Objects
├── security/         # JWT filter, token provider, UserDetailsService
├── config/           # Security config, Stripe config, ModelMapper bean
├── exception/        # Global exception handler + custom exceptions
├── strategy/         # Pricing strategy interface + implementations
└── util/             # Helper utilities
```

---

## 📡 API Endpoints

### 🔑 Authentication
| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| POST | `/auth/signup` | Register new user | Public |
| POST | `/auth/login` | Login and receive JWT token | Public |

### 👤 User
| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| GET | `/users/profile` | Get logged-in user profile | Authenticated |

### 🏨 Hotels (Admin)
| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| POST | `/hotels` | Create hotel | Admin |
| PUT | `/hotels/{hotelId}` | Update hotel | Admin |
| DELETE | `/hotels/{hotelId}` | Delete hotel | Admin |
| GET | `/hotels/{hotelId}` | Get hotel details | Admin |

### 🔍 Browse (Guest)
| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| GET | `/browse/hotels` | Browse all available hotels | Public |
| GET | `/browse/hotels/{hotelId}/rooms` | Get available rooms | Public |

### 🛏️ Rooms (Admin)
| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| POST | `/admin/rooms` | Create room | Admin |
| PUT | `/admin/rooms/{roomId}` | Update room | Admin |
| DELETE | `/admin/rooms/{roomId}` | Delete room | Admin |

### 📦 Inventory
| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| POST | `/inventory` | Create room inventory | Admin |
| GET | `/inventory/{roomId}` | Check room availability | Authenticated |

### 📋 Bookings
| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| POST | `/bookings` | Create new booking | Authenticated |
| GET | `/bookings/{bookingId}` | Get booking details | Authenticated |
| GET | `/bookings/user` | Get all bookings of logged-in user | Authenticated |

### 💳 Payments
| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| POST | `/checkout` | Initiate Stripe checkout session | Authenticated |
| POST | `/webhook` | Handle Stripe payment webhook | Stripe |

> 📘 Full interactive API docs available at `http://localhost:8080/swagger-ui.html` when running locally.

---

## ⚙️ Getting Started

### Prerequisites
- Java 21+
- Maven 3.8+
- MySQL 8+
- Stripe account (for payment testing)

### 1. Clone the Repository
```bash
git clone https://github.com/Zeeshan9980/Property-Booking-Management-System.git
cd Property-Booking-Management-System
```

### 2. Configure Application Properties
Create your `application.properties` in `src/main/resources/`:

```properties
# Database
spring.datasource.url=jdbc:mysql://localhost:3306/property_booking_db
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD
spring.jpa.hibernate.ddl-auto=update

# JWT
app.jwt.secret=YOUR_JWT_SECRET_KEY
app.jwt.expiry=86400000

# Stripe
stripe.api.key=YOUR_STRIPE_SECRET_KEY
stripe.webhook.secret=YOUR_STRIPE_WEBHOOK_SECRET
```

> ⚠️ Never commit real credentials. Use environment variables or `.env` files in production.

### 3. Run the Application
```bash
mvn spring-boot:run
```

App starts at `http://localhost:8080`

---

## 🎯 Design Patterns Used

| Pattern | Where Used |
|---|---|
| **Strategy Pattern** | Dynamic pricing — different pricing strategies (seasonal, weekend, etc.) without changing core logic |
| **DTO Pattern** | Separates API layer from entity layer, prevents over-exposure of DB schema |
| **Layered Architecture** | Clear separation of concerns across Controller, Service, Repository |

---

## 🔒 Security Flow

```
1. User hits POST /auth/login with credentials
2. Spring Security validates credentials
3. JWT token generated and returned to client
4. Client sends token in Authorization: Bearer <token> header
5. JwtAuthFilter validates token on every request
6. Role-based access enforced (ADMIN / USER)
```

---

## 💳 Payment Flow

```
1. User initiates booking → POST /bookings
2. Checkout session created → POST /checkout (Stripe session returned)
3. User completes payment on Stripe-hosted page
4. Stripe fires webhook → POST /webhook
5. Backend confirms payment, updates booking status
```

---

## 👨‍💻 Author

**Zeeshan Ahmed** — Java Backend Developer

- 🔗 [LinkedIn](https://www.linkedin.com/in/zeeshan-ahmed-b9a2a222b/)
- 💻 [GitHub](https://github.com/Zeeshan9980)

**Skills:** Java • Spring Boot • Spring Security • JWT • Hibernate/JPA • MySQL • REST APIs • Microservices • AWS



