package com.qma.quantity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qma.quantity.entity.QuantityRecord;

public interface QuantityRecordRepository extends JpaRepository<QuantityRecord, Long> {
}