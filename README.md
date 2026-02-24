# ✅ UC3 – Equality Comparison with Value Validation (Weight)

---

## 📌 Problem Statement

Enhance the **Quantity Measurement Application** to:

- Compare two **Weight objects**
- Return **true** if values are equal
- Return **false** if values are different
- Ensure proper object comparison logic

In this UC, we introduce **value-based equality comparison** instead of reference comparison.

---

## 🎯 Objective of UC3

The main goals of this use case are:

- ✅ Use the existing `Quantity` class  
- ✅ Store weight value  
- ✅ Override `equals()` method  
- ✅ Compare objects based only on value  
- ✅ Properly handle:
  - Same reference case  
  - Null comparison  
  - Different object type case  

⚠️ Unit concept will be introduced in later UCs.

---

## 🧠 Core Concept Used

In Java:

- `==` checks **reference equality** (memory location).
- To compare object values, we must override:

```java
public boolean equals(Object obj)
```

By default, `equals()` behaves like `==`.  
So we override it to implement **custom value comparison logic**.

---

## 📊 Behavior Comparison

| Scenario | `==` | `equals()` |
|----------|------|------------|
| Same reference | ✅ true | ✅ true |
| Same value (different objects) | ❌ false | ✅ true |
| Different value | ❌ false | ❌ false |
| Null | ❌ false | ❌ false |
| Different type | ❌ false | ❌ false |

---

## 🚀 Learning Outcome

After completing UC3, you understand:

- Difference between reference and value equality
- How to override `equals()` properly
- Importance of null and type checking
- Object-Oriented comparison principles

---

## 📌 Summary

UC3 enhances the system by:

- Implementing proper **value-based equality**
- Making object comparison meaningful
- Following correct Java `equals()` contract

Now the application can correctly compare two weight objects based on their values.

---

