/*
 * Enum representing supported length units.
 * All conversion factors are relative to base unit (Feet).
 */
package com.QuantityMeasurement;

public enum LengthUnit {

    FEET(12.0),             // 1 foot = 12 inches
    INCHES(1.0),            // Base unit
    YARDS(36.0),            // 1 yard = 36 inches
    CENTIMETERS(0.393701);  // 1 cm = 0.393701 inches

    private final double conversionFactorToInches;

    LengthUnit(double conversionFactorToInches) {
        this.conversionFactorToInches = conversionFactorToInches;
    }

    public double toInches(double value) {
        return value * conversionFactorToInches;
    }
}