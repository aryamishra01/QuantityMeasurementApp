# UC7 – Quantity Measurement with Unit Comparison (Volume)

---

## 📌 Problem Statement

Enhance the Quantity Measurement Application to:

- Support **Volume unit comparison**
- Convert volume units internally to a common base unit
- Ensure proper floating-point precision handling

In this UC, we implement **comparison only** (no addition yet).

---

## 🎯 Objective of UC7

1. Support volume units:
   - Litre
   - Millilitre

2. Allow:
   - Equality comparison between different volume units
   - Cross-unit comparison using base conversion
   - Precision-safe comparison

---

# 🧠 Core Concept Used

For accurate comparison:

✔ Convert all units to a **base unit (Millilitre)**  
✔ Compare base values  
✔ Use tolerance to handle floating-point precision  

---

# 🔁 Conversion Table (Base Unit = Millilitre)

| Unit | Conversion to Millilitre |
|------|--------------------------|
| 1 Litre | 1000 millilitres |
| 1 Millilitre | 1 millilitre |

---
