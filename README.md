# UC3 – Equality Comparison with Value Validation (Weight)

---

## 📌 Problem Statement

Enhance the Quantity Measurement Application to:

- Compare two weight objects
- Return **true** if values are equal
- Return **false** if values are different
- Ensure proper object comparison logic

In this UC, we introduce **value-based equality comparison**.

---

## 🎯 Objective of UC3

1. Create a `Quantity` class
2. Store weight value
3. Override `equals()` method
4. Compare only based on value
5. Handle:
   - Same reference case
   - Null case
   - Different object type case

> ⚠ Unit concept will be introduced in later UCs.

---

# 🧠 Core Concept Used

In Java, object comparison using `==` checks reference.  
To compare values, we must override:

```java
public boolean equals(Object obj)
