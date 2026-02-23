# UC9 – Quantity Measurement with Unit Addition (Length)

---

## 📌 Problem Statement

Enhance the Quantity Measurement Application to:

- Support **Length unit comparison**
- Support **Addition of different length units**
- Convert different units into a common base unit before performing operations
- Maintain precision in floating-point calculations

---

## 🎯 Objective of UC9

1. Support length units:
   - Inch
   - Foot
   - Yard
   - Centimeter

2. Allow:
   - Equality comparison between different length units
   - Addition of two length values
   - Conversion to base unit before calculation

---

# 🧠 Core Concept Used

For length measurement:

✔ Convert all units into a **base unit (Inch)**  
✔ Perform comparison or addition  
✔ Return result in base unit  

This ensures:
- Clean architecture
- Easy scalability
- Consistent logic

---

# 🔁 Conversion Table Used (Base Unit = Inch)

| Unit | Conversion to Inch |
|------|-------------------|
| 1 Foot | 12 inches |
| 1 Yard | 36 inches |
| 1 Centimeter | 0.393701 inches |
| 1 Inch | 1 inch |

---
