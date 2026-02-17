package org.example.validator;

/**
 * iterable validator contract, returns true if valid, throws exception if not
 * @param <T> validated element class
 */
public interface IterableValidator<T> {
    boolean validate(Iterable<T> value);
}
