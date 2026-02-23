package com.QuantityMeasurement;

public class QuantityMeasurementApp {
    public static void main(String[] args) {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        // Examples of addition with explicit target unit
        System.out.println(q1.add(q2, LengthUnit.FEET));      // Quantity(2.0, FEET)
        System.out.println(q1.add(q2, LengthUnit.INCHES));    // Quantity(24.0, INCHES)
        System.out.println(q1.add(q2, LengthUnit.YARDS));     // Quantity(0.667, YARDS)

        QuantityLength q3 = new QuantityLength(36.0, LengthUnit.INCHES);
        QuantityLength q4 = new QuantityLength(1.0, LengthUnit.YARDS);

        System.out.println(q3.add(q4, LengthUnit.FEET));      // Quantity(6.0, FEET)

        QuantityLength q5 = new QuantityLength(2.54, LengthUnit.CENTIMETERS);
        QuantityLength q6 = new QuantityLength(1.0, LengthUnit.INCHES);

        System.out.println(q5.add(q6, LengthUnit.CENTIMETERS)); // Quantity(5.08, CENTIMETERS)

        QuantityLength q7 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q8 = new QuantityLength(-2.0, LengthUnit.FEET);

        System.out.println(q7.add(q8, LengthUnit.INCHES));    // Quantity(36.0, INCHES)
    }
}
