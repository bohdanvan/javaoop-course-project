package com.bvan.cp.filtering;

/**
 * @author bvanchuhov
 */
public interface Predicate<T> {
    boolean apply(T elem);
}
