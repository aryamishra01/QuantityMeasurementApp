package com.qma.history.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qma.history.entity.HistoryRecord;

public interface HistoryRecordRepository extends JpaRepository<HistoryRecord, Long> {
    List<HistoryRecord> findByUserId(Long userId);
}