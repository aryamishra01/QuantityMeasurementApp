# ✅ UC1 – Ability to Create a Weight Object

---

## 📌 Problem Statement

Create a **Quantity Measurement Application** that:

- Allows creation of a **Weight object**
- Stores the **weight value**
- Ensures the object is successfully created

⚠️ In **UC1**, we only focus on **object creation**, not comparison or unit conversion.

This is the very first step of the Quantity Measurement system.

---

## 🎯 Objective of UC1

The main goals of this use case are:

- ✅ Create a `Quantity` class  
- ✅ Store a weight value inside the object  
- ✅ Verify that the object is created successfully  
- ✅ Ensure no null object is returned  

This use case acts as the **foundation** for all future features like equality, unit conversion, addition, and subtraction.

---

## 🧠 Core Concepts Used

UC1 focuses on fundamental Java concepts:

- **Constructor**
- **Object creation using `new` keyword**
- **Instance variable**
- **JUnit testing**
- **Assertion using `assertNotNull()`**

---

## 🏗️ Implementation

### 📁 Step 1: Create Quantity Class

```java
package com.QuantityMeasurement;

public class Quantity {

    double value;

    // Constructor to initialize weight value
    public Quantity(double value) {
        this.value = value;
    }
}
```

### 🔍 Explanation

- `double value;` → Stores the weight.
- `public Quantity(double value)` → Constructor that initializes the object.
- When we write `new Quantity(10.0)`, a new object is created in memory.

---

## 🧪 Step 2: Write JUnit Test Case

```java
package com.QuantityMeasurement;

import static org.junit.Assert.*;
import org.junit.Test;

public class QuantityMeasurementAppTest {

    /*
     * Test to verify that a Weight object is created successfully.
     */
    @Test
    public void givenWeightValue_WhenObjectCreated_ShouldNotBeNull() {

        Quantity weight = new Quantity(10.0);

        assertNotNull(weight);
    }
}
```

---

## 🧪 Test Case Breakdown

| Step | Description |
|------|------------|
| 1 | Create a new `Quantity` object |
| 2 | Pass weight value (10.0) |
| 3 | Verify object is not null |
| 4 | Test passes if object exists |

---

## 📊 Expected Result

✅ Test should pass  
✅ Object should be successfully created  
✅ No errors  
✅ Weight value should be stored in memory  

---

## 🧱 Why UC1 is Important?

- It builds the **base structure** of the application.
- Every future use case (UC2, UC3, etc.) depends on this.
- Without object creation, no comparison or operations can be performed.

---

## 🚀 Learning Outcome

After completing UC1, you understand:

- How constructors work
- How objects are created in Java
- How to write a basic JUnit test
- How to verify object creation

---

## 📌 Summary

UC1 is the **starting point** of the Quantity Measurement system.

It ensures:
- The system can create a Weight object.
- The object correctly stores a value.
- The application is ready for the next use case (Equality).

---
