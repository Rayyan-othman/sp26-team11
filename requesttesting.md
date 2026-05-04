# AutoBid Test Plan

**Project Name:** AutoBid  
**Version:** 1.0  
**Date:** May 2026  
**Purpose:**  
This test plan validates that the AutoBid system correctly supports all actors (Customer, Provider, Admin) and that all core features (registration, booking, service management, reviews, and admin controls) function properly with persistent database storage.

---

## Actors
- Provider P: Mechanic or Detailer offering services
- Customer C: User booking services
- Admin A: System administrator managing users, services, and reviews

---

## Use Cases

#### 1. Customer: US-CUST-001 — Register & manage profile
1. Customer creates an account using sign-up page.
2. Customer logs in and updates profile (name, preferences).
3. Changes are saved and persist after logout/login.

---

#### 2. Customer: US-CUST-002 — Browse & book services
1. Customer logs in and browses available services.
2. Customer selects a service and books it.
3. Booking is saved and visible in customer dashboard.

---

#### 3. Customer: US-CUST-003 — Leave a review
1. Customer selects a completed service.
2. Customer submits a rating and comment.
3. Review is stored in database and displayed publicly.

---

#### 4. Provider: US-PROV-001 — Create & manage services
1. Provider logs in and creates a new service (title, description, price).
2. Provider edits or deletes an existing service.
3. Changes reflect immediately in service listings.

---

#### 5. Provider: US-PROV-002 — View reviews
1. Provider logs in to dashboard.
2. Provider views customer reviews on their services.
3. Reviews are correctly fetched from database.

---

#### 6. Admin: US-ADMIN-001 — Manage users
1. Admin logs in.
2. Admin views all users.
3. Admin removes users or restricts access when necessary.
4. Changes persist in database.

---

#### 7. Admin: US-ADMIN-002 — Manage services & reviews
1. Admin views all services and reviews.
2. Admin deletes inappropriate services or reviews.
3. Changes reflect immediately in UI and database.

---

## CROSS-CUTTING TEST SCENARIOS (Non-Functional Requirements)

---

### Performance Requirements

**Scenario P1: Discover page response time < 1.5 seconds**
- **Setup:** Server under normal load
- **Steps:**
  1. Load Browse Services page with 10+ services
  2. Repeat 10 times
- **Expected Outcome:** 95% of requests ≤ 1.5 seconds

---

**Scenario P2: API response under load**
- **Setup:** Simulate multiple users (5–10 concurrent requests)
- **Steps:**
  1. Send repeated GET requests to `/api/services`
  2. Measure response times
- **Expected Outcome:** Responses remain under 2 seconds without failure

---

### Security & Privacy Requirements

**Scenario S1: Unauthorized access prevention**
- **Setup:** User not logged in
- **Steps:**
  1. Attempt to access admin dashboard URL directly
  2. Attempt to access provider endpoints
- **Expected Outcome:** Access denied or redirected to login

---

**Scenario S2: Data protection**
- **Setup:** Logged-in user
- **Steps:**
  1. Attempt to modify another user’s data via API
  2. Submit request with different user ID
- **Expected Outcome:** Request rejected (no unauthorized changes)

---

### Usability Requirements

**Scenario U1: Easy navigation**
- **Setup:** First-time user
- **Steps:**
  1. Navigate from homepage → login → dashboard
  2. Browse services and return to homepage
- **Expected Outcome:** Navigation is intuitive and completes 

---

**Scenario U2: Form usability**
- **Setup:** User filling forms
- **Steps:**
  1. Submit signup form with missing fields
  2. Submit valid form
- **Expected Outcome:**  
  - Errors displayed clearly for invalid input  
  - Successful submission redirects user appropriately  

---
