package org.example.validator;

import org.example.enums.Region;
import org.example.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * region parameter validator for both single element and iteration, throws ValidationException if not valid, checks all elements, not just first invalid
 */
@Component
public class RegionValidator implements Validator<String>, IterableValidator<String> {
    @Override
    public boolean validate(String value) {
        boolean result = Region.getAllCodes().contains(value);
        if (result) {
            return result;
        } else {
            throw new ValidationException("Region is not valid, valid values are: " + Region.getAllCodes());
        }
    }

    @Override
    public boolean validate(Iterable<String> value) {
        List<String> invalidCodes = new ArrayList<>();

        for (String code : value) {
            if (!Region.getAllCodes().contains(code)) {
                invalidCodes.add(code);
            }
        }

        if (invalidCodes.isEmpty()) {
            return true;
        } else {
            throw new ValidationException("Regions "+ invalidCodes + " is not valid, valid values are: " + Region.getAllCodes());
        }
    }
}
