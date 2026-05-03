# AutoBid MVC Application

## Overview
This module represents the frontend of the AutoBid system using the MVC (Model-View-Controller) architecture.

It connects the user interface to the backend API and displays dynamic data such as services, users, bookings, and reviews.

---

## Architecture

- **Controllers:** Handle incoming requests and route users to the correct pages  
- **Views (Templates):** Display UI pages to the user  
- **Models / API Calls:** Retrieve and send data to the backend  

The MVC application communicates with the backend API to ensure all data is stored and retrieved from the database.

---

## Use Case Mapping

### Customer Use Cases

#### Register & Login
- Pages: `/signup`, `/login`
- Controller: AuthController
- Backend: User API (`POST /users`)

---

#### Browse Services
- Page: `/services`
- Controller: ServiceController
- API: `GET /services`

---

#### Book Service
- Page: Service booking flow
- Controller: BookingController / ServiceController
- API: `POST /bookings`

---

#### Leave Review
- Page: `/reviews`
- Controller: ReviewController
- API: `POST /reviews`

---

### Provider Use Cases

#### Create Service
- Page: `/provider/services`
- Controller: ServiceController
- API: `POST /services`

---

#### Manage Services
- Page: `/provider/dashboard`
- Controller: ServiceController
- API: `PUT /services/{id}`, `DELETE /services/{id}`

---

#### View Reviews
- Page: `/provider/reviews`
- Controller: ReviewController
- API: `GET /reviews`

---

#### Reply to Reviews
- Page: `/provider/reviews`
- Controller: ReviewController
- API: `POST /replies`

---

### Admin Use Cases

#### Manage Users
- Page: `/admin/dashboard`
- Controller: AdminController
- API: `GET /users`, `PUT /users/{id}`
- Actions:
  - Remove users  
  - Restrict access  

---

#### Moderate Services
- Page: `/admin/services`
- Controller: AdminController
- API: `DELETE /services/{id}`

---

#### Moderate Reviews
- Page: `/admin/reviews`
- Controller: AdminController
- API: `DELETE /reviews/{id}`

---

#### View Statistics
- Page: `/admin/dashboard`
- Controller: AdminController
- API: `GET /statistics`

---

## Notes
- All data displayed in the UI is fetched from the backend API  
- The MVC app ensures real-time updates and persistent storage  
- This module demonstrates full integration between frontend and backend  

---
