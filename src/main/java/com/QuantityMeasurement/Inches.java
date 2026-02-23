package com.QuantityMeasurement;

/*
 * Represents a measurement in Inches.
 * Similar structure to Feet class.
 */
public class Inches {

    // Stores the inches value
    private double value;

    public Inches(double value) {
        if (!isNumeric(value)) {
            throw new IllegalArgumentException("Invalid numeric value for Inches");
        }
        this.value = value;
    }

    // Validates numeric value
    private boolean isNumeric(double value) {
        return !Double.isNaN(value) && !Double.isInfinite(value);
    }

    // Getter method
    public double getValue() {
        return value;
    }

    /*
     * Compares two Inches objects based on value.
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

        Inches other = (Inches) obj;

        return Double.compare(this.value, other.value) == 0;
    }
}
