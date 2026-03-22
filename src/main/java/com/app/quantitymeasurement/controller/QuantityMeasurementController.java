package com.app.quantitymeasurement.controller;

import com.app.quantitymeasurement.dto.CompareRequestDTO;
import com.app.quantitymeasurement.dto.QuantityDTO;
import com.app.quantitymeasurement.service.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quantity")
public class QuantityMeasurementController {

    @Autowired
    private IQuantityMeasurementService service;

    @GetMapping("/hello")
    public String hello() {
        return "Spring Boot Working ";
    }

    // ✅ Compare
    @PostMapping("/compare")
    public QuantityDTO compare(@RequestBody CompareRequestDTO request) {
        return service.compare(request.getQ1(), request.getQ2());
    }

    // ✅ Convert
    @PostMapping("/convert")
    public QuantityDTO convert(@RequestBody QuantityDTO source,
                               @RequestParam String targetUnit) {
        return service.convert(source, targetUnit);
    }

    // ✅ Add
    @PostMapping("/add")
    public QuantityDTO add(@RequestBody CompareRequestDTO request) {
        return service.add(request.getQ1(), request.getQ2());
    }

    // ✅ Subtract
    @PostMapping("/subtract")
    public QuantityDTO subtract(@RequestBody CompareRequestDTO request) {
        return service.subtract(request.getQ1(), request.getQ2());
    }

    // ✅ Divide
    @PostMapping("/divide")
    public QuantityDTO divide(@RequestBody CompareRequestDTO request) {
        return service.divide(request.getQ1(), request.getQ2());
    }
}