package org.example.dsl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.json.LookupTable1Record;

import java.util.List;

/** dsl process step, counts elements provided in input */
@Slf4j
@Getter
@RequiredArgsConstructor
public class CountStep {
    private final List<LookupTable1Record> records;

    public int count(){
        log.info(records.size() + " records found");
        return records.size();
    }
}
