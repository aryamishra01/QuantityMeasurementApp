package com.QuantityMeasurement;

/*
 * Unit interface represents a measurable unit.
 * Every unit must provide:
 * 1. Conversion factor to base unit
 * 2. Measurement category (Length, Weight, Volume)
 */
public interface Unit {

    // Returns conversion factor relative to base unit
    double toBaseUnit(double value);

    // Returns category of unit (LENGTH, WEIGHT, VOLUME)
    String getType();
}