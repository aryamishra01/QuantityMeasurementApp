package com.qma.quantity.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "quantity_records")
@Getter
@Setter
public class QuantityRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_val")
    private Double firstValue;

    @Column(name = "first_unit")
    private String firstUnit;

    @Column(name = "second_val")
    private Double secondValue;

    @Column(name = "second_unit")
    private String secondUnit;

    private String operation;

    private String result;

    private LocalDateTime createdAt;
}