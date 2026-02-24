# ✅ UC13: Centralized Arithmetic Logic

---

## 📖 Description

UC13 focuses on **architectural improvement** by centralizing arithmetic logic inside the `Quantity` class.

Until UC12, arithmetic operations such as:

- Addition
- Subtraction
- Explicit target unit arithmetic

contained repeated base conversion logic.

UC13 refactors the system to eliminate duplication by introducing a **single centralized method** responsible for handling arithmetic operations.

⚠ No new functionality is added in this use case.  
All previous use cases (UC1–UC12) continue to work unchanged.

---

# 🎯 Objective

- Remove duplicated arithmetic logic
- Centralize conversion and computation in a single method
- Improve maintainability and readability
- Preserve backward compatibility
- Follow **DRY (Don’t Repeat Yourself)** principle

---

# 🏗 Architectural Improvement

---

## 🔹 Before UC13

Arithmetic methods like:

- `add()`
- `subtract()`
- `add(targetUnit)`
- `subtract(targetUnit)`

Each performed:

- Conversion to base unit
- Operation in base unit
- Conversion back to target unit
- Rounding logic

This resulted in **repeated logic** across multiple methods.

---

## 🔹 After UC13

A single private method now handles all arithmetic:

```java
private Quantity<U> performOperation(
    Quantity<U> other,
    U targetUnit,
    BinaryOperator<Double> operator
)
