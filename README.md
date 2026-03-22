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

