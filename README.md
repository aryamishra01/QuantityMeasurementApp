# ✅ UC17: Spring Framework Integration - REST Services and JPA

## 📖 Description
UC17 transforms the Quantity Measurement Application into a **production-grade Spring Boot REST service**.

### Key Improvements:
- Spring Boot → eliminates manual configuration
- Spring Data JPA → replaces JDBC boilerplate
- Spring MVC → exposes REST APIs
- Swagger → interactive API documentation
- Actuator → application monitoring

✔ Fully backward compatible with UC1–UC16

---

## 🎯 Objectives
- Expose measurement operations as REST APIs
- Replace JDBC with Spring Data JPA
- Enable Dependency Injection (IoC)
- Add centralized exception handling
- Implement validation using annotations
- Enable Swagger & Actuator

---
## 🏗 Architecture
```
Client (Postman / Swagger UI)
↓
REST Controller (@RestController)
↓
Service Layer (@Service)
↓
Repository Layer (@Repository - JPA)
↓
H2 Database

```

---

## 🔄 UC16 vs UC17

| Aspect | UC16 | UC17 |
|------|------|------|
| HTTP | ❌ None | ✅ REST API |
| Data Access | JDBC | Spring Data JPA |
| DI | Manual | @Autowired |
| JSON | Manual | Auto |
| Exception | Try-catch | @ControllerAdvice |
| Validation | Manual | @Valid |
| Docs | None | Swagger |
| Monitoring | None | Actuator |

---

## 🔹 REST Endpoints

| Method | URL | Description |
|--------|-----|------------|
| POST | `/api/v1/quantities/compare` | Compare quantities |
| POST | `/api/v1/quantities/add` | Add quantities |
| POST | `/api/v1/quantities/subtract` | Subtract |
| POST | `/api/v1/quantities/divide` | Divide |
| POST | `/api/v1/quantities/convert` | Convert |
| GET | `/api/v1/quantities/history/operation/{operation}` | History by operation |
| GET | `/api/v1/quantities/history/type/{type}` | History by type |

---

## 🧱 Layers Overview

### Controller Layer
- `@RestController`
- Handles HTTP requests
- Returns JSON responses

### Service Layer
- Business logic
- Uses `@Service`

### Repository Layer
- `JpaRepository`
- No SQL required

### Entity Layer
- `@Entity`
- Maps Java class to DB table

---

## ⚙️ application.properties

```properties
spring.datasource.url=jdbc:h2:mem:quantitymeasurementdb
spring.jpa.hibernate.ddl-auto=create-drop
spring.h2.console.enabled=true
springdoc.swagger-ui.path=/swagger-ui.html
management.endpoints.web.exposure.include=health,info
server.port=8080
