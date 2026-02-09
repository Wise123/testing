package org.example.dsl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.json.LookupTable1;
import org.example.model.json.LookupTable1Record;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GetDataStepTest {
    String lookupUrl = "test";
    RestTemplate restTemplate = mock(RestTemplate.class);
    ObjectMapper objectMapper = mock(ObjectMapper.class);

    GetDataStep getDataStep = new GetDataStep(lookupUrl, restTemplate, objectMapper);

    @Test
    public void getData() throws JsonProcessingException {
        LookupTable1 data = LookupTable1.builder()
                .result("OK")
                .records(List.of())
                .build();

        when(restTemplate.getForObject(anyString(), any(Class.class)))
                .thenReturn("test");
        when(objectMapper.readValue(anyString(), any(Class.class))).thenReturn(data);
        FilterActiveRecordsStep result = getDataStep.getData();
        assertEquals(0, result.getRecords().size());
    }

    @Test
    public void getDataJsonProcessingException() throws JsonProcessingException {
        LookupTable1 data = LookupTable1.builder()
                .result("OK")
                .records(List.of())
                .build();

        when(restTemplate.getForObject(anyString(), any(Class.class)))
                .thenReturn("test");
        when(objectMapper.readValue(anyString(), any(Class.class))).thenThrow(JsonProcessingException.class);
        assertThrows(RuntimeException.class, () -> getDataStep.getData());
    }

}