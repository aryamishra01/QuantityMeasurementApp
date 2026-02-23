/*
 * Generic length class supporting multiple units.
 */
package com.QuantityMeasurement;

public class QuantityLength {

    private final double value;
    private final LengthUnit unit;
    private static final double EPSILON = 0.0001;

    public QuantityLength(double value, LengthUnit unit) {

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (Double.isNaN(value)) {
            throw new IllegalArgumentException("Value must be numeric");
        }
        this.value = value;
        this.unit = unit;
    }

    private double convertToInches() {
        return unit.toInches(value);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        QuantityLength other = (QuantityLength) obj;

        double thisInches = this.convertToInches();
        double otherInches = other.convertToInches();

        return Math.abs(thisInches - otherInches) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(convertToInches());
    }
}