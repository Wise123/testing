package org.example.service.lookup;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dsl.GetDataStep;
import org.example.model.json.LookupTable1Record;
import org.example.utils.Utils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class LookupServiceBasicImpl implements LookupService{
    @Value("${config.url.lookup}")
    private final String lookupUrl;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public int count(int[] regionNumbers) {
        return new GetDataStep(lookupUrl, restTemplate, objectMapper)
                .getData()
                .filterActiveRecords(Utils::isRecordActive)
                .filterExcludingIndividualEntrepreneurs(Utils::isRecordIsNotIndividualEnterpreneur)
                .filterRegion(Utils.getRegionFilterPredicate(regionNumbers))
                .count();
    }
}
