package com.bvan.cp.proc.filtering;

/**
 * @author bvanchuhov
 */
public class CommonPredicates {

    private CommonPredicates() {}

    /**
     * Logical AND.
     */
    public static <T> Predicate<T> allOf(Predicate<T>... predicates) {
        return new Predicate<T>() {
            @Override
            public boolean apply(T elem) {
                for (Predicate<T> predicate : predicates) {
                    if (!predicate.apply(elem)) {
                        return false;
                    }
                }
                return true;
            }
        };
    }
}
