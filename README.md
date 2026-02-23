# UC10 – Quantity Measurement with Unit Addition (Weight)

---

## 📌 Problem Statement

Enhance the Quantity Measurement Application to:

- Support **Weight unit comparison**
- Support **Addition of different weight units**
- Convert different units into a common base unit before performing operations
- Maintain precision in floating-point calculations

---

## 🎯 Objective of UC10

1. Support weight units:
   - Gram (g)
   - Kilogram (kg)
   - Tonne (t)

2. Allow:
   - Equality comparison between different weight units
   - Addition of two weight values
   - Conversion to base unit before calculation

---

# 🧠 Core Concept Used

For weight measurement:

✔ Convert all units into a **base unit (Gram)**  
✔ Perform comparison or addition  
✔ Return result in base unit  

This ensures:
- Clean architecture
- Easy scalability
- Consistent logic

---

# 🔁 Conversion Table Used

| Unit | Base Conversion |
|------|-----------------|
| 1 Kilogram | 1000 grams |
| 1 Tonne | 1,000,000 grams |
| 1 Gram | 1 gram |

---

