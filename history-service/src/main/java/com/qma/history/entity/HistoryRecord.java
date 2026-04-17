package com.qma.history.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "history_records")
@Getter
@Setter
public class HistoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String operationType;

    @Column(length = 500)
    private String expression;

    private String result;

    private LocalDateTime timestamp;
}