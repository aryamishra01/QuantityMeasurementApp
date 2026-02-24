# ✅ UC2 – Equality Comparison for Same Reference (Weight)

---

## 📌 Problem Statement

Enhance the **Quantity Measurement Application** to:

- Compare two **Weight objects**
- Return **true** if both references point to the same object
- Return **false** otherwise

⚠️ In **UC2**, we only check **reference equality**, not value equality.

That means we are checking whether both variables refer to the **same memory location**, not whether their values are equal.

---

## 🎯 Objective of UC2

The main goals of this use case are:

- ✅ Use the existing `Quantity` class  
- ✅ Store weight value  
- ✅ Compare objects using reference check  
- ✅ Understand the difference between:
  - `==` → Reference comparison  
  - `.equals()` → Value comparison (implemented later)

⚠️ Value comparison will be implemented in **UC3**.

---

## 🧠 Core Concept Used

In Java:

```java
obj1 == obj2
```

- `==` checks if two variables refer to the **same object in memory**.
- It does **NOT** compare object values.
- If both references point to the same object → returns `true`.
- If they point to different objects → returns `false`.

---

## 📊 Memory Understanding

```
Case 1:
weight1  ──┐
            ├──► [Quantity Object]
weight2  ──┘

Case 2:
weight1  ──► [Quantity Object]
weight2  ──► [Another Quantity Object]
```

---

## ⚠ Important Concept

| Operator | Checks | Used In |
|----------|--------|----------|
| `==` | Memory reference | UC2 |
| `.equals()` | Object value | UC3 |

---

## 🚀 Learning Outcome

After completing UC2, you understand:

- What reference equality means
- How `==` works with objects
- Difference between reference comparison and value comparison
- Why two objects with same value can still be unequal

---

## 📌 Summary

UC2 ensures:

- The system can compare two object references.
- It correctly identifies whether both variables point to the same object.
- The foundation is set for implementing value-based equality in UC3.

---

