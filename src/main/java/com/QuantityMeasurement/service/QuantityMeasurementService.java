package com.QuantityMeasurement.service;

import com.QuantityMeasurement.Quantity;
import com.QuantityMeasurement.IMeasurable;
import com.QuantityMeasurement.dto.QuantityDTO;
import com.QuantityMeasurement.dto.QuantityMapper;
import com.QuantityMeasurement.exception.QuantityMeasurementException;
import com.QuantityMeasurement.units.LengthUnit;
import com.QuantityMeasurement.units.WeightUnit;
import com.QuantityMeasurement.units.VolumeUnit;
import com.QuantityMeasurement.units.TemperatureUnit;

/**
 * Concrete implementation of IQuantityMeasurementService.
 * Uses Quantity and unit enums to perform conversions and arithmetic,
 * and maps to/from DTOs via QuantityMapper.
 */
public class QuantityMeasurementService implements IQuantityMeasurementService {

    public QuantityDTO compare(QuantityDTO left, QuantityDTO right) {
        if (left == null || right == null)
            throw QuantityMeasurementException.invalidConversion("Null operand for comparison");

        Quantity<?> qLeft = QuantityMapper.toQuantity(left);
        Quantity<?> qRight = QuantityMapper.toQuantity(right);

        // Validate same measurement category
        if (!qLeft.getUnit().getMeasurementType().equalsIgnoreCase(qRight.getUnit().getMeasurementType()))
            throw QuantityMeasurementException.crossCategoryOperation("Cannot compare different measurement types");

        double baseLeft = qLeft.getUnit().convertToBaseUnit(qLeft.getValue());
        double baseRight = qRight.getUnit().convertToBaseUnit(qRight.getValue());

        int cmp = Double.compare(baseLeft, baseRight);
        // Return -1/0/1 as value to indicate comparison result; unit set to measurement type for clarity
        return new QuantityDTO(cmp, left.getUnit(), left.getMeasurementType());
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public QuantityDTO convert(QuantityDTO source, String targetUnit) {
        if (source == null)
            throw QuantityMeasurementException.invalidConversion("Source quantity is null");

        Quantity<?> q = QuantityMapper.toQuantity(source);
        IMeasurable target = resolveTargetUnit(source.getMeasurementType(), targetUnit);
        if (target == null)
            throw QuantityMeasurementException.invalidConversion("Unknown target unit: " + targetUnit);

        try {
            // Use raw Quantity to avoid generic capture issues at compile time
            Quantity raw = (Quantity) q;
            Quantity converted = raw.convertTo(target);
            return QuantityMapper.fromQuantity(converted);
        } catch (IllegalArgumentException ex) {
            throw QuantityMeasurementException.invalidConversion(ex.getMessage());
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public QuantityDTO add(QuantityDTO a, QuantityDTO b) {
        if (a == null || b == null)
            throw QuantityMeasurementException.invalidConversion("Null operand for addition");

        Quantity<?> qa = QuantityMapper.toQuantity(a);
        Quantity<?> qb = QuantityMapper.toQuantity(b);

        try {
            Quantity rawA = (Quantity) qa;
            Quantity rawB = (Quantity) qb;
            Quantity result = rawA.add(rawB);
            return QuantityMapper.fromQuantity(result);
        } catch (IllegalArgumentException ex) {
            throw QuantityMeasurementException.crossCategoryOperation(ex.getMessage());
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public QuantityDTO subtract(QuantityDTO a, QuantityDTO b) {
        if (a == null || b == null)
            throw QuantityMeasurementException.invalidConversion("Null operand for subtraction");

        Quantity<?> qa = QuantityMapper.toQuantity(a);
        Quantity<?> qb = QuantityMapper.toQuantity(b);

        try {
            Quantity rawA = (Quantity) qa;
            Quantity rawB = (Quantity) qb;
            Quantity result = rawA.subtract(rawB);
            return QuantityMapper.fromQuantity(result);
        } catch (IllegalArgumentException ex) {
            throw QuantityMeasurementException.crossCategoryOperation(ex.getMessage());
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public QuantityDTO divide(QuantityDTO a, QuantityDTO b) {
        if (a == null || b == null)
            throw QuantityMeasurementException.invalidConversion("Null operand for division");

        Quantity<?> qa = QuantityMapper.toQuantity(a);
        Quantity<?> qb = QuantityMapper.toQuantity(b);

        try {
            Quantity rawA = (Quantity) qa;
            Quantity rawB = (Quantity) qb;
            double result = rawA.divide(rawB);
            // Return the numeric result as a DTO. Use composite unit name to indicate ratio.
            String unit = qa.getUnit().getUnitName() + "/" + qb.getUnit().getUnitName();
            return new QuantityDTO(result, unit, "RATIO");
        } catch (IllegalArgumentException ex) {
            throw QuantityMeasurementException.crossCategoryOperation(ex.getMessage());
        } catch (ArithmeticException ex) {
            throw QuantityMeasurementException.arithmeticError(ex.getMessage());
        }
    }

    private IMeasurable resolveTargetUnit(String measurementType, String targetUnitName) {
        if (measurementType == null || targetUnitName == null)
            return null;

        switch (measurementType.trim().toUpperCase()) {
            case "LENGTH":
                return LengthUnit.FEET.fromUnitName(targetUnitName);
            case "WEIGHT":
                return WeightUnit.KILOGRAM.fromUnitName(targetUnitName);
            case "VOLUME":
                return VolumeUnit.LITRE.fromUnitName(targetUnitName);
            case "TEMPERATURE":
                return TemperatureUnit.CELSIUS.fromUnitName(targetUnitName);
            default:
                return null;
        }
    }
}
