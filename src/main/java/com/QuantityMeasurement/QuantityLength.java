/**
 * Represents a length quantity with value and unit.
 * Supports conversion, equality, and addition.
 */

package com.QuantityMeasurement;

public class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Value must be finite");
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    // Convert to another unit
    public QuantityLength convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
        double valueInFeet = this.value * unit.getConversionFactor();
        double convertedValue = valueInFeet / targetUnit.getConversionFactor();
        return new QuantityLength(convertedValue, targetUnit);
    }

    // Static conversion utility
    public static double convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit) {
        if (sourceUnit == null || targetUnit == null)
            throw new IllegalArgumentException("Units cannot be null");
        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");

        double valueInFeet = value * sourceUnit.getConversionFactor();
        return valueInFeet / targetUnit.getConversionFactor();
    }

    // Addition of two QuantityLength objects, result in first operand's unit
    public QuantityLength add(QuantityLength other) {
        if (other == null) throw new IllegalArgumentException("Operand cannot be null");

        double thisInFeet = this.value * this.unit.getConversionFactor();
        double otherInFeet = other.value * other.unit.getConversionFactor();

        double sumInFeet = thisInFeet + otherInFeet;
        double sumInTargetUnit = sumInFeet / this.unit.getConversionFactor();

        return new QuantityLength(sumInTargetUnit, this.unit);
    }

    // Overriding equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof QuantityLength)) return false;
        QuantityLength other = (QuantityLength) obj;

        double epsilon = 1e-6;
        double thisInFeet = this.value * this.unit.getConversionFactor();
        double otherInFeet = other.value * other.unit.getConversionFactor();

        return Math.abs(thisInFeet - otherInFeet) < epsilon;
    }

    // Overriding toString
    @Override
    public String toString() {
        return String.format("%.6f %s", value, unit);
    }
}