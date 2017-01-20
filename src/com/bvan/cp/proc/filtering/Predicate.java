package com.bvan.cp.proc.filtering;

/**
 * @author bvanchuhov
 */
public interface Predicate<T> {
    boolean apply(T elem);
}
