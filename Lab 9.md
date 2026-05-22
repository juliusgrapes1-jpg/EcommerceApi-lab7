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


