# sp26-team11
team 11 group project for CSC 340 of 2026
-Rayyan Othman
-Gopal Vulli
-Gamal Hassan

## Title
> AutoBid 

## Team Members
> Team Member #1 Rayyan Othman


## Description 
Our project is a system/service that allows the customer to book mobie on site general mechanic and detailing services right to their fornt door with ease and convenience customer can veiw a list of provers and ther serbice the offer and book and leave reveiws with specialists that meet their need and providers can post themseves and their qualifications and receive reveiws on their work and get feedback and jobs for themselves through this system app. This app will solve the problem of being to busy to get tho these sort of service locations and the motivation behind this to make general repairs and cleaning and detailing for convenient automated and accesable for people.

## App Functions

1. Customer Gamal Hassan (the user with the customer role):
    1. Create/modify customer profile – Customers can register an account, log in securely, and update their personal information such as contact details and service preferences.
    2. View available services – Customers can browse a list of providers and available services, including pricing, descriptions, and ratings.
    3. Subscribe to available services – Customers can book services directly in the app by selecting a provider, choosing a time slot, and confirming the request.
    4. Write reviews for subscribed services – After a completed service, customers can leave ratings and written reviews to share feedback.



2. Provider Gopal Vulli (the user with the provider role):
    1. Create/modify/remove provider profile – Providers can register an account, add qualifications and credentials, update availability, or remove their profile.
    2. Create services – Providers can post mechanic, repair, or detailing services with pricing and service descriptions.
    3. View customer statistics – Providers can view booking history, ratings, and other service metrics.
    4. Reply to reviews – Providers can respond to customer reviews to address feedback.


3.  SysAdmin Rayyan othman (the user with the admin role ):
    1. Manage user access - will allow the system admin user to log in and make changes and veiw the app as an administrator .
    2. Moderate services - can remove add change or adjust the app ,services or users if needed.
    3. Moderate reviews - allows for removing commenting and moderation of all reveiw left by customers and providers.
    4. View usage statistics - System admine user can collect veiw and save data statistivs collected from the customer and provider use cases.


       ### SysAdmin Use Cases
- Manage user access -> `GET /users`, `PUT /users/{id}`
- Moderate services -> `GET /services`, `DELETE /services/{id}`
- Moderate reviews -> `GET /reviews`, `DELETE /reviews/{id}`
- View usage statistics -> `GET /statistics`

 
![032419BD-BE75-4F09-B05A-00B62E625A99](https://github.com/user-attachments/assets/14f88ad3-bef3-436c-ab6f-8d9d3120c00a)

   ## API Endpoints

### User Endpoints
- `GET /users` -> Get all users
- `GET /users/{id}` -> Get user by id
- `POST /users` -> Create a new user
- `PUT /users/{id}` -> Update an existing user
- `DELETE /users/{id}` -> Delete a user

### Service Endpoints
- `GET /services` -> Get all services
- `GET /services/{id}` -> Get service by id
- `POST /services` -> Create a new service
- `PUT /services/{id}` -> Update an existing service
- `DELETE /services/{id}` -> Delete a service

### Booking Endpoints
- `GET /bookings` -> Get all bookings
- `GET /bookings/{id}` -> Get booking by id
- `POST /bookings` -> Create a new booking
- `PUT /bookings/{id}` -> Update an existing booking
- `DELETE /bookings/{id}` -> Delete a booking

### Review Endpoints
- `GET /reviews` -> Get all reviews
- `GET /reviews/{id}` -> Get review by id
- `GET /reviews/provider/{providerId}` -> Get reviews for a provider
- `POST /reviews` -> Create a new review
- `PUT /reviews/{id}` -> Update an existing review
- `DELETE /reviews/{id}` -> Delete a review

### Reply Endpoints
- `GET /replies` -> Get all replies
- `GET /replies/{id}` -> Get reply by id
- `POST /replies` -> Create a reply to a review

### Statistics Endpoints
- `GET /statistics` -> View overall platform statistics
- `GET /statistics/provider/{providerId}` -> View statistics for a specific provider

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

#### Modify Customer Profile
Endpoint: PUT /users/1

Request:
{
  "firstName": "Rayyan",
  "lastName": "Othman",
  "email": "rayyan@email.com",
  "password": "newpassword123",
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

### Provider Use Cases

#### Create Provider Profile
Endpoint: POST /users

Request:
{
  "firstName": "John",
  "lastName": "Mechanic",
  "email": "john@autobid.com",
  "password": "123456",
  "phone": "3361112222",
  "role": "PROVIDER",
  "accountStatus": "ACTIVE"
}

Response:
{
  "id": 2,
  "firstName": "John",
  "lastName": "Mechanic",
  "email": "john@autobid.com",
  "phone": "3361112222",
  "role": "PROVIDER",
  "accountStatus": "ACTIVE"
}

---

#### Create Service
Endpoint: POST /services

Request:
{
  "title": "Mobile Oil Change",
  "description": "On-site oil change service",
  "price": 89.99,
  "category": "Mechanic",
  "availability": "Available",
  "provider": { "id": 2 }
}

Response:
{
  "id": 1,
  "title": "Mobile Oil Change",
  "price": 89.99
}

---

#### View Customer Statistics
Endpoint: GET /statistics/provider/2

Response:
{
  "providerId": 2,
  "servicesCreated": 1,
  "bookingsForProvider": 1,
  "reviewsForProvider": 1
}

---

#### Reply to Review
Endpoint: POST /replies

Request:
{
  "message": "Thank you for your feedback.",
  "review": { "id": 1 },
  "provider": { "id": 2 }
}

Response:
{
  "id": 1,
  "message": "Thank you for your feedback."
}

---

### SysAdmin Use Cases

#### Manage Users
Endpoint: GET /users

Response:
[
  {
    "id": 1,
    "email": "rayyan@email.com",
    "role": "CUSTOMER"
  },
  {
    "id": 2,
    "email": "john@autobid.com",
    "role": "PROVIDER"
  }
]

---

#### Ban User
Endpoint: PUT /users/1

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

Response:
{
  "message": "Service deleted successfully"
}

---

#### Moderate Reviews
Endpoint: DELETE /reviews/1

Response:
{
  "message": "Review deleted successfully"
}

---

#### View Platform Statistics
Endpoint: GET /statistics

Response:
{
  "totalUsers": 2,
  "totalServices": 1,
  "totalBookings": 1,
  "totalReviews": 1
}
