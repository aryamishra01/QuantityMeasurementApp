package com.QuantityMeasurement;

/**
 * JUnit 5 Test class for QuantityLength
 * 
 * Covers:
 * - Equality checks (same unit & cross unit)
 * - Addition with and without target unit
 * - Explicit target unit conversions
 * - Commutativity
 * - Zero and negative values
 * - Large/small scale conversions
 * - Null and invalid inputs
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // Tolerance for floating point comparison
    private static final double EPSILON = 0.001;

    //EQUALITY TEST CASES

    /**
     * Test equality when both values and units are same
     * 1 FEET == 1 FEET
     */
    @Test
    void testEquality_SameUnitSameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    /**
     * Test equality with different units but same length
     * 12 INCHES == 1 FEET
     */
    @Test
    void testEquality_DifferentUnitSameValue() {
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    /**
     * Test inequality when values are different
     * 1 FEET != 2 FEET
     */
    @Test
    void testEquality_DifferentValues() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);

        assertFalse(q1.equals(q2));
    }

    /**
     * Test equality with null object
     */
    @Test
    void testEquality_NullObject() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);

        assertFalse(q1.equals(null));
    }


    // ADDITION TEST CASES
    /**
     * Test addition without target unit (default behavior)
     * 1 FEET + 12 INCHES = 2 FEET
     */
    @Test
    void testAddition_DefaultTarget() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = q1.add(q2);

        assertEquals(2.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    /**
     * Test addition with explicit target unit = INCHES
     * 1 FEET + 12 INCHES = 24 INCHES
     */
    @Test
    void testAddition_TargetUnitInches() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = q1.add(q2, LengthUnit.INCHES);

        assertEquals(24.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    /**
     * Test addition with explicit target unit = YARDS
     * 1 FEET + 12 INCHES ≈ 0.667 YARDS
     */
    @Test
    void testAddition_TargetUnitYards() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = q1.add(q2, LengthUnit.YARDS);

        assertEquals(0.667, result.getValue(), EPSILON);
        assertEquals(LengthUnit.YARDS, result.getUnit());
    }

    /**
     * Test commutativity of addition
     * add(A,B,target) == add(B,A,target)
     */
    @Test
    void testAddition_Commutativity() {
        QuantityLength q1 = new QuantityLength(2.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(24.0, LengthUnit.INCHES);

        QuantityLength result1 = q1.add(q2, LengthUnit.FEET);
        QuantityLength result2 = q2.add(q1, LengthUnit.FEET);

        assertEquals(result1.getValue(), result2.getValue(), EPSILON);
        assertEquals(result1.getUnit(), result2.getUnit());
    }

    /**
     * Test addition when one operand is zero
     * 5 FEET + 0 INCHES = 5 FEET
     */
    @Test
    void testAddition_WithZero() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(0.0, LengthUnit.INCHES);

        QuantityLength result = q1.add(q2, LengthUnit.FEET);

        assertEquals(5.0, result.getValue(), EPSILON);
    }

    /**
     * Test addition with negative values
     * 5 FEET + (-2 FEET) = 3 FEET
     */
    @Test
    void testAddition_WithNegativeValues() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(-2.0, LengthUnit.FEET);

        QuantityLength result = q1.add(q2, LengthUnit.FEET);

        assertEquals(3.0, result.getValue(), EPSILON);
    }

    /**
     * Test addition with null target unit
     * Should throw IllegalArgumentException
     */
    @Test
    void testAddition_NullTargetUnit() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> 
            q1.add(q2, null)
        );
    }

    /**
     * Test addition with null object
     * Should throw IllegalArgumentException
     */
    @Test
    void testAddition_NullQuantity() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> 
            q1.add(null, LengthUnit.FEET)
        );
    }

    /**
     * Test large scale addition
     * 1000 FEET + 500 FEET = 1500 FEET
     */
    @Test
    void testAddition_LargeScale() {
        QuantityLength q1 = new QuantityLength(1000.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(500.0, LengthUnit.FEET);

        QuantityLength result = q1.add(q2, LengthUnit.FEET);

        assertEquals(1500.0, result.getValue(), EPSILON);
    }

    /**
     * Test small to large unit conversion
     * 12 INCHES + 12 INCHES ≈ 0.667 YARDS
     */
    @Test
    void testAddition_SmallToLargeScale() {
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = q1.add(q2, LengthUnit.YARDS);

        assertEquals(0.667, result.getValue(), EPSILON);
        assertEquals(LengthUnit.YARDS, result.getUnit());
    }
}