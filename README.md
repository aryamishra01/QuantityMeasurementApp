## ✅ UC6: Weight Measurement Equality

📖 **Description**  
Enhances the Quantity Measurement App to support **weight unit comparison**.  
Allows equality comparison across different weight units (Gram, Kilogram, Tonne) by internally converting values to a **base unit (Gram)** and handling floating-point precision safely.  
This use case focuses only on **comparison**; arithmetic operations (addition, subtraction) will be implemented in later UCs.

---

🔎 **Preconditions**  

- `WeightUnit` enum is defined with valid units (Gram, Kilogram, Tonne).  
- `Quantity<WeightUnit>` objects can be created with a numeric value and a unit.  
- The system supports base unit normalization.  

---

🔄 **Main Flow**  

1. User creates two `Quantity<WeightUnit>` objects with value and unit.  
2. Both quantities are **converted to the base unit (Gram)** internally.  
3. Floating-point values are compared using `Double.compare()` or a tolerance-based approach to handle precision safely.  
4. Result is returned:  
   - `true` if values are equal  
   - `false` if values differ  

---

📤 **Postconditions**  

- Returns `true` if the two weights are equivalent across units.  
- Returns `false` if weights are not equal.  

---

🧠 **Concepts Learned (UC6)**  

✅ Generic Programming (`Quantity<U extends IMeasurable>`)  
✅ Enum-based conversion (`WeightUnit`)  
✅ Base unit normalization for cross-unit comparison  
✅ Floating-point precision handling  
✅ Multi-category scalability (preparing for arithmetic in future UCs)  

---

🧪 **Sample Test Cases**  

- `testWeightEquality_SameUnit()` → 1000 g == 1000 g → `true`  
- `testWeightEquality_DifferentUnit()` → 1 kg == 1000 g → `true`  
- `testWeightEquality_TonneComparison()` → 0.001 t == 1 kg → `true`  
- `testWeightEquality_DifferentValues()` → 500 g != 1 kg → `false`  

---

