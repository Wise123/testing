package org.example.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.example.enums.Residency;
import org.example.model.json.LookupTable1Record;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import static org.example.enums.InnLength.LEGAL_ENTITY;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {

    /**
     * checks is record active by it's block date? empty value means active
     * @param item record
     * @return true if active
     */
    public static boolean isRecordActive(LookupTable1Record item) {
        boolean result = StringUtils.isEmpty(item.getBlockDate());
        return result;
    }

    /**
     * checks is record is residential
     * @param item record
     * @return true if resident
     */
    public static boolean isResident(LookupTable1Record item) {
        return Objects.equals(item.getResidence(), Residency.RESIDENT.getValue());
    }

    /**
     * checks is record not IP
     * @param item record
     * @return true if NOT enterpreneur
     */
    public static boolean isRecordIsNotIndividualEnterpreneur(LookupTable1Record item) {
            return item.getInn() != null && item.getInn().length() == LEGAL_ENTITY.getLength();
    }

    /**
     * generates predicate which checks region by first two letters of INN
     * @param regionNumbers numbers to filter
     * @return predicate
     */
    public static Predicate<LookupTable1Record> getRegionFilterPredicate(List<String> regionNumbers) {
        return (item) -> {
            try {
                String regionFromInn = item.getInn().substring(0, 2);
//                log.info(regionFromInn);
            return regionNumbers.contains(regionFromInn);
            } catch (Exception e) {
                log.info(item.toString());
                return false;
            }
        };
    }
}
