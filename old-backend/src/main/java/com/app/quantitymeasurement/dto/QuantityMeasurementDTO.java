package com.app.quantitymeasurement.dto;

import com.app.quantitymeasurement.model.QuantityMeasurementEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuantityMeasurementDTO {

    private Long id;
    private double thisValue;
    private String thisUnit;
    private String thisMeasurementType;
    private double thatValue;
    private String thatUnit;
    private String thatMeasurementType;
    private String operation;
    private String resultValue;
    private String resultUnit;
    private String errorMessage;
    private boolean error;
    private LocalDateTime createdAt;

    // Entity → DTO
    public static QuantityMeasurementDTO fromEntity(QuantityMeasurementEntity entity) {
        return QuantityMeasurementDTO.builder()
                .id(entity.getId())
                .thisValue(entity.getThisValue())
                .thisUnit(entity.getThisUnit())
                .thisMeasurementType(entity.getThisMeasurementType())
                .thatValue(entity.getThatValue())
                .thatUnit(entity.getThatUnit())
                .thatMeasurementType(entity.getThatMeasurementType())
                .operation(entity.getOperation())
                .resultValue(entity.getResultValue())
                .resultUnit(entity.getResultUnit())
                .errorMessage(entity.getErrorMessage())
                .error(entity.isError())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    // DTO → Entity (BEST PRACTICE: don't set id & createdAt)
    public QuantityMeasurementEntity toEntity() {
        QuantityMeasurementEntity entity = new QuantityMeasurementEntity();
        entity.setThisValue(this.thisValue);
        entity.setThisUnit(this.thisUnit);
        entity.setThisMeasurementType(this.thisMeasurementType);
        entity.setThatValue(this.thatValue);
        entity.setThatUnit(this.thatUnit);
        entity.setThatMeasurementType(this.thatMeasurementType);
        entity.setOperation(this.operation);
        entity.setResultValue(this.resultValue);
        entity.setResultUnit(this.resultUnit);
        entity.setErrorMessage(this.errorMessage);
        entity.setError(this.error);
        return entity;
    }

    // List<Entity> → List<DTO>
    public static List<QuantityMeasurementDTO> fromEntityList(List<QuantityMeasurementEntity> entities) {
        return entities.stream()
                .map(QuantityMeasurementDTO::fromEntity)
                .collect(Collectors.toList());
    }
}