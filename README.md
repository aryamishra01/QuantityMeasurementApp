# ✅ UC14: Temperature Measurement

---

## 📖 Description

UC14 extends the Generic Quantity framework by introducing **Temperature Measurement** support.

Unlike previous measurement categories (Length, Weight, Volume), temperature conversion is **non-linear** and involves both scaling and offset adjustments.

This use case demonstrates that the architecture supports not only multiplicative conversions but also **formula-based conversions**, without modifying the core `Quantity` class.

---

## 🎯 Objective

- Introduce `TemperatureUnit` enum
- Support temperature units:
  - Celsius
  - Fahrenheit
  - Kelvin
- Enable:
  - Equality comparison
  - Conversion between units
  - Addition and subtraction
- Preserve centralized arithmetic logic from UC13
- Maintain cross-category safety
- Ensure backward compatibility (UC1–UC13 remain unchanged)

---

# 🌡 Temperature Units

| Unit | Conversion to Base (Celsius) |
|------|------------------------------|
| Celsius | C |
| Fahrenheit | (F − 32) × 5/9 |
| Kelvin | K − 273.15 |

**Base unit: Celsius**

---

# 🔄 Conversion Formulas

## 🔹 Celsius ↔ Fahrenheit
