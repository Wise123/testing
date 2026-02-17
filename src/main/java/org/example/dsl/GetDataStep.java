package org.example.dsl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.json.LookupTable1;
import org.springframework.web.client.RestTemplate;

/** dsl process step, requests data to process */
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

            log.info(data.getRecords().size() + " records found");
            return new FilterActiveRecordsStep(data.getRecords());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
