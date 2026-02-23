package com.QuantityMeasurement;

/*
 * Enum representing Length units.
 * Base unit: FOOT
 */
public enum LengthUnit implements Unit {

    FEET(1.0),
    INCH(1.0 / 12.0),
    YARD(3.0);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    // Converts given value to base unit (Feet)
    @Override
    public double toBaseUnit(double value) {
        return value * conversionFactor;
    }

    @Override
    public String getType() {
        return "LENGTH";
    }
}