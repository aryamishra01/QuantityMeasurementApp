/*
 * Enum representing supported length units and their conversion factor relative to FEET.
 */
package com.QuantityMeasurement;

public enum LengthUnit {
    FEET(1.0),
    INCHES(1.0 / 12.0),        // 1 inch = 1/12 feet
    YARDS(3.0),                // 1 yard = 3 feet
    CENTIMETERS(0.0328084);    // 1 cm ≈ 0.0328084 feet

    private final double conversionFactorToFeet;

    LengthUnit(double factor) {
        this.conversionFactorToFeet = factor;
    }

    public double getConversionFactor() {
        return conversionFactorToFeet;
    }
}