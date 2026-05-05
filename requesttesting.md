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




---
#### 6. Provider: US-PROV-001 — Create and manage provider profile & services
1. Provider P1 logs in with their @autobid.com account.
2. P1 navigates to the Profile page and updates their name and email.
3. P1 navigates to the Dashboard and creates service S1 (Mobile Oil Change with price, description, category, and booking deadline).
4. P1 edits S1 to update the price.
5. P1 exits.

#### 7. Provider: US-PROV-002 — View customer statistics
1. P1 logs in.
2. P1 views the Dashboard stats (total services, total reviews, average rating).
3. P1 navigates to the Bookings page and views all customer bookings for their services (total bookings, unique customers, services booked).
4. P1 cancels a booking.
5. P1 exits.

#### 8. Provider: US-PROV-003 — Reply to customer reviews
1. P1 logs in.
2. P1 scrolls to the Customer Reviews section on the Dashboard.
3. P1 reads a review left by a customer for S1.
4. P1 writes and submits a reply to the review.
5. P1 exits.

#### 9. Provider: US-PROV-004 — Delete a service
1. P1 logs in.
2. P1 navigates to the My Services section on the Dashboard.
3. P1 locates S1 and clicks Delete.
4. P1 confirms the deletion.
5. P1 exits.

---

#### 10. Admin: US-ADMIN-001 — Manage users and content
1. Admin logs in.
2. Admin views all users.
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
