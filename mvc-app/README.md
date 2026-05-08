# AutoBid – MVC Application

A Spring MVC web application used to connect customers with mechanics and detailers
for on-site services.

---

## Architecture Overview

This application follows the **Model-View-Controller (MVC)** pattern:

---

## Models (Entities)

Located in `mvc-app/src/main/java/autobid/autobid/entity/`

- **User** – Base entity for all user roles; role field distinguishes Customer, Provider, and Admin
- **ServiceEntity** – Automotive service offered by a provider (e.g., oil change, detailing)
- **Booking** – A scheduled appointment between a customer and a service
- **Review** – Customer feedback on a completed service with a star rating
- **Reply** – Provider response to a customer review

---

## DTOs

Located in `mvc-app/src/main/java/autobid/autobid/dto/`

- **AdminStatsResponse** – Aggregated platform-wide statistics for the admin dashboard
- **ProviderStatsResponse** – Aggregated performance metrics per provider
- **ReviewRequest** – Request body for submitting a review
- **ReplyRequest** – Request body for submitting a reply

---

## Views (Templates)

Located in `mvc-app/src/main/resources/static/`

**Auth Pages:**
- `Auth/login.html` – User sign-in page
- `Auth/signup.html` – User registration page

**Customer Views:**
- `Customer/customerdashboard.html` – Overview of upcoming and past bookings
- `Customer/browse.html` – Browse available services from providers
- `Customer/book.html` – Service booking form
- `Customer/confirmation.html` – Booking confirmation page
- `Customer/mybookings.html` – View and manage active and past bookings
- `Customer/profile.html` – Update customer profile and credentials
- `Customer/provider-details.html` – Detailed provider and service view

**Provider Views:**
- `Provider/dashboard.html` – Service summary, review overview, and booking stats
- `Provider/profile.html` – Update provider profile and qualifications

**Admin Views:**
- `SystemAdmin/admindashboard.html` – Platform-wide statistics, user and service moderation

**Public Pages:**
- `index.html` – Landing page

**Stylesheets:**
- `css/styles.css` – Global shared styles
- `css/provider-style.css` – Provider-specific styles
- `css/admindashboard.css` – Admin dashboard styles

---

## Controllers

Located in `mvc-app/src/main/java/autobid/autobid/controller/`

- `AdminController.java` – Admin operations: user management, service moderation, statistics
- `BookingApiController.java` – Booking creation, retrieval, and status management
- `ProviderController.java` – Provider profile and service management
- `ServiceApiController.java` – Service listing CRUD operations
- `ReviewApiController.java` – Review submission and retrieval
- `ReplyApiController.java` – Provider replies to customer reviews

---

## Services

Located in `mvc-app/src/main/java/autobid/autobid/service/`

Business logic layer providing CRUD operations and domain-specific functionality:

- `AdminService.java` – Administrative operations including account restriction and moderation
- `BookingService.java` – Booking lifecycle management (create, confirm, cancel)
- `ProviderService.java` – Provider profile updates and qualification management
- `ServiceService.java` – Service listing creation, updates, and deletion
- `ReviewService.java` – Review submission and retrieval with provider associations

---

## Repositories

Located in `mvc-app/src/main/java/autobid/autobid/repository/`

Data access layer interfacing with the database via Spring Data JPA:

- `UserRepository.java` – User authentication, role lookups, and profile queries
- `BookingRepository.java` – Booking queries by customer, provider, and status
- `ServiceRepository.java` – Service queries (by provider, category, availability)
- `ReviewRepository.java` – Review queries with filtering by provider and rating
- `ReplyRepository.java` – Reply retrieval by review association

---

## Key Features

### User Roles & Authentication
- **Customer** – Browse services, create bookings, leave reviews
- **Provider** – Post and manage services, reply to reviews, track statistics
- **Admin** – Moderate users, services, and reviews; view platform-wide statistics

---

### Customer Flow
1. Sign up and create a customer profile (`Auth/signup.html`)
2. Browse available automotive services from local providers (`Customer/browse.html`)
3. Select a provider and view their details (`Customer/provider-details.html`)
4. Book an appointment with a preferred date (`Customer/book.html`)
5. Receive booking confirmation (`Customer/confirmation.html`)
6. View and manage upcoming and past bookings (`Customer/mybookings.html`)
7. Update account information from the profile page (`Customer/profile.html`)

---

### Provider Flow
1. Sign up and complete a provider profile (`Auth/signup.html`)
2. Update profile with qualifications and service details (`Provider/profile.html`)
3. View all incoming bookings and reviews from the dashboard (`Provider/dashboard.html`)
4. Monitor performance statistics including total bookings and average rating
5. Reply to customer reviews directly from the dashboard

---

### Admin Flow
1. Log in and access the admin dashboard (`SystemAdmin/admindashboard.html`)
2. View platform-wide statistics via `AdminStatsResponse`
3. Browse all registered users and restrict or remove accounts as needed
4. Review all active service listings and remove any that violate platform policies
5. Monitor and delete inappropriate or fraudulent customer reviews

---

## Session Management
- Uses `HttpSession` for storing `userId`, `providerId`, and `adminId`
- Automatic redirect to sign-in for unauthenticated access to protected pages
- Session validation applied on all sensitive endpoints

---

## Database Relationships
- **One-to-Many:** Provider → Services, User → Bookings, User → Reviews, Provider → Replies
- **Many-to-One:** Review → User / ServiceEntity, Reply → Review / Provider
- **Cascade Operations:** Automatic cascading for related entity deletions and updates
- **JsonIgnoreProperties:** Prevents circular reference serialization issues across related entities
