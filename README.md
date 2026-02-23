## ✅ UC12: Final Generic Quantity Model

### 📖 Description
The Quantity Measurement Application is fully refactored into a generic and scalable architecture.

UC12 introduces the final design using:

- `Unit` interface  
- `LengthUnit` enum  
- `WeightUnit` enum  
- `VolumeUnit` enum  
- `Quantity<U extends Unit>` generic class  

This unified model supports:

- ✅ Equality comparison  
- ➕ Addition  
- ➖ Subtraction  
- ➗ Division  
- 🔄 Cross-unit conversion  
- 🛡️ Cross-category validation  

All operations are performed after converting values to their respective base units, ensuring consistency and correctness across measurement categories.

This use case represents the complete and production-ready implementation of the Quantity Measurement system.

---

### 🔎 Preconditions

- All measurement units implement the `Unit` interface.
- Each unit defines:
  - Conversion factor to base unit
  - Measurement category type (Length, Weight, Volume)
- The `Quantity` class is generic and type-safe.
- Valid numeric value and non-null unit must be provided.
- Arithmetic operations are allowed only within the same category.

---

### 🔄 Main Flow

1. User creates a `Quantity` object with:
   - A numeric value
   - A specific unit (LengthUnit / WeightUnit / VolumeUnit)

2. When performing operations:
   - The value is converted to its base unit.
   - Category validation is performed.
   - Arithmetic or comparison is executed.
   - A new immutable `Quantity` object is returned.

3. If invalid operation is attempted:
   - Category mismatch → `IllegalArgumentException`
   - Division by zero → `ArithmeticException`

---

### 📤 Postconditions

- Returns correct result after conversion and calculation.
- Original objects remain unchanged (immutability preserved).
- Cross-category operations are prevented.
- Precision is maintained using `Double.compare()`.

---

### 🧠 Concepts Learned (UC12)

- ✅ Generic Programming using `<U extends Unit>`
- ✅ Interface-Based Design
- ✅ SOLID Principles
- ✅ Open/Closed Principle (easy to add new measurement types)
- ✅ Immutability (private final fields)
- ✅ Cross-Unit Conversion Strategy
- ✅ Defensive Programming
- ✅ Exception Handling
- ✅ Clean and Scalable Architecture
- ✅ High Test Coverage Design

---

### 🧪 Key Concepts Tested

#### 🔁 Equality Contract
- Reflexive
- Symmetric
- Transitive
- Consistent
- Null handling

#### 🔄 Cross-Unit Conversion
- 1 ft equals 12 inch  
- 1 kg equals 1000 g  
- 1 liter equals 1000 ml  

#### ➕ Arithmetic Operations
- Same unit addition  
- Cross-unit addition  
- Subtraction with positive & negative results  
- Division with decimal output  

#### 🛡️ Validation & Safety
- Length + Weight → ❌ Exception  
- Division by zero → ❌ Exception  
- Null unit → ❌ Exception  

---

### 🎯 Supported Features in UC12

| Feature | Supported |
|----------|------------|
| Length Equality | ✅ |
| Weight Equality | ✅ |
| Volume Equality | ✅ |
| Cross Unit Conversion | ✅ |
| Addition | ✅ |
| Subtraction | ✅ |
| Division | ✅ |
| Cross Category Protection | ✅ |
| Immutability | ✅ |
| Generic Design | ✅ |

---

### 🧪 Sample Test Cases

- testLengthEquality_CrossUnit()  
- testWeightEquality_CrossUnit()  
- testVolumeEquality_CrossUnit()  
- testAdd_SameUnit()  
- testAdd_CrossUnit()  
- testSubtract_ResultNegative()  
- testDivide_NormalCase()  
- testDivide_ByZero_ShouldThrow()  
- testDifferentCategory_ShouldThrow()  
- testImmutability()  

---

### 🏁 Final Outcome

UC12 delivers a fully generic, extensible, and production-ready Quantity Measurement system that supports multiple measurement categories with strict type safety, clean architecture, and comprehensive test coverage.


