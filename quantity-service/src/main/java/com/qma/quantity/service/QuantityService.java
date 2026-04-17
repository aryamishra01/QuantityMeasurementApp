package com.qma.quantity.service;

import com.qma.quantity.client.HistoryClient;
import com.qma.quantity.dto.ConvertRequest;
import com.qma.quantity.dto.HistoryRequest;
import com.qma.quantity.dto.OperationRequest;
import com.qma.quantity.entity.QuantityRecord;
import com.qma.quantity.repository.QuantityRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuantityService {

    private final QuantityRecordRepository quantityRecordRepository;
    private final HistoryClient historyClient;

    public QuantityService(QuantityRecordRepository quantityRecordRepository,
                           HistoryClient historyClient) {
        this.quantityRecordRepository = quantityRecordRepository;
        this.historyClient = historyClient;
    }

    public String add(OperationRequest request) {
        validateSameUnit(request.getFirstUnit(), request.getSecondUnit());
        double result = request.getFirstValue() + request.getSecondValue();
        String finalResult = result + " " + request.getFirstUnit();
        saveRecord(request, "ADD", finalResult);
        saveHistory(1L, "ADD",
                request.getFirstValue() + " " + request.getFirstUnit() + " + " +
                request.getSecondValue() + " " + request.getSecondUnit(),
                finalResult);
        return finalResult;
    }

    public String subtract(OperationRequest request) {
        validateSameUnit(request.getFirstUnit(), request.getSecondUnit());
        double result = request.getFirstValue() - request.getSecondValue();
        String finalResult = result + " " + request.getFirstUnit();
        saveRecord(request, "SUBTRACT", finalResult);
        saveHistory(1L, "SUBTRACT",
                request.getFirstValue() + " " + request.getFirstUnit() + " - " +
                request.getSecondValue() + " " + request.getSecondUnit(),
                finalResult);
        return finalResult;
    }

    public String compare(OperationRequest request) {
        validateSameUnit(request.getFirstUnit(), request.getSecondUnit());
        String result;
        if (request.getFirstValue() > request.getSecondValue()) {
            result = "First value is greater";
        } else if (request.getFirstValue() < request.getSecondValue()) {
            result = "Second value is greater";
        } else {
            result = "Both values are equal";
        }

        saveRecord(request, "COMPARE", result);
        saveHistory(1L, "COMPARE",
                request.getFirstValue() + " " + request.getFirstUnit() + " compared with " +
                request.getSecondValue() + " " + request.getSecondUnit(),
                result);
        return result;
    }

    public String convert(ConvertRequest request) {
        double result;

        if (request.getFromUnit().equalsIgnoreCase("FEET") && request.getToUnit().equalsIgnoreCase("INCH")) {
            result = request.getValue() * 12;
        } else if (request.getFromUnit().equalsIgnoreCase("INCH") && request.getToUnit().equalsIgnoreCase("FEET")) {
            result = request.getValue() / 12;
        } else if (request.getFromUnit().equalsIgnoreCase("METER") && request.getToUnit().equalsIgnoreCase("CENTIMETER")) {
            result = request.getValue() * 100;
        } else if (request.getFromUnit().equalsIgnoreCase("CENTIMETER") && request.getToUnit().equalsIgnoreCase("METER")) {
            result = request.getValue() / 100;
        } else if (request.getFromUnit().equalsIgnoreCase(request.getToUnit())) {
            result = request.getValue();
        } else {
            throw new RuntimeException("Unsupported conversion");
        }

        String finalResult = result + " " + request.getToUnit();

        QuantityRecord record = new QuantityRecord();
        record.setFirstValue(request.getValue());
        record.setFirstUnit(request.getFromUnit());
        record.setSecondValue(null);
        record.setSecondUnit(request.getToUnit());
        record.setOperation("CONVERT");
        record.setResult(finalResult);
        record.setCreatedAt(LocalDateTime.now());
        quantityRecordRepository.save(record);

        saveHistory(1L, "CONVERT",
                request.getValue() + " " + request.getFromUnit() + " to " + request.getToUnit(),
                finalResult);

        return finalResult;
    }

    public List<QuantityRecord> getAllHistory() {
        return quantityRecordRepository.findAll();
    }

    private void validateSameUnit(String firstUnit, String secondUnit) {
        if (!firstUnit.equalsIgnoreCase(secondUnit)) {
            throw new RuntimeException("Units must be same for add, subtract, compare");
        }
    }

    private void saveRecord(OperationRequest request, String operation, String result) {
        QuantityRecord record = new QuantityRecord();
        record.setFirstValue(request.getFirstValue());
        record.setFirstUnit(request.getFirstUnit());
        record.setSecondValue(request.getSecondValue());
        record.setSecondUnit(request.getSecondUnit());
        record.setOperation(operation);
        record.setResult(result);
        record.setCreatedAt(LocalDateTime.now());
        quantityRecordRepository.save(record);
    }

    private void saveHistory(Long userId, String operationType, String expression, String result) {
        HistoryRequest request = new HistoryRequest();
        request.setUserId(userId);
        request.setOperationType(operationType);
        request.setExpression(expression);
        request.setResult(result);
        historyClient.saveHistory(request);
    }
}