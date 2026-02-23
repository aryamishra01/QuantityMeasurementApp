/*
 * Application class for UC4 demonstration.
 */

package com.QuantityMeasurement;

public class QuantityMeasurementApp {
    public static void main(String[] args) {

        // Using static conversion method
        QuantityLength.demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES);
        QuantityLength.demonstrateLengthConversion(3.0, LengthUnit.YARDS, LengthUnit.FEET);
        QuantityLength.demonstrateLengthConversion(36.0, LengthUnit.INCHES, LengthUnit.YARDS);
        QuantityLength.demonstrateLengthConversion(1.0, LengthUnit.CENTIMETERS, LengthUnit.INCHES);

        // Using instance conversion method
        QuantityLength lengthInYards = new QuantityLength(2.0, LengthUnit.YARDS);
        QuantityLength.demonstrateLengthConversion(lengthInYards, LengthUnit.INCHES);

        // Equality check
        QuantityLength a = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength b = new QuantityLength(1.0, LengthUnit.FEET);
        System.out.println("Are a and b equal? " + a.equals(b));
    }
}
