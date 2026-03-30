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
