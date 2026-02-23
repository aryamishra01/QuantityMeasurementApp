# UC4 – Equality Comparison with Unit Type Validation (Weight)

---

## 📌 Problem Statement

Enhance the Quantity Measurement Application to:

- Compare two weight quantities
- Ensure equality only when:
  - Values are equal
  - Units are same
- Validate object type properly
- Override `equals()` method safely

In this UC, we introduce the concept of **unit type validation**.

---

## 🎯 Objective of UC4

1. Introduce weight unit:
   - Gram (g)

2. Ensure:
   - Same reference returns true
   - Null comparison returns false
   - Different object types return false
   - Different units return false
   - Same value and same unit return true

---

# 🧠 Core Concept Used

While overriding `equals()` in Java, we must:

✔ Check reference equality  
✔ Check null  
✔ Check class type  
✔ Compare unit type  
✔ Compare values  

This ensures correct object comparison.

---
