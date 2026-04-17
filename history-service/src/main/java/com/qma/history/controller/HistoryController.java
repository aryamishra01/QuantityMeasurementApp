package com.qma.history.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.qma.history.dto.HistoryRequest;
import com.qma.history.entity.HistoryRecord;
import com.qma.history.service.HistoryService;

@RestController
@RequestMapping("/history")
public class HistoryController {

    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @PostMapping
    public ResponseEntity<HistoryRecord> save(@Validated @RequestBody HistoryRequest request) {
        return ResponseEntity.ok(historyService.save(request));
    }

    @GetMapping
    public ResponseEntity<List<HistoryRecord>> getAll() {
        return ResponseEntity.ok(historyService.getAll());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<HistoryRecord>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(historyService.getByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        historyService.delete(id);
        return ResponseEntity.ok("History deleted successfully");
    }
}