/*
 * Test class for UC4 - Extended Unit Support.
 * Covers equality contract, cross-unit comparison,
 * symmetry, transitive property, null safety,
 * and invalid input handling for Feet, Inches,
 * Yards and Centimeters.
 */

package com.QuantityMeasurement;

import static org.junit.Assert.*;
import org.junit.Test;

public class QuantityMeasurementAppTest {

    /*
     * Tests same-unit equality for Yards.
     */
    @Test
    public void testEquality_YardToYard_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.YARDS);
        assertTrue(q1.equals(q2));
    }

    /*
     * Tests same-unit equality for Centimeters.
     */
    @Test
    public void testEquality_CmToCm_SameValue() {
        QuantityLength q1 = new QuantityLength(2.0, LengthUnit.CENTIMETERS);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.CENTIMETERS);
        assertTrue(q1.equals(q2));
    }

    /*
     * Tests Yard to Feet conversion.
     * 1 Yard equals 3 Feet.
     */
    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
        assertTrue(q1.equals(q2));
    }

    /*
     * Tests Feet to Yard conversion symmetry.
     */
    @Test
    public void testEquality_FeetToYard_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.YARDS);
        assertTrue(q1.equals(q2));
    }

    /*
     * Tests Yard to Inches conversion.
     * 1 Yard equals 36 Inches.
     */
    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(36.0, LengthUnit.INCHES);
        assertTrue(q1.equals(q2));
    }

    /*
     * Tests Centimeter to Inches conversion.
     * 1 CM equals 0.393701 Inches.
     */
    @Test
    public void testEquality_CmToInches_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        QuantityLength q2 = new QuantityLength(0.393701, LengthUnit.INCHES);
        assertTrue(q1.equals(q2));
    }

    /*
     * Tests non-equivalent Yard and Feet values.
     */
    @Test
    public void testEquality_YardToFeet_NonEquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);
        assertFalse(q1.equals(q2));
    }

    /*
     * Tests non-equivalent CM and Feet values.
     */
    @Test
    public void testEquality_CmToFeet_NonEquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        assertFalse(q1.equals(q2));
    }

    /*
     * Tests transitive property across units.
     * 1 Yard = 3 Feet = 36 Inches.
     */
    @Test
    public void testEquality_TransitiveProperty() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength inches = new QuantityLength(36.0, LengthUnit.INCHES);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }

    /*
     * Tests same reference comparison.
     */
    @Test
    public void testEquality_SameReference() {
        QuantityLength q1 = new QuantityLength(2.0, LengthUnit.YARDS);
        assertTrue(q1.equals(q1));
    }

    /*
     * Tests null comparison.
     */
    @Test
    public void testEquality_NullComparison() {
        QuantityLength q1 = new QuantityLength(2.0, LengthUnit.YARDS);
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

    /*
     * Tests complex multi-unit scenario.
     * 2 Yards = 6 Feet = 72 Inches.
     */
    @Test
    public void testEquality_AllUnits_ComplexScenario() {
        QuantityLength yard = new QuantityLength(2.0, LengthUnit.YARDS);
        QuantityLength feet = new QuantityLength(6.0, LengthUnit.FEET);
        QuantityLength inches = new QuantityLength(72.0, LengthUnit.INCHES);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }
}