package org.example.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InnLength {
    INDIVIDUAL_INTERPRENEUR(12),
    LEGAL_ENTITY(10);
    
    private final int length;
}
