**Project Name:** AutoBid  
**Version:** 1.0  
**Date:** 2026-05-04  
**Purpose:** This document outlines comprehensive test scenarios to demonstrate all functional and non-functional requirements of the AutoBid system, including customer, provider, and admin interactions.

---

## Actors
- Provider P: Mechanic / Service Provider  
- Customer C: Customer  
- Service S: Automotive Service (e.g., Oil Change, Detailing)

---

## Use Cases

#### 1. Customer: US-CUST-001 — Register & manage profile
1. Customer C1 logs in for the first time and creates a profile.
2. C1 edits their profile information .
3. C1 exits.

#### 2. Customer: US-CUST-002 — View available services
1. C1 logs in.
2. C1 views all available services S1 (Mobile Oil Change).
3. C1 exits.

#### 3. Customer: US-CUST-003 — Book a service
1. C1 logs in.
2. C1 selects service S1.
3. C1 books S1 for a specific date.
4. Booking is confirmed.
5. C1 exits.

#### 4. Customer: US-CUST-004 — Write a review
1. C1 logs in after service completion.
2. C1 writes a positive review for service S1.
3. C1 exits.

#### 5. Customer: US-CUST-005 — Read reviews & book
1. Customer C2 logs in and creates profile.
2. C2 browses services.
3. C2 views reviews for S1.
4. C2 books S1.
5. C2 exits.

---

#### 6. Provider: US-PROV-001 — Create provider profile & service
1. Provider P1 logs in and creates a profile.
2. P1 creates service S1 (Mobile Oil Change with price and description).
3. P1 exits.

#### 7. Provider: US-PROV-002 — View statistics & reply to review
1. P1 logs in.
2. P1 views provider statistics (bookings, reviews).
3. P1 reads review for S1.
4. P1 replies to the review.
5. P1 exits.

---

#### 8. Admin: US-ADMIN-001 — Manage users and content
1. Admin logs in.
2. Admin views all users.
3. Admin bans a user.
4. Admin deletes a service or review.
5. Admin views system statistics.
6. Admin exits.

---

## CROSS-CUTTING TEST SCENARIOS (Non-Functional Requirements)

### Performance Requirements

**Scenario P1: Browse services response time < 1.5 seconds**
- **Setup:** Server under normal load
- **Steps:**
  1. Load services page with 5+ providers and 10+ services
  2. Repeat 10 times
- **Expected Outcome:** 95% of requests ≤ 1.5 seconds

**Scenario P2: Booking request response time < 1.0 second**
- **Setup:** Server under normal load
- **Steps:**
  1. Submit booking request
  2. Repeat 10 times
- **Expected Outcome:** 99% of requests ≤ 1.0 second

---

### Security & Privacy Requirements

**Scenario S1: Role-based access control**
- **Setup:** Customer attempts provider/admin actions
- **Steps:**
  1. Customer logs in
  2. Attempts to access provider statistics endpoint
- **Expected Outcome:**
  - Access denied (403 Forbidden)
  - No sensitive data exposed

---

### Usability Requirements

**Scenario U1: Customer completes booking in ≤ 3 minutes**
- **Setup:** New user test
- **Steps:**
  1. User logs in
  2. Browses services
  3. Books a service
- **Expected Outcome:** Completed ≤ 3 minutes

**Scenario U2: Provider creates service in ≤ 5 minutes**
- **Setup:** New provider account
- **Steps:**
  1. Provider logs in
  2. Creates a service with details
- **Expected Outcome:** Completed ≤ 5 minutes