package org.example.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * inn length enum
 */
@Getter
@RequiredArgsConstructor
public enum InnLength {
    /** matches with physical entities, so two symbols longer than legal entity */
    INDIVIDUAL_INTERPRENEUR(12),
    /** legal entity inn length */
    LEGAL_ENTITY(10);
    
    private final int length;
}
