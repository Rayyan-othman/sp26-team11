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

Our project is a system that allows customers to book mobile, on-site mechanic and detailing services directly to their location with ease and convenience. Customers can view a list of providers and the services they offer, book appointments, and leave reviews based on their experience. Providers can create profiles, list their qualifications, post services, and receive reviews and feedback from customers. This helps providers gain visibility and attract more jobs.

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
1. **Create/modify customer profile** – Customers can register, log in securely, and update personal information.
2. **View available services** – Customers can browse providers, pricing, and service descriptions.
3. **Book services** – Customers can select a provider, choose a time, and confirm booking.
4. **Write reviews** – Customers can leave ratings and feedback after a completed service.

---

### 2. Provider (Gopal Vulli)
1. **Create/modify provider profile** – Providers can manage their account information.
2. **Create and delete services** – Providers can post and manage services with pricing and descriptions.
3. **View provider dashboard** – Displays services, total reviews, and average ratings.
4. **View customer statistics** – Providers can track performance metrics.
5. **Reply to reviews** – Providers can respond to customer feedback.

---

### 3. SysAdmin (Rayyan Othman)
1. **Manage users** – Admin can view users and remove or restrict access when necessary.
2. **Moderate services** – Admin can add, remove, or update services on the platform.
3. **Moderate reviews** – Admin can remove inappropriate reviews.
4. **View usage statistics** – Admin can view platform data and statistics.

---

### SysAdmin Use Cases
| Use Case | Endpoint |
|---|---|
| Manage users | `GET /users`, `PUT /users/{id}` |
| Moderate services | `GET /services`, `DELETE /services/{id}` |
| Moderate reviews | `GET /reviews`, `DELETE /reviews/{id}` |
| View usage statistics | `GET /statistics` |

---

![System Diagram](https://github.com/user-attachments/assets/14f88ad3-bef3-436c-ab6f-8d9d3120c00a)

---

## API Endpoints

### User Endpoints
| Method | Endpoint | Description |
|---|---|---|
| GET | `/users` | Get all users |
| GET | `/users/{id}` | Get user by ID |
| POST | `/users` | Create a new user |
| PUT | `/users/{id}` | Update an existing user |
| DELETE | `/users/{id}` | Delete a user |

### Service Endpoints
| Method | Endpoint | Description |
|---|---|---|
| GET | `/services` | Get all services |
| GET | `/services/{id}` | Get service by ID |
| POST | `/services` | Create a new service |
| PUT | `/services/{id}` | Update an existing service |
| DELETE | `/services/{id}` | Delete a service |

### Booking Endpoints
| Method | Endpoint |
|---|---|
| GET | `/bookings` |
| GET | `/bookings/{id}` |
| POST | `/bookings` |
| PUT | `/bookings/{id}` |
| DELETE | `/bookings/{id}` |

### Review Endpoints
| Method | Endpoint |
|---|---|
| GET | `/reviews` |
| GET | `/reviews/{id}` |
| GET | `/reviews/provider/{providerId}` |
| POST | `/reviews` |
| PUT | `/reviews/{id}` |
| DELETE | `/reviews/{id}` |

### Reply Endpoints
| Method | Endpoint |
|---|---|
| GET | `/replies` |
| GET | `/replies/{id}` |
| POST | `/replies` |

### Statistics Endpoints
| Method | Endpoint |
|---|---|
| GET | `/statistics` |
| GET | `/statistics/provider/{providerId}` |

---

## Use Case Mapping with Example Requests & Responses

### Customer Use Cases (Gamal Hassan)

#### Create Customer Profile
**Endpoint:** `POST /users`

**Request:**
```json
{
  "firstName": "Rayyan",
  "lastName": "Othman",
  "email": "rayyan@email.com",
  "password": "123456",
  "phone": "3369781184",
  "role": "CUSTOMER",
  "accountStatus": "ACTIVE"
}
```

**Response:**
```json
{
  "id": 1,
  "firstName": "Rayyan",
  "lastName": "Othman",
  "email": "rayyan@email.com",
  "phone": "3369781184",
  "role": "CUSTOMER",
  "accountStatus": "ACTIVE"
}
```

---

#### View Available Services
**Endpoint:** `GET /services`

**Response:**
```json
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
```

---

#### Book Service
**Endpoint:** `POST /bookings`

**Request:**
```json
{
  "bookingDate": "2026-03-24",
  "status": "CONFIRMED",
  "customer": { "id": 1 },
  "service": { "id": 1 }
}
```

**Response:**
```json
{
  "id": 1,
  "bookingDate": "2026-03-24",
  "status": "CONFIRMED"
}
```

---

#### Write Review
**Endpoint:** `POST /reviews`

**Request:**
```json
{
  "rating": 5,
  "comment": "Excellent and fast service.",
  "customer": { "id": 1 },
  "service": { "id": 1 }
}
```

**Response:**
```json
{
  "id": 1,
  "rating": 5,
  "comment": "Excellent and fast service."
}
```

---

### Provider Use Cases (Gopal Vulli)

#### Create Provider Profile
**Endpoint:** `POST /users`

**Request:**
```json
{
  "firstName": "John",
  "lastName": "Mechanic",
  "email": "john@autobid.com",
  "password": "123456",
  "phone": "3361112222",
  "role": "PROVIDER",
  "accountStatus": "ACTIVE"
}
```

**Response:**
```json
{
  "id": 2,
  "firstName": "John",
  "lastName": "Mechanic",
  "email": "john@autobid.com",
  "phone": "3361112222",
  "role": "PROVIDER",
  "accountStatus": "ACTIVE"
}
```

---

#### Create Service
**Endpoint:** `POST /services`

```json
{
  "title": "Mobile Oil Change",
  "description": "On-site oil change service",
  "price": 89.99,
  "category": "Mechanic",
  "availability": "Available",
  "provider": { "id": 2 }
}
```

---

#### View Provider Dashboard
Displays:
- Total services
- Total reviews
- Average rating

Data retrieved from:
- `GET /services`
- `GET /reviews`

---

#### Reply to Review
**Endpoint:** `POST /replies`

```json
{
  "message": "Thank you for your feedback.",
  "review": { "id": 1 },
  "provider": { "id": 2 }
}
```

---

#### Delete Service
**Endpoint:** `DELETE /services/{id}`

#### Update Provider Profile
**Endpoint:** `PUT /users/{id}`

---

### SysAdmin Use Cases (Rayyan Othman)

#### Manage Users
**Endpoint:** `GET /users`

---

#### Restrict/Remove User Access
**Endpoint:** `PUT /users/{id}`

**Request:**
```json
{
  "accountStatus": "BANNED"
}
```

**Response:**
```json
{
  "id": 1,
  "accountStatus": "BANNED"
}
```

---

#### Moderate Services
**Endpoint:** `DELETE /services/1`

---

#### Moderate Reviews
**Endpoint:** `DELETE /reviews/1`

---

#### View Platform Statistics
**Endpoint:** `GET /statistics`

---

## How to Run



### Run MVC App
```bash
cd mvc-app
mvn spring-boot:run
```

### Open in Browser
```
http://localhost:8080
```

---

## Demo Flow (Presentation)
1. Login as Provider
2. Create a service
3. View service in dashboard
4. Customer books and leaves review
5. Provider views review
6. Provider replies to review
7. Dashboard updates (statistics and reviews)

---

## Notes
- Data is stored persistently using PostgreSQL
- Backend built with Spring Boot REST API
- Frontend communicates via HTTP requests
- Supports Customer, Provider, and Admin roles