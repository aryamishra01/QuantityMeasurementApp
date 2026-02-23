# UC8 – Quantity Measurement with Unit Comparison (Length)

---

## 📌 Problem Statement

Enhance the Quantity Measurement Application to:

- Support **comparison between different length units**
- Convert units internally to a common base unit before comparison
- Ensure proper floating-point precision handling

In this UC, we **only compare units** (no addition yet — that comes in UC9).

---

## 🎯 Objective of UC8

1. Support length units:
   - Inch
   - Foot
   - Yard
   - Centimeter

2. Allow:
   - Equality comparison between different units
   - Cross-unit comparison using base conversion
   - Precision-safe comparison

---

# 🧠 Core Concept Used

For accurate comparison:

✔ Convert all units to a **base unit (Inch)**  
✔ Compare base values  
✔ Use tolerance to avoid floating-point errors  

---

# 🔁 Conversion Table (Base Unit = Inch)

| Unit | Conversion to Inch |
|------|-------------------|
| 1 Foot | 12 inches |
| 1 Yard | 36 inches |
| 1 Centimeter | 0.393701 inches |
| 1 Inch | 1 inch |

---

