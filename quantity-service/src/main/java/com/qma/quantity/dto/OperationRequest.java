package com.qma.quantity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationRequest {

    @NotNull
    private Double firstValue;

    @NotBlank
    private String firstUnit;

    @NotNull
    private Double secondValue;

    @NotBlank
    private String secondUnit;
}