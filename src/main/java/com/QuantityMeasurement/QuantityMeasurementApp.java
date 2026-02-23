package com.QuantityMeasurement;

/*
 * Main application class.
 * Contains static methods to check equality.
 */
public class QuantityMeasurementApp {

    public static void main(String[] args) {

        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + checkFeetEquality(1.0, 1.0) + ")");

        System.out.println();

        System.out.println("Input: 1.0 inch and 1.0 inch");
        System.out.println("Output: Equal (" + checkInchEquality(1.0, 1.0) + ")");
    }

    /*
     * Checks equality between two Feet values.
     */
    public static boolean checkFeetEquality(double value1, double value2) {

        Feet feet1 = new Feet(value1);
        Feet feet2 = new Feet(value2);

        return feet1.equals(feet2);
    }

    /*
     * Checks equality between two Inches values.
     */
    public static boolean checkInchEquality(double value1, double value2) {

        Inches inch1 = new Inches(value1);
        Inches inch2 = new Inches(value2);

        return inch1.equals(inch2);
    }
}
