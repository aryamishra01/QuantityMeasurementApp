package com.qma.history.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistoryRequest {

    @NotNull
    private Long userId;

    @NotBlank
    private String operationType;

    @NotBlank
    private String expression;

    @NotBlank
    private String result;
}