# Requirements – AutoBid

**Project Name:** AutoBid  
**Team:** Rayyan Othman – System Admin  
**Course:** CSC 340  
**Version:** 1.0  
**Date:** 2026-02-11

---

## 1. Overview

**Vision.**
This system connects automobile owners, detailers, and mechanics. Vehicle owners can book detailing and mobile mechanic services straight to their home, while mechanics and detailers can find jobs — eliminating the need to leave your home and saving both time and money.

**Glossary**
- **Mechanic** – A person who comes and diagnoses your vehicle and/or performs minor to moderate repairs.
- **Detailer** – A person who comes and cleans your vehicle.

**Primary Users / Roles**
- **Customer** – The customer should be able to create a login, book an appointment, and complete their transaction smoothly.
- **Provider** – The provider should be able to create a login, post their services on the system, and make adjustments with ease.
- **SysAdmin** – The sysadmin should be able to make adjustments and review both customer and provider information, and make edits as needed to the system.

**Scope (this semester)**
- Create an account
- Browse or list services
- All aspects of the system should run cleanly and smoothly on all sides, allowing customers to checkout and providers to process jobs

**Out of Scope (deferred)**
- Processing payment
- Handling complaints regarding job completion, payment refunds, and processing real live users

> This document is **requirements-level** and solution-neutral; design decisions (UI layouts, API endpoints, schemas) are documented separately.

---

## 2. Functional Requirements (User Stories)

Each story follows the format: **As a `<role>`, I want `<capability>`, so that `<benefit>`.**

---

### 2.1 Customer Stories

- **US-CUST-001 — Register Account**

  *Story:* As a customer, I want to create an account so that I can access booking features.

  *Acceptance:*
```gherkin
  Scenario: Successful registration
    Given the customer is on the registration page
    When they enter valid name, email, and password
    Then the system creates the account
    And logs the customer in automatically

  Scenario: Invalid registration
    Given the customer is on the registration page
    When they submit incomplete or invalid information
    Then the system displays an error message
    And the account is not created
```

---

- **US-CUST-002 — Customer Login**

  *Story:* As a customer, I want to log into my account so that I can manage bookings.

  *Acceptance:*
```gherkin
  Scenario: Successful login
    Given the customer has a registered account
    When they enter correct credentials
    Then they are logged into the dashboard

  Scenario: Failed login
    Given the customer enters incorrect credentials
    When they attempt to log in
    Then the system shows an error message
    And denies access
```

---

- **US-CUST-003 — Browse Services**

  *Story:* As a customer, I want to browse available services so that I can choose a provider.

  *Acceptance:*
```gherkin
  Scenario: View services
    Given the customer is logged in
    When they open the services page
    Then a list of providers and services is displayed
    And each service shows description and availability
```

---

- **US-CUST-004 — Book Appointment**

  *Story:* As a customer, I want to book an appointment so that I can schedule service at my location.

  *Acceptance:*
```gherkin
  Scenario: Successful booking
    Given the customer selects a provider
    When they choose a time and confirm
    Then the appointment is saved
    And the provider receives a notification
```

---

- **US-CUST-005 — View Booking History**

  *Story:* As a customer, I want to view my booking history so that I can track past and upcoming services.

  *Acceptance:*
```gherkin
  Scenario: View bookings
    Given the customer is logged in
    When they open their dashboard
    Then all past and upcoming bookings are displayed
```

---

### 2.2 Provider Stories

- **US-PROV-001 — Create Provider Profile**

  *Story:* As a provider, I want to create and update my profile with qualifications and certifications so that customers can trust my services.

  *Acceptance:*
```gherkin
  Scenario: Create provider profile
    Given I am registered as a provider
    When I enter my qualifications and save the profile
    Then my provider profile is successfully saved
    And it is visible to customers
```

---

- **US-PROV-002 — Create Service Listings**

  *Story:* As a provider, I want to add mechanic or detailing services with pricing and detailed descriptions so that customers can review and book my offerings.

  *Acceptance:*
```gherkin
  Scenario: Publish service listing
    Given my provider profile is active
    When I enter the required service information and confirm
    Then the service is created in a "Published" state
    And it appears in customer search results
```

---


- **US-PROV-003 — View Booking Statistics**

  *Story:* As a provider, I want to view my booking history and customer ratings so that I can monitor my performance and service quality.

  *Acceptance:*
```gherkin
  Scenario: View provider statistics
    Given I am logged in as a provider
    When I access the statistics dashboard
    Then I can see my booking history
    And I can see my average rating
```

---

- **US-PROV-004 — Reply to Reviews**

  *Story:* As a provider, I want to respond to customer reviews so that I can address feedback professionally.

  *Acceptance:*
```gherkin
  Scenario: Reply to customer review
    Given a customer has submitted a review on my service
    When I submit a response
    Then my reply appears beneath the customer's review
```

---

### 2.3 SysAdmin Stories

- **US-ADMIN-001 — Manage User Accounts**

  *Story:* As a sysadmin, I want to create, deactivate, and manage user accounts so that the system remains secure and organized.

  *Acceptance:*
```gherkin
  Scenario: Deactivate a user account
    Given the sysadmin is logged into the system
    And the sysadmin is viewing the user management page
    When the sysadmin selects a user and clicks "Deactivate"
    Then the user account status changes to inactive
    And the user can no longer log into the system
```

---

- **US-ADMIN-002 — Manage Service Catalog**

  *Story:* As a sysadmin, I want to add, update, or remove service types and pricing so that service offerings remain accurate and up to date.

  *Acceptance:*
```gherkin
  Scenario: Add a new service type
    Given the sysadmin is logged into the system
    And the sysadmin is on the service management page
    When the sysadmin enters a service name and price
    And clicks "Save"
    Then the new service appears in the customer booking options
```

---

## 3. Non-Functional Requirements

- **Performance:** Description
- **Availability/Reliability:** Description
- **Security/Privacy:** Description
- **Usability:** Description

---

## 4. Assumptions, Constraints, and Policies

- List any rules, policies, assumptions, etc.

---

## 5. Milestones (Course-Aligned)

| Milestone | Description |
|---|---|
| **M2 Requirements** | This file + stories opened as issues |
| **M3 High-Fidelity Prototype** | Core customer/provider flows fully interactive |
| **M4 Design** | Architecture, schema, API outline |
| **M5 Backend API** | Key endpoints + tests |
| **M6 Increment** | ≥2 use cases end-to-end |
| **M7 Final** | Complete system & documentation |

---

## 6. Change Management

- Stories are living artifacts; changes are tracked via repository issues and linked pull requests.
- Major changes should update this SRS.
