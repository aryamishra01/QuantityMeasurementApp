# ✅ UC16: JDBC Database Integration for Quantity Measurement

## 📖 Overview
UC16 enhances the **Quantity Measurement Application** by introducing **database persistence using JDBC**.

Previously (UC15), data was stored in memory. UC16 upgrades this to a **database-backed system** using:
- JDBC for database interaction
- H2 in-memory database
- HikariCP for connection pooling
- SQL-based persistence

All functionality from **UC1–UC15 remains unchanged**.

---

## 🎯 Objectives
- Replace in-memory storage with database persistence
- Integrate JDBC for DB communication
- Store operations in relational tables
- Enable connection pooling (HikariCP)
- Maintain N-Tier architecture
- Support operation history tracking

---

## 🏗 Architecture

- Controller → handles input/output  
- Service → business logic  
- Repository → JDBC + SQL  
- Database → stores operations  

---

## 🔄 UC15 → UC16 Changes

| Feature | UC15 | UC16 |
|--------|------|------|
| Storage | In-memory | Database (H2) |
| Data Access | Cache | JDBC |
| Queries | None | SQL |
| Persistence | Temporary | Permanent |
| Connection | None | HikariCP |

---

## 🔹 Key Components

### Controller Layer
- Accepts `QuantityDTO`
- Calls service methods
- No DB interaction

### Service Layer
- Performs operations (add, compare, convert, etc.)
- Validates inputs
- Creates entities for storage

### Repository Layer
- `QuantityMeasurementDatabaseRepository`
- Uses JDBC + PreparedStatement
- Executes SQL queries

### Database Layer
- H2 In-Memory DB
- Auto schema creation via `schema.sql`

---

## 🗄 Database Schema

| Column | Description |
|-------|------------|
| id | Primary key |
| operand1 | First value |
| operand2 | Second value |
| operation_type | Operation performed |
| result | Output |
| error_message | Error (if any) |
| timestamp | Time of operation |

---

## 🔌 Connection Pool

- Implemented using **HikariCP**
- Improves performance
- Reuses DB connections

---

## 📊 Logging

- SLF4J + Logback
- Logs:
  - DB initialization
  - Connection status
  - Errors

---

## 🔄 Example Flow

1. Controller receives input  
2. Service processes logic  
3. Repository executes SQL  
4. Data stored in DB  

---

## 🧪 Example

### Input
``` id="uc16example"
2 ft == 24 in
