# SpringBoard 🏢
> **Enterprise Meeting Room Booking SaaS (Spring Boot Backend)**

SpringBoard is a robust, multi-tenant backend solution designed to manage meeting room scheduling for organizations. Built with **Java Spring Boot**, it follows strict Enterprise Engineering standards, featuring a 3-Tier Architecture, real-time availability calculations, and overlapping protection.

---

## 🚀 Key Features

### 1. Multi-Tenant Organization Structure
* **Company-Centric:** Users and Rooms are scoped to specific Companies, allowing multiple organizations to use the platform simultaneously without data leakage.
* **Role-Based Access:** Distinction between Admins (Dashboard access) and Employees (Booking access).

### 2. Smart Room Management (Stateless Availability)
* **Real-Time Calculation:** Unlike traditional apps that store "Busy" flags in the database, SpringBoard calculates room status on-the-fly.
* **Zero-Sync Errors:** By deriving status from the `Bookings` ledger at the moment of request, the system prevents "Ghost Bookings" (where a room says it's busy but the meeting ended hours ago).

### 3. Intelligent Booking Engine (Concurrency Managed)
* **Overlap Protection:** Uses custom **JPQL Queries** to detect time-slot conflicts at the database level before insertion.
* **Validation Layer:** Enforces logical constraints (e.g., Start Time must be before End Time, User/Room existence checks).
* **Package Integration:** seamlessly links bookings with service packages (catering, tech support).

### 4. Admin Dashboard 📊
* **Live Analytics:** Provides real-time metrics including:
    * Current Occupancy Rate (%)
    * Total Active Meetings (Right Now)
    * Available Room Count

---

## 🛠️ Technical Architecture

### Tech Stack
* **Framework:** Spring Boot 3+ (Java 17/21)
* **Database:** MySQL
* **ORM:** Spring Data JPA (Hibernate)
* **Tools:** Lombok, ModelMapper, Maven
* **API Testing:** Postman

### The "Special Sauce": How we handle Concurrency
Instead of relying on Java-level locks, we utilize the database's power to ensure booking integrity.

**The Overlap Logic (JPQL):**
We check for conflicts using a precise temporal query. A room is considered "Occupied" if:
'Existing_Start < New_End'  **AND** 'Existing_End > New_Start'

java:
@Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END " +
       "FROM BookingEntity b " +
       "WHERE b.roomId = :roomId " +
       "AND b.endTime > :newStart " +
       "AND b.startTime < :newEnd")
boolean existsOverlap(...);

---

## 🔌 API Endpoints (Snapshot)
🏢 Companies
POST /companies/add - Register a new organization.

GET /companies/get-all - List all tenants.

🛋️ Rooms
GET /rooms/get-all - Returns room list with calculated isBooked status.

POST /rooms/add - Add a new meeting space.

📅 Bookings
POST /bookings/add - Creates a booking (runs Validation & Overlap checks).

GET /bookings/user/{id} - Fetch schedule for a specific employee.

GET /bookings/room/{id} - Fetch calendar for a specific room.

📊 Dashboard
GET /Admin/get-dashboard-overview - Returns live statistics (Occupancy, Active Counts).

## ⚙️ Setup & Installation
Clone the Repo

Bash
git clone https://github.com/maalikhassan/SpringBoard.git

cd SpringBoard
Configure MySQL

Create a database named springboarddb.

Update src/main/resources/application.properties with your credentials:

Properties
spring.datasource.url=jdbc:mysql://localhost:3306/springboarddb
spring.datasource.username=root
spring.datasource.password=your_password
Run the Application

Bash
mvn spring-boot:run
Test

The API will be live at http://localhost:8080.

## 🔮 Future Roadmap
Frontend Integration: React/JavaFX Dashboard.

Email Notifications: Send confirmations upon successful booking.

Recurring Meetings: Logic for weekly/monthly slots.
---
Built for the Enterprise Engineering Module.
