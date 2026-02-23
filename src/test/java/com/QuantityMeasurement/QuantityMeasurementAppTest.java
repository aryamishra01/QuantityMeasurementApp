/*
 * Test class for UC2: Feet and Inches Measurement Equality.
 * 
 * Covers:
 * - Same value comparison
 * - Different value comparison
 * - Null comparison
 * - Same reference comparison
 * - Non-numeric input validation
 * 
 * Feet and Inches are treated separately.
 */
package com.QuantityMeasurement;

import static org.junit.Assert.*;
import org.junit.Test;

public class QuantityMeasurementAppTest {

    /*
     * Tests equality of two Feet values when both are same.
     */
    @Test
    public void testFeetEquality_SameValue() {
        assertTrue(QuantityMeasurementApp.checkFeetEquality(1.0, 1.0));
    }

    /*
     * Tests inequality of two Feet values when values differ.
     */
    @Test
    public void testFeetEquality_DifferentValue() {
        assertFalse(QuantityMeasurementApp.checkFeetEquality(1.0, 2.0));
    }

    /*
     * Tests equality of two Inch values when both are same.
     */
    @Test
    public void testInchEquality_SameValue() {
        assertTrue(QuantityMeasurementApp.checkInchEquality(1.0, 1.0));
    }

    /*
     * Tests inequality of two Inch values when values differ.
     */
    @Test
    public void testInchEquality_DifferentValue() {
        assertFalse(QuantityMeasurementApp.checkInchEquality(1.0, 2.0));
    }

    /*
     * Tests null comparison for Feet object.
     */
    @Test
    public void testFeetEquality_NullComparison() {
        Feet feet = new Feet(1.0);
        assertFalse(feet.equals(null));
    }

    /*
     * Tests null comparison for Inches object.
     */
    @Test
    public void testInchEquality_NullComparison() {
        Inches inch = new Inches(1.0);
        assertFalse(inch.equals(null));
    }

    /*
     * Tests same reference comparison for Feet.
     */
    @Test
    public void testFeetEquality_SameReference() {
        Feet feet = new Feet(2.0);
        assertTrue(feet.equals(feet));
    }

    /*
     * Tests same reference comparison for Inches.
     */
    @Test
    public void testInchEquality_SameReference() {
        Inches inch = new Inches(2.0);
        assertTrue(inch.equals(inch));
    }

    /*
     * Tests non-numeric input for Feet.
     * Expecting IllegalArgumentException.
     */
    
    @Test(expected = IllegalArgumentException.class)
    public void testFeetEquality_NonNumericInput() {
        QuantityMeasurementApp.checkFeetEquality(Double.NaN, 1.0);
    }

    /*
     * Tests non-numeric input for Inches.
     * Expecting IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInchEquality_NonNumericInput() {
        QuantityMeasurementApp.checkInchEquality(Double.NaN, 1.0);
    }
}