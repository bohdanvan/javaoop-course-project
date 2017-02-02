package com.bvan.cp.oop.filter;

import java.util.Arrays;
import java.util.List;

/**
 * @author bvanchuhov
 */
public class AndPredicate<T> implements Predicate<T> {

    private final List<Predicate<T>> predicates;

    public static <T> Predicate<T> allOf(Predicate<T>... predicates) {
        return new AndPredicate<>(predicates);
    }

    public AndPredicate(List<Predicate<T>> predicates) {
        this.predicates = predicates;
    }

    public AndPredicate(Predicate<T>... predicates) {
        this(Arrays.asList(predicates));
    }

    @Override
    public boolean apply(T elem) {
        for (Predicate<T> predicate : predicates) {
            if (!predicate.apply(elem)) {
                return false;
            }
        }
        return true;
    }
}
