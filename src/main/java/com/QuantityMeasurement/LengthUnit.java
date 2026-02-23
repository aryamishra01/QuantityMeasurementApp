package com.QuantityMeasurement;

//Enum to define supported Length Units and their conversion factor to base unit (FEET)
public enum LengthUnit {
 FEET(1.0),            // Base unit
 INCHES(1.0 / 12),     // 1 inch = 1/12 feet
 YARDS(3.0),           // 1 yard = 3 feet
 CENTIMETERS(0.0328084); // 1 cm ≈ 0.0328084 feet

 private final double toFeetFactor;

 LengthUnit(double toFeetFactor) {
     this.toFeetFactor = toFeetFactor;
 }

 // Convert a value from this unit to FEET (base unit)
 public double toFeet(double value) {
     return value * toFeetFactor;
 }

 // Convert a value from FEET (base unit) to this unit
 public double fromFeet(double feetValue) {
     return feetValue / toFeetFactor;
 }
}