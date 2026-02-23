package com.QuantityMeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        // Conversion
        System.out.println(q1.convertTo(LengthUnit.INCHES));
        // Output: Quantity(12.0, INCHES)

        // Addition with explicit target
        System.out.println(q1.add(q2, LengthUnit.FEET));
        // Output: Quantity(2.0, FEET)

        // Equality
        System.out.println(
            new QuantityLength(36.0, LengthUnit.INCHES)
                .equals(new QuantityLength(1.0, LengthUnit.YARDS))
        );
        // Output: true

        // Unit conversion directly from enum
        System.out.println(LengthUnit.INCHES.convertToBaseUnit(12.0));
        // Output: 1.0
    }
}