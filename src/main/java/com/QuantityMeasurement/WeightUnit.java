package com.QuantityMeasurement;

/*
 * Enum representing Weight units.
 * Base unit: KILOGRAM
 */
public enum WeightUnit implements Unit {

    KILOGRAM(1.0),
    GRAM(0.001),
    TONNE(1000.0);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    // Converts given value to base unit (Kilogram)
    @Override
    public double toBaseUnit(double value) {
        return value * conversionFactor;
    }

    @Override
    public String getType() {
        return "WEIGHT";
    }
}