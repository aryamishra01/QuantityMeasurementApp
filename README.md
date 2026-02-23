# UC6 – Quantity Measurement with Unit Comparison (Weight)

---

## 📌 Problem Statement

Enhance the Quantity Measurement Application to:

- Support **Weight unit comparison**
- Compare values across different weight units
- Convert units internally into a common base unit
- Handle floating-point precision safely

In this UC, we implement **comparison only** (no addition yet — that comes in UC10).

---

## 🎯 Objective of UC6

1. Support weight units:
   - Gram (g)
   - Kilogram (kg)
   - Tonne (t)

2. Allow:
   - Equality comparison between different weight units
   - Cross-unit comparison using base conversion
   - Precision-safe comparison

---

# 🧠 Core Concept Used

For accurate comparison:

✔ Convert all units into a **base unit (Gram)**  
✔ Compare base values  
✔ Use tolerance to avoid floating-point errors  

---

# 🔁 Conversion Table (Base Unit = Gram)

| Unit | Conversion to Gram |
|------|-------------------|
| 1 Kilogram | 1000 grams |
| 1 Tonne | 1,000,000 grams |
| 1 Gram | 1 gram |

---


