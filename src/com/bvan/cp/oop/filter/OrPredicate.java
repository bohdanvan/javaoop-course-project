package com.bvan.cp.oop.filter;

import java.util.Arrays;
import java.util.List;

/**
 * @author bvanchuhov
 */
public class OrPredicate<T> implements Predicate<T> {

    private final List<Predicate<T>> predicates;

    public static <T> Predicate<T> oneOf(Predicate<T>... predicates) {
        return new OrPredicate<T>(predicates);
    }

    public OrPredicate(List<Predicate<T>> predicates) {
        this.predicates = predicates;
    }

    public OrPredicate(Predicate<T>... predicates) {
        this(Arrays.asList(predicates));
    }

    @Override
    public boolean apply(T elem) {
        for (Predicate<T> predicate : predicates) {
            if (predicate.apply(elem)) {
                return true;
            }
        }
        return false;
    }
}
