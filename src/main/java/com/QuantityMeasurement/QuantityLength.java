package com.QuantityMeasurement;

/**
 * Immutable class representing a quantity of length.
 * 
 * RESPONSIBILITY:
 * - Holds value + unit
 * - Delegates conversion to LengthUnit
 * - Performs equality & arithmetic logic
 * 
 * No conversion logic exists here anymore.
 */
public final class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    // Constructor with validation
    public QuantityLength(double value, LengthUnit unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    /**
     * Converts this quantity to another unit.
     * Delegates conversion responsibility to LengthUnit.
     */
    public QuantityLength convertTo(LengthUnit targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        // Convert current value to base unit (feet)
        double baseValue = unit.convertToBaseUnit(value);

        // Convert base unit to target unit
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);

        // Round to 3 decimals for readability
        convertedValue = Math.round(convertedValue * 1000.0) / 1000.0;

        return new QuantityLength(convertedValue, targetUnit);
    }

    /**
     * UC6 compatibility:
     * Add and return result in unit of first operand.
     */
    public QuantityLength add(QuantityLength other) {
        return add(other, this.unit);
    }

    /**
     * UC7 compatibility:
     * Add with explicit target unit.
     */
    public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {

        if (other == null)
            throw new IllegalArgumentException("Other quantity cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        // Convert both to base unit
        double base1 = this.unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        // Add in base unit
        double sumBase = base1 + base2;

        // Convert sum to target unit
        double result = targetUnit.convertFromBaseUnit(sumBase);

        result = Math.round(result * 1000.0) / 1000.0;

        return new QuantityLength(result, targetUnit);
    }

    /**
     * Equality check across different units.
     * Uses base unit comparison.
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof QuantityLength))
            return false;

        QuantityLength other = (QuantityLength) obj;

        double base1 = this.unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return Math.abs(base1 - base2) < 0.001;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}