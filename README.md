# UC5 – Equality Comparison for Same Unit (Weight)

---

## 📌 Problem Statement

Enhance the Quantity Measurement Application to:

- Compare two weight values **of the same unit**
- Validate equality correctly
- Ensure null safety
- Ensure type safety
- Override `equals()` method properly

In this UC, we compare **same-unit values only**.  
Cross-unit comparison will be handled in later UCs.

---

## 🎯 Objective of UC5

1. Support weight unit:
   - Gram (g)

2. Implement:
   - Equality comparison
   - Proper `equals()` override
   - Null check
   - Type check
   - Value comparison

---

# 🧠 Core Concept Used

In Java, to compare objects properly, we must override:

```java
public boolean equals(Object obj)
