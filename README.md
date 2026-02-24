# ✅ UC4 – Equality Comparison with Unit Type Validation (Weight)

---

## 📌 Problem Statement

Enhance the **Quantity Measurement Application** to:

- Compare two **weight quantities**
- Ensure equality only when:
  - Values are equal
  - Units are same
- Validate object type properly
- Override `equals()` method safely

In this UC, we introduce the concept of **unit type validation**.

This means two weights are equal **only if both value AND unit match**.

---

## 🎯 Objective of UC4

### 🔹 Introduce Weight Unit:
- Gram (`g`)

### 🔹 Ensure the following conditions:

- ✅ Same reference returns `true`
- ✅ Null comparison returns `false`
- ✅ Different object types return `false`
- ✅ Different units return `false`
- ✅ Same value and same unit return `true`

---

## 🧠 Core Concept Used

While overriding `equals()` in Java, we must:

✔ Check reference equality  
✔ Check null  
✔ Check class type  
✔ Compare unit type  
✔ Compare values  

This ensures **correct and safe object comparison**.

---

## 📊 Equality Rules in UC4

| Scenario | Result |
|----------|--------|
| Same reference | ✅ true |
| Same value & same unit | ✅ true |
| Same value & different unit | ❌ false |
| Different value | ❌ false |
| Null | ❌ false |
| Different type | ❌ false |

---

## 🚀 Learning Outcome

After completing UC4, you understand:

- How to introduce **unit types**
- How to compare both value and unit
- How to write safe `equals()` implementation
- Importance of type validation in object comparison
- How enums help in representing fixed unit types

---

## 📌 Summary

UC4 enhances the system by:

- Introducing **unit validation**
- Ensuring equality depends on both value and unit
- Following proper Java equality contract

Now the system correctly validates weight equality with unit awareness.

---
