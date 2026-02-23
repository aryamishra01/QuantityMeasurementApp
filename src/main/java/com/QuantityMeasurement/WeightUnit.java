package com.QuantityMeasurement;

/**
 * Enum representing Weight Units.
 * Base unit is KILOGRAM.
 */
public enum WeightUnit {

    KILOGRAM(1.0),       // Base unit
    GRAM(0.001),         // 1 gram = 0.001 kg
    POUND(0.453592);     // 1 pound = 0.453592 kg

    private final double toKilogramFactor;

    WeightUnit(double toKilogramFactor) {
        this.toKilogramFactor = toKilogramFactor;
    }

    /**
     * Converts given value to base unit (Kilogram)
     */
    public double toBase(double value) {
        return value * toKilogramFactor;
    }

    /**
     * Converts value from base unit (Kilogram) to this unit
     */
    public double fromBase(double baseValue) {
        return baseValue / toKilogramFactor;
    }
}