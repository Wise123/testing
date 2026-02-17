package org.example.dsl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.json.LookupTable1Record;

import java.util.List;
import java.util.function.Predicate;

/** dsl process step, filters active records, strategy is moved to predicate in order to allow customization */
@Slf4j
@Getter
@RequiredArgsConstructor
public class FilterActiveRecordsStep {
    private final List<LookupTable1Record> records;

    public FilterResidentsStep filterActiveRecords(Predicate<LookupTable1Record> filter) {
        List<LookupTable1Record> result = records.stream()
                .filter(filter)
                .toList();

        log.info(result.size() + " records found");
        return new FilterResidentsStep(result);
    }
}
