package org.example.dsl;

import org.example.model.json.LookupTable1Record;
import org.example.utils.Utils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterRegionStepTest {
    LookupTable1Record region1Record = LookupTable1Record.builder()
            .inn("0100000000")
            .build();

    LookupTable1Record region2Record = LookupTable1Record.builder()
            .inn("0200000000")
            .build();

    FilterRegionStep step = new FilterRegionStep(
            List.of(region1Record, region2Record)
    );

    @Test
    public void filterRegion() {

        var result = step.filterRegion(Utils.getRegionFilterPredicate(new int[]{1}));

        assertEquals(1, result.getRecords().size());
    }
}