package com.qma.quantity.controller;

import com.qma.quantity.dto.ConvertRequest;
import com.qma.quantity.dto.OperationRequest;
import com.qma.quantity.entity.QuantityRecord;
import com.qma.quantity.service.QuantityService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quantity")
public class QuantityController {

    private final QuantityService quantityService;

    public QuantityController(QuantityService quantityService) {
        this.quantityService = quantityService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@Valid @RequestBody OperationRequest request) {
        return ResponseEntity.ok(quantityService.add(request));
    }

    @PostMapping("/subtract")
    public ResponseEntity<String> subtract(@Valid @RequestBody OperationRequest request) {
        return ResponseEntity.ok(quantityService.subtract(request));
    }

    @PostMapping("/compare")
    public ResponseEntity<String> compare(@Valid @RequestBody OperationRequest request) {
        return ResponseEntity.ok(quantityService.compare(request));
    }

    @PostMapping("/convert")
    public ResponseEntity<String> convert(@Valid @RequestBody ConvertRequest request) {
        return ResponseEntity.ok(quantityService.convert(request));
    }

    @GetMapping("/history")
    public ResponseEntity<List<QuantityRecord>> history() {
        return ResponseEntity.ok(quantityService.getAllHistory());
    }
}