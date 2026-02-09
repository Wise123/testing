package org.example.dsl;

import org.example.model.json.LookupTable1Record;
import org.example.utils.Utils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterExcludingIndividualEntrepreneursStepTest {
    LookupTable1Record ipRecord = LookupTable1Record.builder()
            .inn("0000000000")
            .build();

    LookupTable1Record oooRecord = LookupTable1Record.builder()
            .inn("000000000000")
            .build();

    FilterExcludingIndividualEntrepreneursStep step = new FilterExcludingIndividualEntrepreneursStep(
            List.of(ipRecord, oooRecord)
    );

    @Test
    public void filterExcludingIndividualEntrepreneurs() {

        var result = step.filterExcludingIndividualEntrepreneurs(Utils::isRecordIsNotIndividualEnterpreneur);

        assertEquals(1, result.getRecords().size());
    }
}