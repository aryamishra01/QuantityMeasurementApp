# 📏 Quantity Measurement App

## 📌 Overview
The Quantity Measurement App compares two quantities (such as length, weight, volume, etc.) and provides comparison across different units.

The application will progressively add:

🔄 Conversion from one unit to another  
➕ Support for quantity arithmetic  
➖ Subtraction  
➗ Division  
🛡️ Cross-category validation  

This app is being developed incrementally. Each use case defines a specific scope, and development must strictly follow that scope.

---

# 🚀 Implemented Features

---

## ✅ UC1: Feet Measurement Equality

### 📖 Description
The QuantityMeasurementApp class checks the equality of two numerical values measured in feet. It ensures accurate comparison and handles important edge cases.

### 🔎 Preconditions
- The QuantityMeasurementApp class is instantiated.
- Two numerical values in feet are provided for comparison.

### 🔄 Main Flow
1. User inputs two numerical values in feet.
2. Input values are validated to ensure they are numeric.
3. The two values are compared for equality.
4. The result (true/false) is returned.

### 📤 Postconditions
- Returns true if both values are equal.
- Returns false if values are not equal.

### 🧠 Concepts Learned (UC1)
- ✅ Object Equality – Properly overriding `equals()` method  
- ✅ Floating-Point Comparison – Using `Double.compare()`  
- ✅ Null Safety  
- ✅ Type Safety  
- ✅ Encapsulation & Immutability  
- ✅ Unit Testing Best Practices  

### 🧪 Sample Test Cases
- testEquality_SameValue()  
- testEquality_DifferentValue()  
- testEquality_NullComparison()  
- testEquality_SameReference()  

🔗 [UC1 Implementation](https://github.com/aryamishra01/QuantityMeasurementApp/tree/feature/UC1-FeetEquality)

---

## ✅ UC2: Feet and Inches Measurement Equality

### 📖 Description
The application now supports equality comparison for both Feet and Inches measurements while maintaining strict type safety.

### 🔎 Preconditions
- Feet and Inches classes are properly defined.
- Objects must belong to the same measurement type.

### 🔄 Main Flow
1. Create two measurement objects (Feet or Inches).
2. Values are stored in immutable fields.
3. The `equals()` method is invoked.
4. Type checking ensures only same-type objects are compared.

### 📤 Postconditions
- Same type & same value → true  
- Different type → false  

### 🧠 Concepts Learned (UC2)
- ✅ Extending functionality safely  
- ✅ Maintaining Equality Contract  
- ✅ Strict Type Safety  
- ✅ Clean Modular Design  

### 🧪 Sample Test Cases
- testFeetEquality_SameValue()  
- testInchesEquality_SameValue()  
- testFeetAndInchesComparison_ShouldReturnFalse()  

🔗 [UC2 Implementation](https://github.com/aryamishra01/QuantityMeasurementApp/tree/feature/UC2-InchEquality)

---

## ✅ UC3: Generic Length Equality

### 📖 Description
Introduces `QuantityLength` and `LengthUnit` enum to enable cross-unit comparison.

Example:  
1.0 ft == 12.0 inch → true

### 🔎 Preconditions
- QuantityLength object is created with value and valid LengthUnit.
- Units are defined in enum with conversion factors.

### 🔄 Main Flow
1. Create two QuantityLength objects.
2. Convert both to base unit (Feet).
3. Compare using `Double.compare()`.

### 📤 Postconditions
- Returns true if converted values are equal.
- Returns false otherwise.

### 🧠 Concepts Learned (UC3)
- ✅ Refactoring to Generic Design  
- ✅ DRY Principle  
- ✅ Enum Usage  
- ✅ Cross-Unit Conversion  

### 🧪 Sample Test Cases
- testCrossUnitEquality()  
- testSameUnitEquality()  
- testDifferentValues_ShouldReturnFalse()  

🔗 [UC3 Implementation](https://github.com/aryamishra01/QuantityMeasurementApp/tree/feature/UC3-GenericLength)

---

## ✅ UC4: Add Length (Same Unit)

### 📖 Description
Supports addition of two length quantities belonging to the same unit.

Example:  
5 ft + 5 ft → 10 ft

### 🔎 Preconditions
- Two QuantityLength objects exist.
- Both belong to same category.

### 🔄 Main Flow
1. Convert to base unit.
2. Perform addition.
3. Return new immutable object.

### 📤 Postconditions
- Returns new object with sum.
- Original objects remain unchanged.

### 🧠 Concepts Learned (UC4)
- ✅ Arithmetic Operations  
- ✅ Immutability  
- ✅ Method Design  

### 🧪 Sample Test Cases
- testAdd_SameUnit()  
- testAdd_ResultZero()  

🔗 [UC4 Implementation](https://github.com/aryamishra01/QuantityMeasurementApp/tree/feature/UC4-YardEquality)

---

## ✅ UC5: Add Length (Different Units)

### 📖 Description
Supports addition between different length units.

Example:  
1 ft + 12 inch → 2 ft

### 🔎 Preconditions
- Units belong to Length category.

### 🔄 Main Flow
1. Convert both to base unit.
2. Add.
3. Convert back to original unit.

### 📤 Postconditions
- Returns correct converted sum.

### 🧠 Concepts Learned (UC5)
- ✅ Base Unit Normalization  
- ✅ Cross-Unit Arithmetic  

### 🧪 Sample Test Cases
- testAdd_CrossUnit()  

🔗 [UC5 Implementation](https://github.com/aryamishra01/QuantityMeasurementApp/tree/feature/UC5-UnitConversion)

---

## ✅ UC6: Introduce Weight Measurement

### 📖 Description
Adds support for weight measurement using WeightUnit enum.

Example:  
1 kg == 1000 g → true

### 🧠 Concepts Learned (UC6)
- ✅ Generic Programming  
- ✅ Multi-category Support  

### 🧪 Sample Test Cases
- testWeightEquality()  

🔗 [UC6 Implementation](https://github.com/aryamishra01/QuantityMeasurementApp/tree/feature/UC6-UnitAddition)

---

## ✅ UC7: Introduce Volume Measurement

### 📖 Description
Adds support for volume measurement using VolumeUnit enum.

Example:  
1 liter == 1000 ml → true

### 🧠 Concepts Learned (UC7)
- ✅ System Scalability  
- ✅ Enum-Based Conversion  

### 🧪 Sample Test Cases
- testVolumeEquality()  

🔗 [UC7 Implementation](https://github.com/aryamishra01/QuantityMeasurementApp/tree/feature/UC7-TargetUnitAddition)

---

## ✅ UC8: Subtract Quantities

### 📖 Description
Supports subtraction for same-category quantities.

Example:  
5 ft − 2 ft → 3 ft

### 🧠 Concepts Learned (UC8)
- ✅ Subtraction Logic  
- ✅ Negative Result Handling  

### 🧪 Sample Test Cases
- testSubtract_SameUnit()  

🔗 [UC8 Implementation](https://github.com/aryamishra01/QuantityMeasurementApp/tree/feature/UC8-StandaloneUnit)

---

## ✅ UC9: Cross-Category Validation

### 📖 Description
Prevents operations between different measurement categories.

Example:  
1 ft + 1 kg → IllegalArgumentException

### 🧠 Concepts Learned (UC9)
- ✅ Defensive Programming  
- ✅ Runtime Validation  

### 🧪 Sample Test Cases
- testAdd_DifferentCategory_ShouldThrow()  

🔗 [UC9 Implementation](https://github.com/aryamishra01/QuantityMeasurementApp/tree/feature/UC9-WeightMeasurement)

---

## ✅ UC10: Division Operation

### 📖 Description
Supports division of quantity by numeric value.

Example:  
10 ft ÷ 2 → 5 ft

### 🧠 Concepts Learned (UC10)
- ✅ Exception Handling  
- ✅ Arithmetic Validation  

### 🧪 Sample Test Cases
- testDivide_NormalCase()  
- testDivide_ByZero_ShouldThrow()  

🔗 [UC10 Implementation](https://github.com/aryamishra01/QuantityMeasurementApp/tree/feature/UC10-GenericQuantity)

---

## ✅ UC11: Immutability & Chain Operations

### 📖 Description
Ensures original object remains unchanged and supports chained operations.

Example:  
(2 ft + 3 ft) − 1 ft → 4 ft

### 🧠 Concepts Learned (UC11)
- ✅ Immutability  
- ✅ Method Chaining  

### 🧪 Sample Test Cases
- testChainOperations()  
- testImmutability()  

🔗 [UC11 Implementation](https://github.com/aryamishra01/QuantityMeasurementApp/tree/feature/UC11-VolumeMeasurement)

---

## ✅ UC12: Final Generic Quantity Model

### 📖 Description
Final architecture using:

- Unit interface  
- LengthUnit  
- WeightUnit  
- VolumeUnit  
- Generic Quantity<U extends Unit>

Supports:

- Equality  
- Addition  
- Subtraction  
- Division  
- Cross-unit conversion  
- Cross-category validation  

### 🧠 Concepts Mastered
- ✅ Generic Programming  
- ✅ SOLID Principles  
- ✅ Clean Architecture  
- ✅ High Test Coverage  

### 🧪 Sample Test Cases
- testFullIntegration()  

🔗 [UC12 Implementation ](https://github.com/aryamishra01/QuantityMeasurementApp/tree/feature/UC12-SubtractionDivision)

---

# ✅ UC13: Centralized Arithmetic Logic

## 📖 Description
Architectural refinement introducing:

- Centralized arithmetic method inside `Quantity`
- Removal of duplicated conversion logic
- Functional interface–based operation handling

Supports:

- Equality  
- Addition  
- Subtraction  
- Division  
- Cross-unit conversion  
- Cross-category validation  

⚠ No new functionality added.  
All previous use cases (UC1–UC12) remain unchanged and fully functional.

---

## 🧠 Concepts Mastered

✅ DRY Principle (Don’t Repeat Yourself)  
✅ Refactoring Without Changing Behavior  
✅ Functional Interfaces (`BinaryOperator`)  
✅ Centralized Logic Design  
✅ Clean Architecture Refinement  
✅ Backward Compatibility Preservation  

---

## 🧪 Sample Test Cases

- testAdditionStillWorks()  
- testSubtractionStillWorks()  
- testDivisionStillWorks()  
- testCrossCategoryValidation()  

---

🔗 [UC13 Implementation](https://github.com/aryamishra01/QuantityMeasurementApp/tree/feature/UC13-CentralizedArithmeticLogic)

Refactored `Quantity` class introducing:

```java
private Quantity<U> performOperation(
    Quantity<U> other,
    U targetUnit,
    BinaryOperator<Double> operator
)
```

Public methods delegate:

```java
add()      → performOperation(..., Double::sum)
subtract() → performOperation(..., (a, b) -> a - b)
```

---

# ✅ UC14: Temperature Measurement

## 📖 Description
Extension of Generic Quantity framework introducing:

- `TemperatureUnit` enum
- Non-linear conversion logic
- Offset-based transformations

Supports:

- Equality  
- Addition  
- Subtraction  
- Cross-unit conversion  
- Cross-category validation  

No modification required in `Quantity` class or centralized arithmetic logic.

---

## 🌡 Temperature Units

Base Unit: **Celsius**

Supported Units:

- Celsius  
- Fahrenheit  
- Kelvin  

---

## 🔄 Conversion Logic

### Celsius ↔ Fahrenheit

```
°F = (°C × 9/5) + 32
°C = (°F − 32) × 5/9
```

### Celsius ↔ Kelvin

```
K = °C + 273.15
°C = K − 273.15
```

---

## 🧠 Concepts Mastered

✅ Non-linear Unit Conversion  
✅ Offset-Based Transformation  
✅ Enum Constant-Specific Behavior  
✅ Polymorphism through Method Overriding  
✅ Open–Closed Principle Compliance  
✅ Architectural Scalability Validation  

---

## 🧪 Sample Test Cases

- testCelsiusFahrenheitEquality()  
- testCelsiusKelvinEquality()  
- testTemperatureConversion()  
- testTemperatureAddition()  
- testCrossCategoryRestriction()  

---

🔗 [UC14 Implementation](https://github.com/aryamishra01/QuantityMeasurementApp/tree/feature/UC14-TemperatureMeasurement)

```java
enum TemperatureUnit implements IMeasurable
```

Each constant overrides:

```java
double toBase(double value);
double fromBase(double baseValue);
```

Framework now supports both:

- Linear transformations (Length, Weight, Volume)
- Non-linear transformations (Temperature)

Without modifying the core arithmetic engine.

---

# ✅ UC15: N-Tier Architecture Refactoring

## 📖 Description
Refactoring of the Quantity Measurement Application into a **clean N-Tier Architecture**.

Introduces layered separation:

- Controller Layer  
- Service Layer  
- Repository Layer  
- DTO Layer  

Improves:

- Maintainability  
- Scalability  
- Separation of Concerns  

The system continues to support:

- Unit conversion  
- Equality comparison  
- Cross-unit validation  

---

## 🏗 Architecture Layers

**Controller**  
Handles incoming requests and delegates them to the service layer.

**Service**  
Contains the core business logic for quantity conversion and equality checks.

**Repository**  
Implements an in-memory cache using the Singleton pattern.

**DTO**  
Transfers quantity data between layers.

---

## 🔄 Supported Measurements

- Length  
- Weight  
- Volume  
- Temperature  

---

## 🧠 Concepts Mastered

✅ N-Tier Architecture  
✅ Service-Oriented Design  
✅ DTO Pattern  
✅ Singleton Pattern  
✅ Enum-Based Unit Modeling  
✅ Separation of Concerns  

---

## 🧪 Sample Test Cases

- givenFeet_WhenConvertedToInches()  
- givenFeetAndInches_WhenEqual()  
- givenKilogram_WhenConvertedToGram()  
- givenLitre_WhenConvertedToMillilitre()  
- givenCelsius_WhenConvertedToFahrenheit()  
- givenInvalidUnit_ShouldThrowException()  

🔗 [UC15 Implementation](https://github.com/aryamishra01/QuantityMeasurementApp/tree/feature/UC15-N-Tier)

---

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
```

# ✅ UC17: Spring Boot REST API + JPA Integration

## 📖 Overview
UC17 upgrades the **Quantity Measurement Application** into a **production-ready Spring Boot REST service**.

It replaces manual JDBC, JSON handling, and object wiring with:
- Spring Boot (auto configuration)
- Spring Data JPA (no SQL)
- Spring MVC (REST APIs)
- Swagger (API docs)
- Actuator (monitoring)
- Spring Security (foundation)

All functionality from **UC1–UC16 is preserved**.

---

## 🎯 Objectives
- Expose operations via REST APIs
- Replace JDBC with Spring Data JPA
- Enable Dependency Injection (IoC)
- Add validation using `@Valid`
- Centralized exception handling (`@ControllerAdvice`)
- Swagger API documentation
- Actuator monitoring endpoints

---

## 🏗 Architecture

- `@RestController` → Handles HTTP requests
- `@Service` → Business logic
- `@Repository` → JPA data access
- H2 → In-memory database

---

## 🔄 UC16 → UC17 Changes

| Feature | UC16 | UC17 |
|--------|------|------|
| API | No HTTP | REST API |
| DB Access | JDBC | Spring Data JPA |
| DI | Manual | Spring IoC |
| JSON | Manual | Auto (Spring MVC) |
| Exception | Try-catch | Global Handler |
| Docs | None | Swagger |
| Monitoring | None | Actuator |

---

## 🔹 REST Endpoints

| Method | Endpoint | Description |
|--------|---------|------------|
| POST | `/compare` | Compare quantities |
| POST | `/convert` | Convert units |
| POST | `/add` | Add quantities |
| POST | `/subtract` | Subtract |
| POST | `/divide` | Divide |
| GET | `/history/operation/{op}` | History by operation |
| GET | `/history/type/{type}` | History by type |
| GET | `/history/errored` | Error records |

---

## 🔹 Key Components

### Controller
- `@RestController`
- Handles API requests/responses

### Service
- `@Service`
- Business logic

### Repository
- `JpaRepository`
- No SQL required

### Entity
- `@Entity`, `@Id`, `@GeneratedValue`

### Exception Handling
- `@RestControllerAdvice`
- Global error handling

```

## ⚙️ application.properties

```properties
spring.datasource.url=jdbc:h2:mem:quantitymeasurementdb
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true

spring.h2.console.enabled=true
springdoc.swagger-ui.path=/swagger-ui.html

management.endpoints.web.exposure.include=health,info
server.port=8080
```

# ✅ UC18: Spring Security - JWT Authentication & Google OAuth2 for Quantity Measurement

## 📖 Description
UC18 secures the Quantity Measurement Application by introducing enterprise-grade authentication and authorization using Spring Security, JWT (JSON Web Tokens), and Google OAuth2.

In UC17, all REST endpoints were publicly accessible — anyone could call `/api/v1/quantities/compare` without any identity. UC18 changes this completely:

- Every API endpoint now requires a valid JWT token  
- Users can register and login using username/password (JWT)  
- Users can also sign in using Google OAuth2 (Sign in with Google)  
- Both methods return the same JWT token format for consistent API access  
- Role-based access control restricts certain endpoints to ADMIN users only  

UC18 is fully backward compatible with UC1–UC17. All business logic and REST endpoints are preserved — they now simply require authentication.

---

## 🎯 Objective
- Implement JWT-based authentication (register + login)  
- Implement Google OAuth2 sign-in with auto user creation  
- Protect all `/api/v1/quantities/**` endpoints with JWT  
- Implement role-based access control (`ROLE_USER`, `ROLE_ADMIN`)  
- Centralize authentication logic in AuthService  
- Integrate with Swagger UI for easy token-based API testing  
- Persist users and roles using Spring Data JPA  

---

## 🏗 Updated Architecture
```
Client (Swagger / Postman / Browser)
↓
JwtAuthFilter (intercepts every request)
↓
SecurityConfig (which URLs need auth)
↙ ↘
JWT Login Google OAuth2
↓ ↓
AuthService OAuth2SuccessHandler
↓ ↓
UserRepository UserRepository (auto-create user)
↓ ↓
JWT Token returned
↓
Client sends: Authorization: Bearer <token>
↓
REST Controller processes request
```
---

## 🔐 Authentication Flow

### JWT Flow (username/password)
1. `POST /auth/register` → User created in DB → JWT returned  
2. `POST /auth/login` → Password verified → JWT returned  
3. Copy token from response  
4. Add to Swagger: Authorize → `Bearer <token>`  
5. All API calls now authenticated ✅  

---

### Google OAuth2 Flow
1. Browser → `http://localhost:8080/oauth2/authorization/google`  
2. Google login page appears  
3. User signs in with Gmail  
4. OAuth2SuccessHandler creates user in DB (if new)  
5. JWT token returned as JSON response  
6. Copy token → use in Swagger as `Bearer <token>`  
7. All API calls now authenticated ✅  

---

## 🔹 New Components

### Security Package
| Class | Purpose |
|------|--------|
| JwtUtils | Generates, validates, parses JWT |
| JwtAuthFilter | Intercepts requests and validates JWT |
| UserDetailsServiceImpl | Loads user from DB |
| OAuth2SuccessHandler | Handles Google login |

---

### Model Layer
| Class | Purpose |
|------|--------|
| User | Stores user info, provider, roles |
| Role | ROLE_USER / ROLE_ADMIN |

---

### Repository Layer
| Interface | Purpose |
|----------|--------|
| UserRepository | findByEmail, existsByEmail |
| RoleRepository | findByName |

---

### Controller Layer
| Class | Endpoints |
|------|----------|
| AuthController | `/auth/register`, `/auth/login` |
| UserController | `/users/me`, `/users/all` |

---

## 🔒 Security Rules

| URL | Access |
|----|-------|
| `/auth/**` | Public |
| `/oauth2/**` | Public |
| `/swagger-ui/**` | Public |
| `/h2-console/**` | Public |
| `/users/all` | ADMIN only |
| `/users/me` | Authenticated |
| `/api/v1/quantities/**` | Authenticated |

---

## 🗄 Database Tables

```sql
CREATE TABLE users (...);
CREATE TABLE roles (...);
CREATE TABLE user_roles (...);

INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
```
---
## 🧠 Spring Security Concepts Learned

| Concept | Implementation |
|--------|---------------|
| JWT generation | `JwtUtils.generateTokenFromEmail()` using jjwt library |
| JWT validation | `JwtUtils.validateToken()` — checks signature + expiry |
| JWT filter | `JwtAuthFilter` extends `OncePerRequestFilter` |
| Stateless sessions | `SessionCreationPolicy.STATELESS` — no server-side sessions |
| Password encoding | `BCryptPasswordEncoder` — industry standard hashing |
| UserDetails | `UserDetailsServiceImpl.loadUserByUsername()` |
| Authentication | `AuthenticationManager.authenticate()` |
| OAuth2 | `oauth2Login().successHandler(OAuth2SuccessHandler)` |
| Role-based access | `@PreAuthorize("hasRole('ADMIN')")` |
| Method security | `@EnableMethodSecurity` on `SecurityConfig` |
| Public URLs | `.requestMatchers(...).permitAll()` |
| Protected URLs | `.anyRequest().authenticated()` |

---

## 📤 Postconditions

- All `/api/v1/quantities/**` endpoints require a valid JWT ✅  
- `POST /auth/register` creates user with BCrypt password and ROLE_USER ✅  
- `POST /auth/login` authenticates and returns JWT ✅  
- Google OAuth2 sign-in auto-creates user and returns JWT ✅  
- `GET /users/me` returns current user profile ✅  
- `GET /users/all` accessible only to ROLE_ADMIN ✅  
- Swagger UI works with Authorize → Bearer token ✅  
- H2 console remains accessible without auth ✅  
- All UC1–UC17 business logic preserved ✅  

---

## 🚀 Architectural Evolution

| Use Case | Capability Added |
|---------|----------------|
| UC1–UC8 | Length measurement operations |
| UC9 | Weight measurement |
| UC10 | Generic quantity architecture |
| UC11 | Volume measurement |
| UC12 | Subtraction & Division |
| UC13 | Centralized arithmetic logic |
| UC14 | Temperature measurement |
| UC15 | N-Tier architecture |
| UC16 | JDBC database persistence |
| UC17 | Spring Boot REST API + JPA |
| UC18 | JWT + Google OAuth2 + Role-based Security |

---

## 🔥 Key Achievement

UC18 transforms the application from an open REST API into a **secured, production-ready service**.

The system now supports:

- Stateless JWT authentication — scales horizontally without session storage  
- Google OAuth2 — enterprise-grade social login  
- Role-based authorization — fine-grained access control  
- BCrypt password hashing — secure credential storage  
- Foundation ready for: refresh tokens, email verification, rate limiting, and cloud deployment  
