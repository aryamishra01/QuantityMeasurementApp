package com.qma.quantity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistoryRequest {
    private Long userId;
    private String operationType;
    private String expression;
    private String result;
}