# ✅ UC15: N-Tier Architecture Refactoring for Quantity Measurement Application

## 📖 Description
UC15 refactors the **Quantity Measurement Application** into a clean **N-Tier Architecture** to improve maintainability, scalability, and separation of concerns.

Earlier use cases (**UC1–UC14**) implemented measurement logic in a single layer. While functional, that structure mixed responsibilities such as input handling, business logic, and data representation.

UC15 restructures the application into a layered architecture consisting of:

- Controller Layer
- Service Layer
- Repository Layer
- Entity / Model Layer
- Data Transfer Objects (DTO)

This refactoring introduces **professional architectural patterns** while preserving all existing measurement functionality.

---

## 🎯 Objective

- Refactor the application into **N-Tier Architecture**
- Introduce **DTO objects** for data transfer
- Introduce **Service Layer** for business logic
- Introduce **Repository Layer** for data storage
- Introduce **Entity Layer** for operation records
- Improve **testability and scalability**
- Preserve functionality from **UC1–UC14**
- Ensure **clear separation of responsibilities**

---

## 🏗 N-Tier Architecture

The application now follows the layered architecture below:

```
Application Layer
        ↓
Controller Layer
        ↓
Service Layer
        ↓
Repository Layer
        ↓
Entity / Model Layer
```

Each layer performs a specific responsibility and communicates through defined interfaces.

---

## 🔹 Controller Layer

**Class:** `QuantityMeasurementController`

**Responsibilities**

- Accept `QuantityDTO` input objects
- Validate input parameters
- Delegate operations to the service layer
- Display results or error messages

**Supported Operations**

- Comparison
- Conversion
- Addition
- Subtraction
- Division

The controller **does not contain business logic**.

---

## 🔹 Service Layer

**Interfaces / Classes**

- `IQuantityMeasurementService`
- `QuantityMeasurementServiceImpl`

**Responsibilities**

- Perform measurement operations
- Convert DTO objects into internal models
- Validate category compatibility
- Execute arithmetic operations
- Handle exceptions
- Create entity records for repository storage

The **Service Layer contains the core business logic**.

---

## 🔹 Repository Layer

**Interfaces / Classes**

- `IQuantityMeasurementRepository`
- `QuantityMeasurementCacheRepository`

**Responsibilities**

- Store operation records
- Maintain in-memory cache
- Persist operation history using serialization

**Design Pattern Used**

Singleton Pattern — ensures only one repository instance manages stored operations.

---

## 🔹 Data Transfer Objects (DTO)

**Class:** `QuantityDTO`

**Purpose**

Transfer data between **Controller and Service layers**.

Typical fields include:

- `value`
- `unit`
- `measurementType`

DTO objects **contain no business logic**.

---

## 🔹 Entity Layer

**Class:** `QuantityMeasurementEntity`

Represents a **stored record of a measurement operation**.

Stores information such as:

- operand values
- operation type
- result
- error message

Implements:

```
Serializable
```

so operation history can be persisted.

---

## 🔄 Example Application Flow

Example: **Length Equality Comparison**

1. Controller receives `QuantityDTO` objects  
2. Controller calls `Service.compare()`  
3. Service converts DTO → internal model  
4. Service performs equality check  
5. Service creates `QuantityMeasurementEntity`  
6. Repository stores operation  
7. Controller prints result  

---

## 🧪 Example Demonstrations

### 🔹 Example 1 — Length Equality

```
2 ft == 24 in
```

Output:

```
--- Equality Demonstration ---
Operation: COMPARISON
This Quantity: 2.0 FEET
That Quantity: 24.0 INCHES
Comparison Result: true
```

---

### 🔹 Example 2 — Temperature Conversion

```
0°C → Fahrenheit
```

Output:

```
Temperature conversion result: 32°F
```

---

### 🔹 Example 3 — Cross Category Validation

Attempt:

```
2 ft + 10 kg
```

Output:

```
Error: Cannot perform arithmetic between different measurement categories
```

---

## 🔒 Cross-Category Safety

The system prevents arithmetic operations across incompatible measurement domains.

Examples:

- Length + Weight → Invalid  
- Length + Temperature → Invalid  
- Weight + Volume → Invalid  

Such operations throw:

```
IllegalArgumentException
```

---

## 📤 Postconditions

- Application logic is separated into **clear layers**
- DTO objects standardize communication between layers
- Repository stores operation history
- Service layer centralizes business logic
- Existing measurement features remain unchanged
- System becomes **scalable and testable**

---

## 🧪 Key Concepts Tested

### 🏗 Architecture Concepts
- N-Tier Architecture
- Separation of Concerns
- Layered System Design

### 🔁 Design Patterns
- Singleton Pattern
- Dependency Injection
- DTO Pattern

### 📐 SOLID Principles
- Single Responsibility Principle (SRP)
- Open–Closed Principle (OCP)
- Liskov Substitution Principle (LSP)
- Interface Segregation Principle (ISP)
- Dependency Inversion Principle (DIP)

---

## 🧠 Concepts Learned

- N-Tier architecture design
- Service-oriented architecture
- Data Transfer Object pattern
- Repository abstraction
- Dependency injection
- Structured error handling
- Scalable application structure

---

## 🚀 Architectural Evolution

| Use Case | Capability Added |
|--------|----------------|
| UC1 | Feet equality |
| UC2 | Inch equality |
| UC3 | Generic Length |
| UC4 | Yard support |
| UC5 | Unit conversion |
| UC6 | Unit addition |
| UC7 | Explicit target addition |
| UC8 | Standalone units |
| UC9 | Weight management |
| UC10 | Generic quantity architecture |
| UC11 | Volume measurement |
| UC12 | Subtraction & Division |
| UC13 | Centralized arithmetic logic |
| UC14 | Temperature measurement |
| UC15 | N-Tier architecture refactoring |

---

## 🔥 Key Achievement

UC15 transforms the **Quantity Measurement Application** from a **single-layer program into a structured multi-layer architecture**.

Benefits:

- Better maintainability  
- Easier testing  
- Scalable system design  
- Clean separation of responsibilities  

The system is now ready for future extensions such as:

- REST APIs  
- Database persistence  
- Web interfaces  
- Microservices architecture
