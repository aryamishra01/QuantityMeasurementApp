package com.QuantityMeasurement;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * UC9 - Weight Test Cases
 */
class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.0001;

    /* ================= EQUALITY ================= */

    @Test
    void testSameUnitEquality() {
        assertEquals(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(1.0, WeightUnit.KILOGRAM));
    }

    @Test
    void testCrossUnitEquality() {
        assertEquals(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(1000.0, WeightUnit.GRAM));
    }

    @Test
    void testInequality() {
        assertNotEquals(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(2.0, WeightUnit.KILOGRAM));
    }

    @Test
    void testNullEquality() {
        assertNotEquals(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                null);
    }

    /* ================= CONVERSION ================= */

    @Test
    void testKilogramToGram() {
        QuantityWeight result =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, result.getValue(), EPSILON);
    }

    @Test
    void testGramToKilogram() {
        QuantityWeight result =
                new QuantityWeight(1000.0, WeightUnit.GRAM)
                        .convertTo(WeightUnit.KILOGRAM);

        assertEquals(1.0, result.getValue(), EPSILON);
    }

    @Test
    void testPoundToKilogram() {
        QuantityWeight result =
                new QuantityWeight(2.20462, WeightUnit.POUND)
                        .convertTo(WeightUnit.KILOGRAM);

        assertEquals(1.0, result.getValue(), EPSILON);
    }

    /* ================= ADDITION ================= */

    @Test
    void testAdditionSameUnit() {
        QuantityWeight result =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(2.0, WeightUnit.KILOGRAM));

        assertEquals(3.0, result.getValue(), EPSILON);
    }

    @Test
    void testAdditionCrossUnit() {
        QuantityWeight result =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(1000.0, WeightUnit.GRAM));

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    void testAdditionWithTargetUnit() {
        QuantityWeight result =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                                WeightUnit.GRAM);

        assertEquals(2000.0, result.getValue(), EPSILON);
    }

    /* ================= VALIDATION ================= */

    @Test
    void testNullUnitInConstructor() {
        assertThrows(IllegalArgumentException.class,
                () -> new QuantityWeight(1.0, null));
    }

    @Test
    void testNullAddition() {
        assertThrows(IllegalArgumentException.class,
                () -> new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                        .add(null));
    }
}