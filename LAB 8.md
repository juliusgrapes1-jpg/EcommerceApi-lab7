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