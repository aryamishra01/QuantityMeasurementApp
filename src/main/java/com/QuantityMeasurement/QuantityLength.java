/*
 * Generic class representing a length measurement.
 * Eliminates duplication of Feet and Inches classes.
 * Applies DRY principle.
 */

package com.QuantityMeasurement;

public class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    /*
     * Constructor validates numeric value and supported unit.
     */
    public QuantityLength(double value, LengthUnit unit) {

        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Invalid numeric value");
        }

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    /*
     * Converts measurement to base unit (Feet).
     */
    private double toFeet() {
        return value * unit.getConversionFactorToFeet();
    }

    /*
     * Overrides equals method for value-based comparison.
     * Supports cross-unit comparison.
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        QuantityLength other = (QuantityLength) obj;

        return Double.compare(this.toFeet(), other.toFeet()) == 0;
    }
}
