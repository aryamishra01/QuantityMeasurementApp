package com.qma.quantity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConvertRequest {

    @NotNull
    private Double value;

    @NotBlank
    private String fromUnit;

    @NotBlank
    private String toUnit;
}