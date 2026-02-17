package org.example.validator;

/**
 * element validator contract, returns true if valid, throws exception if not
 * @param <T> validated element class
 */
public interface Validator<T> {
    boolean validate(T value);
}
