package com.QuantityMeasurement;

/*
 * Generic Quantity class that holds:
 *  - value
 *  - unit
 * 
 * Supports:
 *  - Addition
 *  - Subtraction
 *  - Division
 *  - Equality check
 * 
 * Ensures:
 *  - Same measurement category
 *  - Immutability
 */
public class Quantity<U extends Unit> {

    private final double value;
    private final U unit;

    // Constructor
    public Quantity(double value, U unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    // Converts current value to base unit
    private double toBase() {
        return unit.toBaseUnit(value);
    }

    // Adds two quantities of same type
    public Quantity<U> add(Quantity<U> other) {
        validate(other);

        double resultBase = this.toBase() + other.toBase();
        double result = resultBase / unit.toBaseUnit(1);

        return new Quantity<>(result, unit);
    }

    // Subtracts two quantities of same type
    public Quantity<U> subtract(Quantity<U> other) {
        validate(other);

        double resultBase = this.toBase() - other.toBase();
        double result = resultBase / unit.toBaseUnit(1);

        return new Quantity<>(result, unit);
    }

    // Divides quantity by a number
    public Quantity<U> divide(double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return new Quantity<>(this.value / divisor, this.unit);
    }

    // Validates same category
    private void validate(Quantity<U> other) {
        if (other == null) {
            throw new IllegalArgumentException("Quantity cannot be null");
        }
        if (!this.unit.getType().equals(other.unit.getType())) {
            throw new IllegalArgumentException("Cannot operate on different unit types");
        }
    }

    // Equality check based on base value
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity<?> other)) return false;

        return Double.compare(this.toBase(), other.toBase()) == 0;
    }
}