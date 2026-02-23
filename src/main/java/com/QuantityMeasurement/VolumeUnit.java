package com.QuantityMeasurement;

/*
 * Enum representing Volume units.
 * Base unit: LITER
 */
public enum VolumeUnit implements Unit {

    LITER(1.0),
    MILLILITER(0.001),
    GALLON(3.78);

    private final double conversionFactor;

    VolumeUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    // Converts given value to base unit (Liter)
    @Override
    public double toBaseUnit(double value) {
        return value * conversionFactor;
    }

    @Override
    public String getType() {
        return "VOLUME";
    }
}