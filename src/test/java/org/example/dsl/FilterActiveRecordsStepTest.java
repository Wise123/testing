package org.example.dsl;

import org.example.model.json.LookupTable1Record;
import org.example.utils.Utils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterActiveRecordsStepTest {
    LookupTable1Record activeRecord = LookupTable1Record.builder()
            .blockDate("")
            .build();

    LookupTable1Record inactiveRecord = LookupTable1Record.builder()
            .blockDate("any nonempty string")
            .build();

    FilterActiveRecordsStep filterActiveRecordsStep = new FilterActiveRecordsStep(
            List.of(activeRecord, inactiveRecord)
    );

    @Test
    public void filterActiveRecords() {

        var result = filterActiveRecordsStep.filterActiveRecords(Utils::isRecordActive);

        assertEquals(1, result.getRecords().size());
    }

}