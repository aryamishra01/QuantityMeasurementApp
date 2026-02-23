# UC2 – Equality Comparison for Same Reference (Weight)

---

## 📌 Problem Statement

Enhance the Quantity Measurement Application to:

- Compare two weight objects
- Return **true** if both references point to the same object
- Return **false** otherwise

In this UC, we only check **reference equality**, not value equality.

---

## 🎯 Objective of UC2

1. Create a `Quantity` class
2. Store weight value
3. Compare objects using reference check
4. Understand difference between:
   - `==` (reference comparison)
   - `.equals()` (value comparison – implemented later)

> ⚠ Value comparison will be implemented in UC3.

---

# 🧠 Core Concept Used

In Java:

```java
obj1 == obj2
