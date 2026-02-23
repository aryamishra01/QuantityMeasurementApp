/**
 * Represents a length quantity with value and unit.
 * Provides conversion between units, equality check, and string representation.
 */
package com.QuantityMeasurement;

public class QuantityLength {

    private final double value;      // immutable
    private final LengthUnit unit;   // immutable

    // Constructor
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

    /**
     * Converts this QuantityLength to the target unit.
     * Returns a new QuantityLength instance.
     */
    public QuantityLength convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");

        double valueInFeet = this.value * unit.getConversionFactor(); // normalize to base
        double convertedValue = valueInFeet / targetUnit.getConversionFactor(); // convert to target
        return new QuantityLength(convertedValue, targetUnit);
    }

    /**
     * Static method for quick conversion without creating object.
     */
    public static double convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit) {
        if (sourceUnit == null || targetUnit == null) 
            throw new IllegalArgumentException("Units cannot be null");
        if (!Double.isFinite(value)) 
            throw new IllegalArgumentException("Value must be finite");

        double valueInFeet = value * sourceUnit.getConversionFactor();
        return valueInFeet / targetUnit.getConversionFactor();
    }

    // Overriding equals to compare normalized values
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

    // Overloaded methods for demonstration
    public static void demonstrateLengthConversion(double value, LengthUnit from, LengthUnit to) {
        double converted = QuantityLength.convert(value, from, to);
        System.out.printf("%.6f %s = %.6f %s%n", value, from, converted, to);
    }

    public static void demonstrateLengthConversion(QuantityLength quantity, LengthUnit to) {
        QuantityLength converted = quantity.convertTo(to);
        System.out.printf("%s = %s%n", quantity, converted);
    }
}