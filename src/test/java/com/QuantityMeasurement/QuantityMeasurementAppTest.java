package com.QuantityMeasurement;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * UC9 – Complete Weight Test Cases
 * Covers Equality, Conversion and Addition scenarios
 */
class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.0001;

    /* =========================================================
       ===================== EQUALITY ==========================
       ========================================================= */

    @Test
    void testEquality_KilogramToKilogram_SameValue() {
        assertEquals(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(1.0, WeightUnit.KILOGRAM));
    }

    @Test
    void testEquality_KilogramToKilogram_DifferentValue() {
        assertNotEquals(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(2.0, WeightUnit.KILOGRAM));
    }

    @Test
    void testEquality_KilogramToGram_EquivalentValue() {
        assertEquals(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(1000.0, WeightUnit.GRAM));
    }

    @Test
    void testEquality_GramToKilogram_EquivalentValue() {
        assertEquals(
                new QuantityWeight(1000.0, WeightUnit.GRAM),
                new QuantityWeight(1.0, WeightUnit.KILOGRAM));
    }

    @Test
    void testEquality_WeightVsLength_Incompatible() {
        Object length = new Object(); // Simulating incompatible type
        assertNotEquals(new QuantityWeight(1.0, WeightUnit.KILOGRAM), length);
    }

    @Test
    void testEquality_NullComparison() {
        assertNotEquals(new QuantityWeight(1.0, WeightUnit.KILOGRAM), null);
    }

    @Test
    void testEquality_SameReference() {
        QuantityWeight weight = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertEquals(weight, weight);
    }

    @Test
    void testEquality_NullUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> new QuantityWeight(1.0, null));
    }

    @Test
    void testEquality_TransitiveProperty() {
        QuantityWeight a = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight b = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight c = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        assertEquals(a, b);
        assertEquals(b, c);
        assertEquals(a, c);
    }

    @Test
    void testEquality_ZeroValue() {
        assertEquals(
                new QuantityWeight(0.0, WeightUnit.KILOGRAM),
                new QuantityWeight(0.0, WeightUnit.GRAM));
    }

    @Test
    void testEquality_NegativeWeight() {
        assertEquals(
                new QuantityWeight(-1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(-1000.0, WeightUnit.GRAM));
    }

    @Test
    void testEquality_LargeWeightValue() {
        assertEquals(
                new QuantityWeight(1000000.0, WeightUnit.GRAM),
                new QuantityWeight(1000.0, WeightUnit.KILOGRAM));
    }

    @Test
    void testEquality_SmallWeightValue() {
        assertEquals(
                new QuantityWeight(0.001, WeightUnit.KILOGRAM),
                new QuantityWeight(1.0, WeightUnit.GRAM));
    }

    /* =========================================================
       ===================== CONVERSION ========================
       ========================================================= */

    @Test
    void testConversion_PoundToKilogram() {
        QuantityWeight result =
                new QuantityWeight(2.20462, WeightUnit.POUND)
                        .convertTo(WeightUnit.KILOGRAM);

        assertEquals(1.0, result.getValue(), EPSILON);
    }

    @Test
    void testConversion_KilogramToPound() {
        QuantityWeight result =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.POUND);

        assertEquals(2.20462, result.getValue(), EPSILON);
    }

    @Test
    void testConversion_SameUnit() {
        QuantityWeight result =
                new QuantityWeight(5.0, WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.KILOGRAM);

        assertEquals(5.0, result.getValue(), EPSILON);
    }

    @Test
    void testConversion_ZeroValue() {
        QuantityWeight result =
                new QuantityWeight(0.0, WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.GRAM);

        assertEquals(0.0, result.getValue(), EPSILON);
    }

    @Test
    void testConversion_NegativeValue() {
        QuantityWeight result =
                new QuantityWeight(-1.0, WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.GRAM);

        assertEquals(-1000.0, result.getValue(), EPSILON);
    }

    @Test
    void testConversion_RoundTrip() {
        QuantityWeight result =
                new QuantityWeight(1.5, WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.GRAM)
                        .convertTo(WeightUnit.KILOGRAM);

        assertEquals(1.5, result.getValue(), EPSILON);
    }

    /* =========================================================
       ====================== ADDITION =========================
       ========================================================= */

    @Test
    void testAddition_SameUnit_KilogramPlusKilogram() {
        QuantityWeight result =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(2.0, WeightUnit.KILOGRAM));

        assertEquals(3.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_CrossUnit_KilogramPlusGram() {
        QuantityWeight result =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(1000.0, WeightUnit.GRAM));

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_CrossUnit_PoundPlusKilogram() {
        QuantityWeight result =
                new QuantityWeight(2.20462, WeightUnit.POUND)
                        .add(new QuantityWeight(1.0, WeightUnit.KILOGRAM));

        assertEquals(4.40924, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Kilogram() {
        QuantityWeight result =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(1000.0, WeightUnit.GRAM),
                                WeightUnit.GRAM);

        assertEquals(2000.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_Commutativity() {
        QuantityWeight a =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(1000.0, WeightUnit.GRAM));

        QuantityWeight b =
                new QuantityWeight(1000.0, WeightUnit.GRAM)
                        .add(new QuantityWeight(1.0, WeightUnit.KILOGRAM));

        assertEquals(a.convertTo(WeightUnit.KILOGRAM),
                     b.convertTo(WeightUnit.KILOGRAM));
    }

    @Test
    void testAddition_WithZero() {
        QuantityWeight result =
                new QuantityWeight(5.0, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(0.0, WeightUnit.GRAM));

        assertEquals(5.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_NegativeValues() {
        QuantityWeight result =
                new QuantityWeight(5.0, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(-2000.0, WeightUnit.GRAM));

        assertEquals(3.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_LargeValues() {
        QuantityWeight result =
                new QuantityWeight(1e6, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(1e6, WeightUnit.KILOGRAM));

        assertEquals(2e6, result.getValue(), EPSILON);
    }
}