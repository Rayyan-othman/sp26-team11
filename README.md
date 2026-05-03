
# sp26-team11
Team 11 group project for CSC 340 (2026)  
- Rayyan Othman  
- Gopal Vulli  
- Gamal Hassan  

---

## Title
> AutoBid 

---

## Team Members
> Rayyan Othman  
> Gopal Vulli  
> Gamal Hassan  

---

## Description 
Our project is a system that allows customers to book mobile, on-site mechanic and detailing services directly to their location with ease and convenience. Customers can view a list of providers and the services they offer, book appointments, and leave reviews based on their experience.

Providers can create profiles, list their qualifications, post services, and receive reviews and feedback from customers. This helps providers gain visibility and attract more jobs.

This application solves the problem of customers being too busy to visit service locations by making automotive services more convenient, automated, and accessible.

---

## System Architecture

The project is divided into three main components:

### Backend API (`/backendapi`)
- Built using Spring Boot  
- Handles business logic and database operations  
- Provides REST endpoints for users, services, bookings, reviews, and admin actions  

### MVC Application (`/mvc-app`)
- Handles frontend rendering  
- Connects UI to backend API  
- Displays dynamic data from the database  

### Database
- PostgreSQL (Neon)  
- Stores users, services, bookings, and reviews  

---

## App Functions

### 1. Customer (Gamal Hassan)
1. Create/modify customer profile – Customers can register, log in securely, and update personal information.
2. View available services – Customers can browse providers, pricing, and service descriptions.
3. Book services – Customers can select a provider, choose a time, and confirm booking.
4. Write reviews – Customers can leave ratings and feedback after a completed service.

---

### 2. Provider (Gopal Vulli)
1. Create/modify/remove provider profile – Providers can manage their account and qualifications.
2. Create services – Providers can post services with pricing and descriptions.
3. View customer statistics – Providers can view booking history, ratings, and service performance.
4. Reply to reviews – Providers can respond to customer feedback.

---

### 3. SysAdmin (Rayyan Othman)
1. Manage users – Admin can view users and remove or restrict access when necessary.
2. Moderate services – Admin can add, remove, or update services on the platform.
3. Moderate reviews – Admin can remove inappropriate reviews.
4. View usage statistics – Admin can view platform data and statistics.

---

### SysAdmin Use Cases
- Manage users → `GET /users`, `PUT /users/{id}`  
- Moderate services → `GET /services`, `DELETE /services/{id}`  
- Moderate reviews → `GET /reviews`, `DELETE /reviews/{id}`  
- View usage statistics → `GET /statistics`  

---
![032419BD-BE75-4F09-B05A-00B62E625A99](https://github.com/user-attachments/assets/14f88ad3-bef3-436c-ab6f-8d9d3120c00a)

---

## API Endpoints

### User Endpoints
- `GET /users` → Get all users  
- `GET /users/{id}` → Get user by id  
- `POST /users` → Create a new user  
- `PUT /users/{id}` → Update an existing user  
- `DELETE /users/{id}` → Delete a user  

### Service Endpoints
- `GET /services` → Get all services  
- `GET /services/{id}` → Get service by id  
- `POST /services` → Create a new service  
- `PUT /services/{id}` → Update an existing service  
- `DELETE /services/{id}` → Delete a service  

### Booking Endpoints
- `GET /bookings`  
- `GET /bookings/{id}`  
- `POST /bookings`  
- `PUT /bookings/{id}`  
- `DELETE /bookings/{id}`  

### Review Endpoints
- `GET /reviews`  
- `GET /reviews/{id}`  
- `GET /reviews/provider/{providerId}`  
- `POST /reviews`  
- `PUT /reviews/{id}`  
- `DELETE /reviews/{id}`  

### Reply Endpoints
- `GET /replies`  
- `GET /replies/{id}`  
- `POST /replies`  

### Statistics Endpoints
- `GET /statistics`  
- `GET /statistics/provider/{providerId}`  

---

## How to Run

### Run Backend
cd backendapi/autobid
mvnw.cmd spring-boot:run

### Run MVC App
cd mvc-app
mvnw.cmd spring-boot:run

### Open in Browser
http://localhost:8080

---

## Use Case Mapping with Example Requests & Responses

### Customer Use Cases

#### Create Customer Profile
Endpoint: POST /users

Request:
{
  "firstName": "Rayyan",
  "lastName": "Othman",
  "email": "rayyan@email.com",
  "password": "123456",
  "phone": "3369781184",
  "role": "CUSTOMER",
  "accountStatus": "ACTIVE"
}

Response:
{
  "id": 1,
  "firstName": "Rayyan",
  "lastName": "Othman",
  "email": "rayyan@email.com",
  "phone": "3369781184",
  "role": "CUSTOMER",
  "accountStatus": "ACTIVE"
}

---

#### View Available Services
Endpoint: GET /services

Response:
[
  {
    "id": 1,
    "title": "Mobile Oil Change",
    "description": "On-site oil change service",
    "price": 89.99,
    "category": "Mechanic",
    "availability": "Available"
  }
]

---

#### Book Service
Endpoint: POST /bookings

Request:
{
  "bookingDate": "2026-03-24",
  "status": "CONFIRMED",
  "customer": { "id": 1 },
  "service": { "id": 1 }
}

Response:
{
  "id": 1,
  "bookingDate": "2026-03-24",
  "status": "CONFIRMED"
}

---

#### Write Review
Endpoint: POST /reviews

Request:
{
  "rating": 5,
  "comment": "Excellent and fast service.",
  "customer": { "id": 1 },
  "service": { "id": 1 }
}

Response:
{
  "id": 1,
  "rating": 5,
  "comment": "Excellent and fast service."
}

---

### SysAdmin Use Cases

#### Manage Users
Endpoint: GET /users

#### Restrict/Remove User Access
Endpoint: PUT /users/{id}

Request:
{
  "accountStatus": "BANNED"
}

Response:
{
  "id": 1,
  "accountStatus": "BANNED"
}

---

#### Moderate Services
Endpoint: DELETE /services/1

---

#### Moderate Reviews
Endpoint: DELETE /reviews/1

---

#### View Platform Statistics
Endpoint: GET /statistics
