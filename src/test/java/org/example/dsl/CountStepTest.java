package org.example.dsl;

import org.example.model.json.LookupTable1Record;
import org.example.utils.Utils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountStepTest {
    LookupTable1Record record = LookupTable1Record.builder()
            .build();

    CountStep step = new CountStep(
            List.of(record)
    );

    @Test
    public void filterRegion() {

        int result = step.count();

        assertEquals(1, result);
    }
}