/*
 * Test class for UC3 - Generic QuantityLength.
 * Covers equality contract, cross-unit comparison,
 * type safety, null safety, and invalid input.
 */

package com.QuantityMeasurement;

import static org.junit.Assert.*;
import org.junit.Test;


public class QuantityMeasurementAppTest {

    /*
     * Tests same-unit equality for Feet.
     */
    @Test
    public void testEquality_FeetToFeet_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(q1.equals(q2));
    }

    /*
     * Tests same-unit equality for Inches.
     */
    @Test
    public void testEquality_InchToInch_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCH);
        assertTrue(q1.equals(q2));
    }

    /*
     * Tests cross-unit equality (Feet to Inch).
     * 1 Foot equals 12 Inches.
     */
    @Test
    public void testEquality_FeetToInch_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        assertTrue(q1.equals(q2));
    }

    /*
     * Tests symmetry of cross-unit comparison.
     */
    @Test
    public void testEquality_InchToFeet_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(q1.equals(q2));
    }

    /*
     * Tests different Feet values.
     */
    @Test
    public void testEquality_FeetToFeet_DifferentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);
        assertFalse(q1.equals(q2));
    }

    /*
     * Tests different Inch values.
     */
    @Test
    public void testEquality_InchToInch_DifferentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.INCH);
        assertFalse(q1.equals(q2));
    }

    /*
     * Tests same reference comparison.
     */
    @Test
    public void testEquality_SameReference() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(q1.equals(q1));
    }

    /*
     * Tests null comparison.
     */
    @Test
    public void testEquality_NullComparison() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        assertFalse(q1.equals(null));
    }

    /*
     * Tests invalid numeric input.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testEquality_InvalidNumericInput() {
        new QuantityLength(Double.NaN, LengthUnit.FEET);
    }

    /*
     * Tests null unit handling.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testEquality_NullUnit() {
        new QuantityLength(1.0, null);
    }
}