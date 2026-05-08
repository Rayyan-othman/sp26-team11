# AutoBid

Team 11 group project for CSC 340 (2026)

## Team Members
- Rayyan Othman
- Gopal Vulli
- Gamal Hassan

---

# Project Information

**Project Name:** AutoBid  
**Version:** 1.0  
**Date:** 2026-05-04  

## Description

AutoBid is a web-based platform that allows customers to book mobile automotive services directly to their location. The platform connects customers with mobile mechanics and detailing providers while giving providers tools to manage services, bookings, reviews, and customer interactions.

The system improves convenience by eliminating the need for customers to visit physical service locations and provides providers with a streamlined platform for managing appointments and customer feedback.

---
# UML diagram

![UML diagram](https://github.com/user-attachments/assets/277e5a0d-6527-4459-adfa-bd28c94d3338)


---

# System Architecture

The project consists of three major components:

## Backend API (`/backendapi`)
- Built with Spring Boot
- Handles REST API endpoints
- Manages business logic and database operations

## MVC Application (`/mvc-app`)
- Frontend web application
- Handles user interface rendering
- Connects to backend API through HTTP requests

## Database
- PostgreSQL (Neon)
- Stores users, services, bookings, reviews, and statistics

---

# App Functions

1. Customer:

   i. Create/modify customer profile – Register as a customer.  
   
   ii. View available services – Browse provider services and pricing.  
   
   iii. Book available services – Schedule appointments with providers.  
   
   iv. Write reviews for completed services – Review service quality and experience.  

2. Provider:

   i. Create/modify/remove provider profile – Register as a provider.  
   
   ii. Create services – Post services with pricing, categories, and descriptions.  
   
   iii. View customer statistics – Track bookings and customer activity.  
   
   iv. Reply to reviews – Respond to customer feedback.  
   
   v. Delete services – Remove services from dashboard.  

3. SysAdmin:

   i. Manage user access – Restrict or remove users.  
   
   ii. Moderate services – Review and manage service listings.  
   
   iii. Moderate reviews – Flag or remove inappropriate reviews.  
   
   iv. View usage statistics – Track platform activity and bookings.  

---

# API Endpoints

## User Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/users` | Get all users |
| GET | `/users/{id}` | Get user by ID |
| POST | `/users` | Create user |
| PUT | `/users/{id}` | Update user |
| DELETE | `/users/{id}` | Delete user |

---

## Service Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/services` | Get all services |
| GET | `/services/{id}` | Get service by ID |
| POST | `/services` | Create service |
| PUT | `/services/{id}` | Update service |
| DELETE | `/services/{id}` | Delete service |

---

## Booking Endpoints

| Method | Endpoint |
|---|---|
| GET | `/bookings` |
| GET | `/bookings/{id}` |
| POST | `/bookings` |
| PUT | `/bookings/{id}` |
| DELETE | `/bookings/{id}` |

---

## Review Endpoints

| Method | Endpoint |
|---|---|
| GET | `/reviews` |
| GET | `/reviews/{id}` |
| GET | `/reviews/provider/{providerId}` |
| POST | `/reviews` |
| PUT | `/reviews/{id}` |
| DELETE | `/reviews/{id}` |

---

## Reply Endpoints

| Method | Endpoint |
|---|---|
| GET | `/replies` |
| GET | `/replies/{id}` |
| POST | `/replies` |

---

## Statistics Endpoints

| Method | Endpoint |
|---|---|
| GET | `/statistics` |
| GET | `/statistics/provider/{providerId}` |


---


# Demo Flow

1. Login as Provider
2. Create service
3. View provider dashboard
4. Customer books service
5. Customer leaves review
6. Provider replies to review
7. Provider views booking statistics
8. Admin moderates content

---

# Running the Project

## Run MVC Application

```bash
cd mvc-app
mvn spring-boot:run
```

## Open Application

```text
http://localhost:8080
```

---

# Technologies Used
- Java
- Spring Boot
- PostgreSQL
- HTML/CSS/JavaScript
- Maven

---

# Notes
- Data stored using PostgreSQL
- Backend built with Spring Boot REST APIs
- Frontend communicates using HTTP requests
- Supports Customer, Provider, and Admin roles
