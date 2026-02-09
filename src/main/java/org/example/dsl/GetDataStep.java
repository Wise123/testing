package org.example.dsl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.json.LookupTable1;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Getter
@RequiredArgsConstructor
public class GetDataStep {
    private final String lookupUrl;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public FilterActiveRecordsStep getData(){
        try {
            String rawData = restTemplate.getForObject(lookupUrl, String.class);
            LookupTable1 data = objectMapper.readValue(rawData, LookupTable1.class);

//            log.info(data.toString());
            return new FilterActiveRecordsStep(data.getRecords());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
