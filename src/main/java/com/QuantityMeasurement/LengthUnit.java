/*
 * Enum representing supported length units.
 * Each unit stores its conversion factor relative to base unit (Feet).
 */
package com.QuantityMeasurement;

public enum LengthUnit {

    FEET(1.0),
    INCH(1.0 / 12.0);

    private final double conversionFactorToFeet;

    LengthUnit(double conversionFactorToFeet) {
        this.conversionFactorToFeet = conversionFactorToFeet;
    }

    /*
     * Returns conversion factor to base unit (Feet).
     */
    public double getConversionFactorToFeet() {
        return conversionFactorToFeet;
    }
}
