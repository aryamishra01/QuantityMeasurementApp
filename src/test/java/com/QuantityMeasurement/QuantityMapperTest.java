package com.QuantityMeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.QuantityMeasurement.dto.QuantityDTO;
import com.QuantityMeasurement.dto.QuantityMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.QuantityMeasurement.units.LengthUnit;
import com.QuantityMeasurement.Quantity;

public class QuantityMapperTest {

    @Test
    void testDtoJsonSerialization() throws Exception {
        QuantityDTO dto = new QuantityDTO(12.5, "FEET", "LENGTH");
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(dto);
        assertNotNull(json);
        assertTrue(json.contains("FEET"));
        assertTrue(json.contains("LENGTH"));

        QuantityDTO round = mapper.readValue(json, QuantityDTO.class);
        assertEquals(dto.getValue(), round.getValue());
        assertEquals(dto.getUnit(), round.getUnit());
        assertEquals(dto.getMeasurementType(), round.getMeasurementType());
    }

    @Test
    void testMapperToAndFromQuantity() {
        QuantityDTO dto = new QuantityDTO(2.0, "FEET", "LENGTH");
        Quantity<?> q = QuantityMapper.toQuantity(dto);
        assertNotNull(q);
        assertEquals(2.0, q.getValue());
        assertEquals(LengthUnit.FEET, q.getUnit());

        QuantityDTO back = QuantityMapper.fromQuantity(q);
        assertEquals(dto.getValue(), back.getValue());
        assertEquals(dto.getUnit(), back.getUnit());
        assertEquals(dto.getMeasurementType(), back.getMeasurementType());
    }
}