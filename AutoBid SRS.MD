
# Requirements – Starter Template

**Project Name:** AUTOBID
**Team:** Rayan othman- system admin
**Course:** CSC 340
**Version:** 1.0\
**Date:** 2026-02-11

---

## 1. Overview
**Vision.**  This system is for automobile owners detailers and mechanics alike to all connect and search and exchange services vehicle owners can book detailing and mobile mechanic services straight to their home and vice verse mechanics and detailers can find jobs. Elimating the issue of having to leave your home and save you hopefully both time and money

**Glossary** 
- **Term 1:** mechanic a person who cme and dignoses your vehhicle and or does minor to moderate repairs.
- **Term 2:** detailer- a person who comes and cleans your vehicle

**Primary Users / Roles.**
- **Customer (e.g., Student/Patient/Pet Owner/etc. )** —  the customer should be able to create a log in book an appointment and complete their transaction smoothly.
- **Provider (e.g., Teacher/Doctor/Pet Sitter/etc. )** — the provider much like the customer should be able to creat a log in and post their services on the system and make adjustment with ease.
- **SysAdmin (optional)** — the sysadmin should be able to make adjustments and reveiw both the customer and provider information and make edits as needed to the system
**Scope (this semester).**
- <capability 1> make an account
- <capability 2> browse or list services
- <capability 3> all aspects of system should run cleanly and smoothly on all sides efficiently and allows customers to checkout and providers to process jobs.

**Out of scope (deferred).**
- <deferred 1> processing payment
- <deferred 2> handling complaints in regards to job completion and payment refund as well as processing real live users

> This document is **requirements‑level** and solution‑neutral; design decisions (UI layouts, API endpoints, schemas) are documented separately.

---

## 2. Functional Requirements (User Stories)
Write each story as: **As a `<role>`, I want `<capability>`, so that `<benefit>`.** Each story includes at least one **Given/When/Then** scenario.

### 2.1 Customer Stories
- **US‑CUST‑001 — <short title>**  
  _Story:_ As a customer, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

- **US‑CUST‑002 — <short title>**  
  _Story:_ As a customer, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

### 2.2 Provider Stories
- **US‑PROV‑001 — <short title>**  
  _Story:_ As a provider, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

- **US‑PROV‑002 — <short title>**  
  _Story:_ As a provider, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

#### 2.3 SysAdmin Stories

- **US-ADMIN-001 — Manage User Accounts**  
  _Story:_ As a sysadmin, I want to create, deactivate, and manage user accounts so that the system remains secure and organized.  
  _Acceptance:_
  ```gherkin
  Scenario: Deactivate a user account
    Given -the sysadmin is logged into the system
    And the sysadmin is viewing the user management page
    When- the sysadmin selects a user and clicks "Deactivate"
    Then= the user account status changes to inactive
    And the user can no longer log into the system

  ```


```markdown
- **US-ADMIN-002 — Manage Service Catalog**  
  _Story:_ As a sysadmin, I want to add, update, or remove service types and pricing so that service offerings remain accurate and up to date.  
  _Acceptance:_
  ```gherkin
  Scenario: Add a new service type
    Given- the sysadmin is logged into the system
    And the sysadmin is on the service management page
    When- the sysadmin enters a service name and price
    And clicks "Save"
    Then- the new service appears in the customer booking options


---

## 3. Non‑Functional Requirements (make them measurable)
- **Performance:** description 
- **Availability/Reliability:** description
- **Security/Privacy:** description
- **Usability:** description

---

## 4. Assumptions, Constraints, and Policies
- list any rules, policies, assumptions, etc.

---

## 5. Milestones (course‑aligned)
- **M2 Requirements** — this file + stories opened as issues. 
- **M3 High‑fidelity prototype** — core customer/provider flows fully interactive. 
- **M4 Design** — architecture, schema, API outline. 
- **M5 Backend API** — key endpoints + tests. 
- **M6 Increment** — ≥2 use cases end‑to‑end. 
- **M7 Final** — complete system & documentation. 

---

## 6. Change Management
- Stories are living artifacts; changes are tracked via repository issues and linked pull requests.  
- Major changes should update this SRS.
