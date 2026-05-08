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

# User Roles & Functional Requirements

## Customer Features (Gamal Hassan)

### US-CUST-001 — Register & Manage Profile
- Create customer account
- Login securely
- Edit personal profile information

### US-CUST-002 — View Available Services
- Browse provider services
- View pricing and descriptions

### US-CUST-003 — Book a Service
- Select service and provider
- Choose appointment date
- Confirm booking

### US-CUST-004 — Write a Review
- Submit ratings and comments after service completion

---

## Provider Features (Gopal Vulli)

### US-PROV-001 — Manage Provider Profile & Services
- Create and update provider profile
- Provider accounts require `@autobid.com` email
- Create services with pricing, category, and descriptions
- Edit and delete services

### US-PROV-002 — View Customer Statistics
- View total bookings
- View unique customers
- View services booked
- Cancel bookings

### US-PROV-003 — Reply to Customer Reviews
- View customer reviews
- Submit replies to reviews

### US-PROV-004 — Delete Services
- Remove services from dashboard

---

## System Admin Features (Rayyan Othman)

### US-ADMIN-001 — Manage Platform
- View all users
- Restrict or remove user access
- Moderate services
- Moderate reviews
- View platform statistics

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

# Test Scenarios

## Customer Test Scenarios

### US-CUST-001 — Register & Manage Profile
1. Customer logs in and creates a profile
2. Customer edits profile information
3. Customer exits

### US-CUST-002 — View Available Services
1. Customer logs in
2. Customer views available services
3. Customer exits

### US-CUST-003 — Book a Service
1. Customer selects service
2. Customer books appointment
3. Booking confirmation displayed

### US-CUST-004 — Write a Review
1. Customer logs in after service completion
2. Customer submits review and rating

---

## Provider Test Scenarios

### US-PROV-001 — Manage Provider Profile & Services
1. Provider logs in with `@autobid.com`
2. Provider updates profile
3. Provider creates service
4. Provider edits service details

### US-PROV-002 — View Customer Statistics
1. Provider views dashboard statistics
2. Provider views bookings
3. Provider cancels booking

### US-PROV-003 — Reply to Reviews
1. Provider views customer review
2. Provider submits reply

### US-PROV-004 — Delete Services
1. Provider selects service
2. Provider deletes service

---

## Admin Test Scenarios

### US-ADMIN-001 — Manage Users & Content
1. Admin logs in
2. Admin views users
3. Admin deletes services or reviews
4. Admin views statistics

---

# Non-Functional Requirements

## Performance Requirements

### Scenario P1 — Browse Services Performance
- Expected: 95% of requests complete within 1.5 seconds

### Scenario P2 — Booking Performance
- Expected: 99% of booking requests complete within 1 second

---

## Security Requirements

### Scenario S1 — Role-Based Access Control
- Customers cannot access provider/admin endpoints
- Unauthorized requests return `403 Forbidden`

---

## Usability Requirements

### Scenario U1 — Customer Booking Flow
- Booking process completed within 3 minutes

### Scenario U2 — Provider Service Creation
- Service creation completed within 5 minutes

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
