package org.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * residency enum based on input data
 */
@Getter
@AllArgsConstructor
public enum Residency {
    RESIDENT("Резидент РФ"),
    NOT_RESIDENT("Нерезидент РФ"),
    NOT_DEFINED("Не определен");

    private final String value;
}
