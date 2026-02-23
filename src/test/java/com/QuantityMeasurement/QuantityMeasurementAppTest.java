package com.QuantityMeasurement;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/*
 * Test class covering:
 * - Addition
 * - Subtraction
 * - Division
 * - Equality
 * - Cross unit conversion
 * - Invalid cases
 * - Edge cases
 */

public class QuantityMeasurementAppTest {

    /* ===================== EQUALITY TESTS ===================== */

    @Test
    void same_length_should_be_equal() {
        assertEquals(
                new Quantity<>(12, LengthUnit.INCH),
                new Quantity<>(1, LengthUnit.FEET)
        );
    }
    
    @Test
    void yard_and_feet_should_be_equal() {
        assertEquals(
                new Quantity<>(1, LengthUnit.YARD),
                new Quantity<>(3, LengthUnit.FEET)
        );
    }

    @Test
    void different_length_should_not_be_equal() {
        assertNotEquals(
                new Quantity<>(1, LengthUnit.FEET),
                new Quantity<>(2, LengthUnit.FEET)
        );
    }

    @Test
    void same_weight_should_be_equal() {
        assertEquals(
                new Quantity<>(1000, WeightUnit.GRAM),
                new Quantity<>(1, WeightUnit.KILOGRAM)
        );
    }

    @Test
    void same_volume_should_be_equal() {
        assertEquals(
                new Quantity<>(1000, VolumeUnit.MILLILITER),
                new Quantity<>(1, VolumeUnit.LITER)
        );
    }

    /* ===================== ADDITION TESTS ===================== */

    @Test
    void add_same_unit_length() {
        Quantity<LengthUnit> result =
                new Quantity<>(5, LengthUnit.FEET)
                        .add(new Quantity<>(5, LengthUnit.FEET));

        assertEquals(10, result.getValue());
    }
    @Test
    void add_negative_values() {
        Quantity<LengthUnit> result =
                new Quantity<>(5, LengthUnit.FEET)
                        .add(new Quantity<>(-10, LengthUnit.FEET));

        assertEquals(-5, result.getValue());
    }
    @Test
    void add_cross_unit_length() {
        Quantity<LengthUnit> result =
                new Quantity<>(1, LengthUnit.FEET)
                        .add(new Quantity<>(12, LengthUnit.INCH));

        assertEquals(2, result.getValue());
    }

    @Test
    void add_same_unit_weight() {
        Quantity<WeightUnit> result =
                new Quantity<>(2, WeightUnit.KILOGRAM)
                        .add(new Quantity<>(3, WeightUnit.KILOGRAM));

        assertEquals(5, result.getValue());
    }

    @Test
    void add_cross_unit_weight() {
        Quantity<WeightUnit> result =
                new Quantity<>(1, WeightUnit.KILOGRAM)
                        .add(new Quantity<>(1000, WeightUnit.GRAM));

        assertEquals(2, result.getValue());
    }

    @Test
    void add_same_unit_volume() {
        Quantity<VolumeUnit> result =
                new Quantity<>(2, VolumeUnit.LITER)
                        .add(new Quantity<>(3, VolumeUnit.LITER));

        assertEquals(5, result.getValue());
    }

    @Test
    void add_cross_unit_volume() {
        Quantity<VolumeUnit> result =
                new Quantity<>(1, VolumeUnit.LITER)
                        .add(new Quantity<>(1000, VolumeUnit.MILLILITER));

        assertEquals(2, result.getValue());
    }

    /* ===================== SUBTRACTION TESTS ===================== */

    @Test
    void subtract_same_unit_length() {
        Quantity<LengthUnit> result =
                new Quantity<>(10, LengthUnit.FEET)
                        .subtract(new Quantity<>(5, LengthUnit.FEET));

        assertEquals(5, result.getValue());
    }

    @Test
    void subtract_cross_unit_length() {
        Quantity<LengthUnit> result =
                new Quantity<>(2, LengthUnit.FEET)
                        .subtract(new Quantity<>(12, LengthUnit.INCH));

        assertEquals(1, result.getValue());
    }

    @Test
    void subtract_same_unit_weight() {
        Quantity<WeightUnit> result =
                new Quantity<>(5, WeightUnit.KILOGRAM)
                        .subtract(new Quantity<>(2, WeightUnit.KILOGRAM));

        assertEquals(3, result.getValue());
    }

    @Test
    void subtract_cross_unit_volume() {
        Quantity<VolumeUnit> result =
                new Quantity<>(2, VolumeUnit.LITER)
                        .subtract(new Quantity<>(1000, VolumeUnit.MILLILITER));

        assertEquals(1, result.getValue());
    }

    @Test
    void subtract_result_zero() {
        Quantity<LengthUnit> result =
                new Quantity<>(5, LengthUnit.FEET)
                        .subtract(new Quantity<>(5, LengthUnit.FEET));

        assertEquals(0, result.getValue());
    }

    @Test
    void subtract_result_negative() {
        Quantity<LengthUnit> result =
                new Quantity<>(5, LengthUnit.FEET)
                        .subtract(new Quantity<>(10, LengthUnit.FEET));

        assertEquals(-5, result.getValue());
    }

    /* ===================== DIVISION TESTS ===================== */

    @Test
    void divide_length() {
        Quantity<LengthUnit> result =
                new Quantity<>(10, LengthUnit.FEET)
                        .divide(2);

        assertEquals(5, result.getValue());
    }
    @Test
    void divide_result_decimal() {
        Quantity<LengthUnit> result =
                new Quantity<>(5, LengthUnit.FEET)
                        .divide(2);

        assertEquals(2.5, result.getValue());
    }
    @Test
    void divide_weight() {
        Quantity<WeightUnit> result =
                new Quantity<>(10, WeightUnit.KILOGRAM)
                        .divide(2);

        assertEquals(5, result.getValue());
    }

    @Test
    void divide_volume() {
        Quantity<VolumeUnit> result =
                new Quantity<>(10, VolumeUnit.LITER)
                        .divide(2);

        assertEquals(5, result.getValue());
    }

    @Test
    void divide_by_zero_should_throw() {
        assertThrows(ArithmeticException.class, () ->
                new Quantity<>(10, LengthUnit.FEET).divide(0)
        );
    }

    /* ===================== INVALID OPERATIONS ===================== */

    @Test
    void add_cross_category_should_throw() {
        assertThrows(IllegalArgumentException.class, () ->
                new Quantity<>(1, LengthUnit.FEET)
                        .add((Quantity) new Quantity<>(1, WeightUnit.KILOGRAM))
        );
    }

    @Test
    void subtract_cross_category_should_throw() {
        assertThrows(IllegalArgumentException.class, () ->
                new Quantity<>(1, LengthUnit.FEET)
                        .subtract((Quantity) new Quantity<>(1, VolumeUnit.LITER))
        );
    }

    @Test
    void null_unit_should_throw() {
        assertThrows(IllegalArgumentException.class, () ->
                new Quantity<>(10, null)
        );
    }

    @Test
    void null_quantity_add_should_throw() {
        assertThrows(IllegalArgumentException.class, () ->
                new Quantity<>(10, LengthUnit.FEET).add(null)
        );
    }

    /* ===================== EDGE CASES ===================== */

    @Test
    void large_numbers_addition() {
        Quantity<WeightUnit> result =
                new Quantity<>(1000000, WeightUnit.KILOGRAM)
                        .add(new Quantity<>(1000000, WeightUnit.KILOGRAM));

        assertEquals(2000000, result.getValue());
    }

    @Test
    void precision_test() {
        Quantity<LengthUnit> result =
                new Quantity<>(0.5, LengthUnit.FEET)
                        .add(new Quantity<>(6, LengthUnit.INCH));

        assertEquals(1, result.getValue());
    }

    @Test
    void immutability_test() {
        Quantity<LengthUnit> original =
                new Quantity<>(10, LengthUnit.FEET);

        original.add(new Quantity<>(5, LengthUnit.FEET));

        assertEquals(10, original.getValue());
    }

    /* ===================== EXTRA VALIDATION TESTS ===================== */

    @Test void add_zero() { 
    	assertEquals(5, new Quantity<>(5, LengthUnit.FEET).add(new Quantity<>(0, LengthUnit.FEET)).getValue()); 
    }
    @Test void subtract_zero() { 
    	assertEquals(5, new Quantity<>(5, LengthUnit.FEET).subtract(new Quantity<>(0, LengthUnit.FEET)).getValue()); 
    }
    @Test void divide_by_one() { 
    	assertEquals(5, new Quantity<>(5, LengthUnit.FEET).divide(1).getValue()); 
    }
    @Test void equal_same_reference() { 
    	Quantity<LengthUnit> q = new Quantity<>(5, LengthUnit.FEET); assertEquals(q, q); 
    }
    @Test void equal_null() { 
    	assertNotEquals(new Quantity<>(5, LengthUnit.FEET), null); 
    }
    @Test void equal_different_type() { 
    	assertNotEquals(new Quantity<>(5, LengthUnit.FEET), "test"); 
    }
    @Test void subtract_chain() { 
    	assertEquals(3, new Quantity<>(10, LengthUnit.FEET).subtract(new Quantity<>(5, LengthUnit.FEET)).subtract(new Quantity<>(2, LengthUnit.FEET)).getValue()); 
    }
    @Test void add_chain() { 
    	assertEquals(7, new Quantity<>(2, LengthUnit.FEET).add(new Quantity<>(3, LengthUnit.FEET)).add(new Quantity<>(2, LengthUnit.FEET)).getValue()); 
    }
    @Test void weight_precision() { 
    	assertEquals(new Quantity<>(1, WeightUnit.KILOGRAM), new Quantity<>(1000, WeightUnit.GRAM)); 
    }
    @Test void volume_precision() { 
    	assertEquals(new Quantity<>(1, VolumeUnit.LITER), new Quantity<>(1000, VolumeUnit.MILLILITER)); 
    }

}