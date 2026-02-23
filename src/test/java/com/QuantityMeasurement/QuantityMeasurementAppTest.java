package com.QuantityMeasurement;
/**
 * JUnit 5 Test class for QuantityLength (UC7: Addition with Target Unit Specification)
 * Tests addition of lengths with explicit target units, commutativity, zero/negative values, 
 * and invalid inputs.
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // Tolerance for floating point comparison (for approximate equality)
    private static final double EPSILON = 0.001;

    /**
     * Test addition with explicit target unit = FEET
     * 1 FEET + 12 INCHES = 2 FEET
     */
    @Test
    void testAddition_ExplicitTargetUnit_Feet() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = q1.add(q2, LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    /**
     * Test addition with explicit target unit = INCHES
     * 1 FEET + 12 INCHES = 24 INCHES
     */
    @Test
    void testAddition_ExplicitTargetUnit_Inches() {
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
    void testAddition_ExplicitTargetUnit_Yards() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = q1.add(q2, LengthUnit.YARDS);

        assertEquals(0.667, result.getValue(), EPSILON);
        assertEquals(LengthUnit.YARDS, result.getUnit());
    }

    /**
     * Test addition with explicit target unit = CENTIMETERS
     * 1 INCH + 1 INCH ≈ 5.08 CM
     */
    @Test
    void testAddition_ExplicitTargetUnit_Centimeters() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCHES);

        QuantityLength result = q1.add(q2, LengthUnit.CENTIMETERS);

        assertEquals(5.08, result.getValue(), EPSILON);
        assertEquals(LengthUnit.CENTIMETERS, result.getUnit());
    }

    /**
     * Test commutativity of addition with explicit target unit
     * add(A,B,target) should equal add(B,A,target)
     */
    @Test
    void testAddition_ExplicitTargetUnit_Commutativity() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result1 = q1.add(q2, LengthUnit.YARDS);
        QuantityLength result2 = q2.add(q1, LengthUnit.YARDS);

        assertEquals(result1.getValue(), result2.getValue(), EPSILON);
        assertEquals(result1.getUnit(), result2.getUnit());
    }

    /**
     * Test addition when one operand is zero
     * 5 FEET + 0 INCHES ≈ 1.667 YARDS
     */
    @Test
    void testAddition_WithZero() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(0.0, LengthUnit.INCHES);

        QuantityLength result = q1.add(q2, LengthUnit.YARDS);

        assertEquals(1.667, result.getValue(), EPSILON);
        assertEquals(LengthUnit.YARDS, result.getUnit());
    }

    /**
     * Test addition with negative values
     * 5 FEET + (-2 FEET) = 3 FEET → 36 INCHES
     */
    @Test
    void testAddition_WithNegativeValues() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(-2.0, LengthUnit.FEET);

        QuantityLength result = q1.add(q2, LengthUnit.INCHES);

        assertEquals(36.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    /**
     * Test addition with null target unit
     * Should throw IllegalArgumentException
     */
    @Test
    void testAddition_NullTargetUnit() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        assertThrows(IllegalArgumentException.class, () -> q1.add(q2, null));
    }

    /**
     * Test addition from large unit to small unit scale
     * 1000 FEET + 500 FEET → 18000 INCHES
     */
    @Test
    void testAddition_LargeToSmallScale() {
        QuantityLength q1 = new QuantityLength(1000.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(500.0, LengthUnit.FEET);

        QuantityLength result = q1.add(q2, LengthUnit.INCHES);

        assertEquals(18000.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    /**
     * Test addition from small unit to large unit scale
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