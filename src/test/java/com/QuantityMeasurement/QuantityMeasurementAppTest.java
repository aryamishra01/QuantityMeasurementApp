/*
 * Test class for UC6 - Addition of Two Length Units (Same Category)
 * Covers addition of same and cross-unit lengths, zero, negative,
 * large/small values, and commutativity.
 */

package com.QuantityMeasurement;

import static org.junit.Assert.*;
import org.junit.Test;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;

    /*
     * Same-unit addition (Feet + Feet)
     */
    @Test
    public void testAddition_SameUnit_FeetPlusFeet() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);
        QuantityLength sum = q1.add(q2);
        assertEquals(new QuantityLength(3.0, LengthUnit.FEET), sum);
    }

    /*
     * Same-unit addition (Inches + Inches)
     */
    @Test
    public void testAddition_SameUnit_InchPlusInch() {
        QuantityLength q1 = new QuantityLength(6.0, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(6.0, LengthUnit.INCHES);
        QuantityLength sum = q1.add(q2);
        assertEquals(new QuantityLength(12.0, LengthUnit.INCHES), sum);
    }

    /*
     * Cross-unit addition (Feet + Inches)
     */
    @Test
    public void testAddition_CrossUnit_FeetPlusInches() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength sum = q1.add(q2);
        assertEquals(new QuantityLength(2.0, LengthUnit.FEET), sum);
    }

    /*
     * Cross-unit addition (Inches + Feet)
     */
    @Test
    public void testAddition_CrossUnit_InchPlusFeet() {
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength sum = q1.add(q2);
        assertEquals(new QuantityLength(24.0, LengthUnit.INCHES), sum);
    }

    /*
     * Cross-unit addition (Yard + Feet)
     */
    @Test
    public void testAddition_CrossUnit_YardPlusFeet() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength sum = q1.add(q2);
        assertEquals(new QuantityLength(2.0, LengthUnit.YARDS), sum);
    }

    /*
     * Cross-unit addition (Centimeters + Inches)
     */
    @Test
    public void testAddition_CrossUnit_CentimeterPlusInch() {
        QuantityLength q1 = new QuantityLength(2.54, LengthUnit.CENTIMETERS);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCHES);
        QuantityLength sum = q1.add(q2);
        assertEquals(new QuantityLength(5.08, LengthUnit.CENTIMETERS), sum);
    }

    /*
     * Addition is commutative
     */
    @Test
    public void testAddition_Commutativity() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength sum1 = a.add(b);
        QuantityLength sum2 = b.add(a).convertTo(LengthUnit.FEET);

        assertEquals(sum1.getValue(), sum2.getValue(), EPSILON);
    }

    /*
     * Addition with zero
     */
    @Test
    public void testAddition_WithZero() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(0.0, LengthUnit.INCHES);
        QuantityLength sum = q1.add(q2);
        assertEquals(new QuantityLength(5.0, LengthUnit.FEET), sum);
    }

    /*
     * Addition with negative value
     */
    @Test
    public void testAddition_NegativeValues() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(-2.0, LengthUnit.FEET);
        QuantityLength sum = q1.add(q2);
        assertEquals(new QuantityLength(3.0, LengthUnit.FEET), sum);
    }

    /*
     * Null operand should throw exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddition_NullSecondOperand() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        q1.add(null);
    }

    /*
     * Addition with large values
     */
    @Test
    public void testAddition_LargeValues() {
        QuantityLength q1 = new QuantityLength(1e6, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1e6, LengthUnit.FEET);
        QuantityLength sum = q1.add(q2);
        assertEquals(new QuantityLength(2e6, LengthUnit.FEET), sum);
    }

    /*
     * Addition with small values
     */
    @Test
    public void testAddition_SmallValues() {
        QuantityLength q1 = new QuantityLength(0.001, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(0.002, LengthUnit.FEET);
        QuantityLength sum = q1.add(q2);
        assertEquals(new QuantityLength(0.003, LengthUnit.FEET), sum);
    }
}