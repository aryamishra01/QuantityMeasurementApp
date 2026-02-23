package com.QuantityMeasurement;

/**
 * Standalone LengthUnit enum.
 * 
 * RESPONSIBILITY:
 * - Stores conversion factor relative to base unit (FEET)
 * - Converts value to base unit (feet)
 * - Converts value from base unit (feet)
 * 
 * This class now fully owns conversion logic (SRP).
 */
public enum LengthUnit {

    FEET(1.0),                // Base unit
    INCHES(1.0 / 12),         // 1 inch = 1/12 feet
    YARDS(3.0),               // 1 yard = 3 feet
    CENTIMETERS(1.0 / 30.48); // 1 cm = 1/30.48 feet

    // Conversion factor relative to base unit (FEET)
    private final double conversionFactor;

    // Constructor
    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    /**
     * Converts a value in this unit to base unit (feet).
     */
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    /**
     * Converts a value from base unit (feet) to this unit.
     */
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }

    /**
     * Getter for conversion factor (used in unit tests).
     */
    public double getConversionFactor() {
        return conversionFactor;
    }
}