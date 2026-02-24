# ✅ UC5 – Equality Comparison for Same Unit (Weight)

---

## 📌 Problem Statement

Enhance the **Quantity Measurement Application** to:

- Compare two weight values of the **same unit**
- Validate equality correctly
- Ensure null safety
- Ensure type safety
- Override `equals()` method properly

In this UC, we compare **same-unit values only**.  
⚠️ Cross-unit comparison (like Gram to Kilogram) will be handled in later UCs.

---

## 🎯 Objective of UC5

### 🔹 Supported Weight Unit:
- Gram (`g`)

### 🔹 Implement:

- ✅ Equality comparison
- ✅ Proper `equals()` override
- ✅ Null check
- ✅ Type check
- ✅ Value comparison

The system should confirm equality only when:

- Units are same  
- Values are same  
- Object types are same  

---

## 🧠 Core Concept Used

In Java, to compare objects properly, we must override:

```java
public boolean equals(Object obj)
```

### 🔎 Why Override `equals()`?

- Default `equals()` behaves like `==`
- `==` compares memory references
- We need **value-based comparison**

---

## 🧩 Equality Validation Rules in UC5

While implementing `equals()`, the following validations must be ensured:

✔ **Reference Check**  
If both objects refer to the same memory location → return `true`

✔ **Null Check**  
If compared object is `null` → return `false`

✔ **Type Check**  
If objects are not of the same class → return `false`

✔ **Unit Check**  
If units are different → return `false`

✔ **Value Check**  
If values are different → return `false`

✔ Only when all validations pass → return `true`

---

## 📊 Expected Equality Behavior

| Scenario | Result |
|----------|--------|
| Same reference | ✅ true |
| Same value & same unit | ✅ true |
| Different value (same unit) | ❌ false |
| Null comparison | ❌ false |
| Different object type | ❌ false |
| Different unit | ❌ false |

---

## 🚀 Learning Outcome

After completing UC5, you understand:

- Proper object comparison using `equals()`
- Importance of null safety
- Importance of type safety
- Difference between reference equality and value equality
- How equality logic must be structured carefully

---

## 📌 Summary

UC5 strengthens the equality logic by:

- Ensuring comparison works correctly for same-unit weights
- Following safe and proper `equals()` contract
- Preparing the system for future enhancements like cross-unit conversion

This use case ensures **robust and reliable equality validation** for weight quantities.

---
