package org.example.dsl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.json.LookupTable1Record;

import java.util.List;

@Slf4j
@Getter
@RequiredArgsConstructor
public class CountStep {
    private final List<LookupTable1Record> records;

    public int count(){
        return records.size();
    }
}
