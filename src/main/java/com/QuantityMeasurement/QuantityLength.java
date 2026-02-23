package com.QuantityMeasurement;

// Immutable class representing a quantity of length
public final class QuantityLength {
    private final double value;
    private final LengthUnit unit;

    // Constructor
    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be a finite number");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    // Add two QuantityLength objects and return result in the unit of the first operand
    public QuantityLength add(QuantityLength other) {
        return add(other, this.unit); // Default to first operand's unit
    }

    // Add two QuantityLength objects and return result in explicitly specified target unit
    public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {
        if (other == null) {
            throw new IllegalArgumentException("Other length cannot be null");
        }
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        // Convert both operands to base unit (FEET)
        double thisInFeet = this.unit.toFeet(this.value);
        double otherInFeet = other.unit.toFeet(other.value);

        // Sum values in base unit
        double sumInFeet = thisInFeet + otherInFeet;

        // Convert sum to target unit
        double sumInTargetUnit = targetUnit.fromFeet(sumInFeet);

        // Round to 3 decimal places for readability
        sumInTargetUnit = Math.round(sumInTargetUnit * 1000.0) / 1000.0;

        // Return new immutable QuantityLength object
        return new QuantityLength(sumInTargetUnit, targetUnit);
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}