#  LAB 7 Ecommerce API Lab

This is a Spring Boot REST API that manages a product catalog.

## How to Run the Project
1. Open the project in VS Code.
2. Open the terminal.
3. Run the command: `./gradlew bootRun` (or click the 'Run' button).

## API Endpoints
* **Get all products:** `http://localhost:8080/api/v1/products`
* **Search by price:** `http://localhost:8080/api/v1/products/search?maxPrice=50`

## Technologies Used
* Java / Spring Boot
* Gradle
* Git/GitHub

# LABORATORY 8

# Database Schema

This service manages the application's core inventory data using an embedded, in-memory **H2 Database** running in MySQL compatibility mode.

## Data Model

### PRODUCT Table

Stores individual item details within the active repository.

| Field Name | Type | Rules / Constraints | Purpose |
| --- | --- | --- | --- |
| **id** | BIGINT | PRIMARY KEY, AUTO_INCREMENT | Unique, auto-generated sequence number for the item. |
| **name** | VARCHAR(255) | NOT NULL | The public title or designation of the merchandise. |
| **price** | DOUBLE | NOT NULL | The current retail cost per single unit. |
| **description** | VARCHAR(255) | NULL | Additional details or specifications regarding the item. |


## REST API Interface

The ProductController layer exposes the following network routes, routing incoming requests directly to the Spring Data JPA persistence layer.

### Endpoint Summary

| Method | Route | Payload Format (JSON) | Success Code | Function |
| --- | --- | --- | --- | --- |
| **GET** | /api/v1/products | *None* | 200 OK | Retrieves a complete collection of all stored items as a JSON array. |
| **POST** | /api/v1/products | { "name": "string", "price": 0.0, "description": "string" } | 200 OK | Processes a new item payload, instantiates the record, and commits it to the database. |

I understand! You want the `README.md` content formatted clearly, keeping the technical requirements of your Lab 9 manual but without any DTO references.

Here is the clean, professional version ready to be copied into your `README.md`:

---

# Lab 9: E-Commerce API Security & Input Validation

## 1. Security Architecture

This application utilizes **Session-Based Authentication** to secure the REST API.

* **Authentication**: Upon successful login, the system validates user credentials against the database. If correct, it establishes a server-side session.
* **Session Management**: The server generates a unique `JSESSIONID` cookie. The client (Postman or Browser) automatically includes this cookie in subsequent requests to maintain the user's authenticated state.
* **Authorization**: Role-Based Access Control (RBAC) is implemented using method-level security (e.g., `@PreAuthorize`) to ensure that only authorized users or administrators can access protected endpoints.

## 2. Validation Rules

To maintain data integrity, the system applies strict constraints directly to the application entities:

* **User Entity**:
* `username`: Must not be blank and must be between 8 and 20 characters.
* `password`: Must not be blank and must have a minimum length of 6 characters.


* **Product Entity**:
* `name`: Must not be blank.
* `price`: Must be a positive numerical value (greater than 0).



*Validation failures are intercepted by a global `@ControllerAdvice` handler, returning a structured `400 Bad Request` JSON response.*

## 3. API Reference & Authentication

| Method | Endpoint | Access Level |
| --- | --- | --- |
| `POST` | `/api/v1/auth/register` | Public |
| `POST` | `/login` | Public |
| `GET` | `/api/v1/products` | Public |
| `POST` | `/api/v1/orders` | Authenticated |
| `DELETE` | `/api/v1/products/{id}` | ADMIN Only |


fix thiss
