package com.qma.history.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qma.history.dto.HistoryRequest;
import com.qma.history.entity.HistoryRecord;
import com.qma.history.repository.HistoryRecordRepository;

@Service
public class HistoryService {

    private final HistoryRecordRepository historyRecordRepository;

    public HistoryService(HistoryRecordRepository historyRecordRepository) {
        this.historyRecordRepository = historyRecordRepository;
    }

    public HistoryRecord save(HistoryRequest request) {
        HistoryRecord record = new HistoryRecord();
        record.setUserId(request.getUserId());
        record.setOperationType(request.getOperationType());
        record.setExpression(request.getExpression());
        record.setResult(request.getResult());
        record.setTimestamp(LocalDateTime.now());
        return historyRecordRepository.save(record);
    }

    public List<HistoryRecord> getAll() {
        return historyRecordRepository.findAll();
    }

    public List<HistoryRecord> getByUserId(Long userId) {
        return historyRecordRepository.findByUserId(userId);
    }

    public void delete(Long id) {
        historyRecordRepository.deleteById(id);
    }
}