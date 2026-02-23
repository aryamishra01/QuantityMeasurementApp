/*
 * Application class for UC4 demonstration.
 */

package com.QuantityMeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // Yard to Feet comparison
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
        System.out.println("1 Yard == 3 Feet : " + q1.equals(q2));

        // Yard to Inches comparison
        QuantityLength q3 = new QuantityLength(36.0, LengthUnit.INCHES);
        System.out.println("1 Yard == 36 Inches : " + q1.equals(q3));

        // Centimeter to Inches comparison
        QuantityLength q4 = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        QuantityLength q5 = new QuantityLength(0.393701, LengthUnit.INCHES);
        System.out.println("1 CM == 0.393701 Inches : " + q4.equals(q5));

        // Yard to Yard comparison
        QuantityLength q6 = new QuantityLength(2.0, LengthUnit.YARDS);
        QuantityLength q7 = new QuantityLength(2.0, LengthUnit.YARDS);
        System.out.println("2 Yard == 2 Yard : " + q6.equals(q7));

        // CM to CM comparison
        QuantityLength q8 = new QuantityLength(2.0, LengthUnit.CENTIMETERS);
        QuantityLength q9 = new QuantityLength(2.0, LengthUnit.CENTIMETERS);
        System.out.println("2 CM == 2 CM : " + q8.equals(q9));
    }
}