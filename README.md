# 📦 Inventory Management API

A high-performance RESTful API built with **Spring Boot 3** and **Java 26**. This project manages e-commerce product inventory with persistent storage and complex search capabilities.

## Key Features
* **Layered Architecture:** Follows the Controller-Service-Repository pattern for clean, maintainable code.
* **Automated Seeding:** Database automatically populates with mock products on startup for immediate testing.
* **Dynamic Filtering:** Search products by **Category** or **Price Range** using optimized JPA Query Methods.
* **Precision Pricing:** Uses `BigDecimal` to ensure zero rounding errors in financial transactions.

## Tech Stack
* **Backend:** Spring Boot 3.4+
* **Database:** PostgreSQL 16
* **ORM:** Spring Data JPA (Hibernate)
* **Tools:** Lombok, Maven, IntelliJ IDEA

## API Endpoints
| Action | Method | Endpoint |
| :--- | :--- | :--- |
| **Get All** | `GET` | `/api/products` |
| **Filter Category** | `GET` | `/api/products/filter/category?name=Electronics` |
| **Filter Price** | `GET` | `/api/products/filter/price?min=100&max=1000` |
| **Create** | `POST` | `/api/products` |

## How to Run
1. Ensure **PostgreSQL** is running and a database named `inventory_db` exists.
2. Update `src/main/resources/application.properties` with your DB credentials.
3. Run `InventoryManagementApplication.java` from your IDE.
