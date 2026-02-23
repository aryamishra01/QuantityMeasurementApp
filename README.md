# UC11 – Temperature Measurement with Comparison & Addition

---

## 📌 Problem Statement

Enhance the **Quantity Measurement Application** to support:

- 🌡 Temperature unit comparison  
- ➕ Temperature addition  
- 🔁 Automatic unit conversion  
- ⚠ Proper validation and precision handling  

Unlike length or weight, **temperature cannot be converted using simple multiplication factors**.  
It requires proper mathematical formulas.

---

## 🎯 Goals of UC11

1. Support temperature units:
   - Celsius (°C)
   - Fahrenheit (°F)
   - Kelvin (K)

2. Allow:
   - Equality comparison between different temperature units
   - Addition of two temperatures
   - Proper base conversion
   - Precision-safe comparison

---

# 🧠 Important Concept

For temperature:

✔ We convert everything to a **base unit (Celsius)**  
✔ Perform comparison or addition  
✔ Return result in base unit (Celsius)  

This ensures clean and consistent logic.

---

# 🔁 Conversion Formulas Used

## Celsius ↔ Fahrenheit

F = (C × 9/5) + 32  
C = (F − 32) × 5/9  

---

## Celsius ↔ Kelvin

K = C + 273.15  
C = K − 273.15  

---

