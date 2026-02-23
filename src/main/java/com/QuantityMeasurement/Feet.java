package com.QuantityMeasurement;

/*
 * Represents a measurement in Feet.
 * Encapsulates a numeric value and provides value-based equality.
 */
public class Feet {

    // Stores the feet value
    private double value;

    /*
     * Constructor to initialize Feet object.
     * Validates that the input is a proper numeric value.
     */
    public Feet(double value) {
        if (!isNumeric(value)) {
            throw new IllegalArgumentException("Invalid numeric value for Feet");
        }
        this.value = value;
    }

    /*
     * Checks whether the value is not NaN or Infinite.
     */
    private boolean isNumeric(double value) {
        return !Double.isNaN(value) && !Double.isInfinite(value);
    }

    // Getter method
    public double getValue() {
        return value;
    }

    /*
     * Overrides equals method to compare Feet objects
     * based on their stored value.
     */
    @Override
    public boolean equals(Object obj) {

        // Returns true if both references point to the same object
        if (this == obj) {
            return true;
        }

        // Returns false if compared object is null
        if (obj == null) {
            return false;
        }

        // Ensures both objects belong to the same class
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        // Type casting
        Feet other = (Feet) obj;

        // Compares floating point values safely
        return Double.compare(this.value, other.value) == 0;
    }
}
