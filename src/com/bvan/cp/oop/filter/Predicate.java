package com.bvan.cp.oop.filter;

/**
 * @author bvanchuhov
 */
public interface Predicate<T> {
    boolean apply(T elem);
}
