package com.QuantityMeasurement;

/**
 * Immutable class representing a Weight Quantity.
 */
public final class QuantityWeight {

    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
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

    public WeightUnit getUnit() {
        return unit;
    }

    /**
     * Convert current weight to target unit
     */
    public QuantityWeight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double valueInKg = unit.toBase(value);
        double converted = targetUnit.fromBase(valueInKg);

        return new QuantityWeight(converted, targetUnit);
    }

    /**
     * Add two weights and return result in this object's unit
     */
    public QuantityWeight add(QuantityWeight other) {
        return add(other, this.unit);
    }

    /**
     * Add two weights and return result in target unit
     */
    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {
        if (other == null)
            throw new IllegalArgumentException("Other weight cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double thisInKg = this.unit.toBase(this.value);
        double otherInKg = other.unit.toBase(other.value);

        double sumInKg = thisInKg + otherInKg;

        double result = targetUnit.fromBase(sumInKg);

        return new QuantityWeight(result, targetUnit);
    }

    /**
     * Equality based on base unit comparison
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof QuantityWeight))
            return false;

        QuantityWeight other = (QuantityWeight) obj;

        double thisInKg = this.unit.toBase(this.value);
        double otherInKg = other.unit.toBase(other.value);

        return Math.abs(thisInKg - otherInKg) < 0.0001;
    }

    @Override
    public int hashCode() {
        double valueInKg = unit.toBase(value);
        return Double.hashCode(valueInKg);
    }

    @Override
    public String toString() {
        return "QuantityWeight(" + value + ", " + unit + ")";
    }
}