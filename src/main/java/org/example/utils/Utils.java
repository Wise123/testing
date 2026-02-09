package org.example.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.model.json.LookupTable1Record;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

import static org.example.enums.InnLength.LEGAL_ENTITY;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {

    public static boolean isRecordActive(LookupTable1Record item) {
        return !Objects.equals(item.getBlockDate(), "");
    }

    public static boolean isRecordIsNotIndividualEnterpreneur(LookupTable1Record item) {
        return item.getInn() != null && item.getInn().length() == LEGAL_ENTITY.getLength();
    }

    public static Predicate<LookupTable1Record> getRegionFilterPredicate(int[] regionNumbers) {
        return (item) -> {
            int regionFromInn = Integer.parseInt(item.getInn().substring(0, 2));
            return Arrays.stream(regionNumbers).anyMatch(region -> region == regionFromInn);
        };
    }
}
