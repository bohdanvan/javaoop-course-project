package com.bvan.cp.sorting;

import java.util.Comparator;

/**
 * @author bvanchuhov
 */
public class CommonComparators {

    private CommonComparators() {}

    public static <T> Comparator<T> multiCriterion(Comparator<T>... comparators) {
        return new Comparator<T>() {
            @Override
            public int compare(T a, T b) {
                for (Comparator<T> comparator : comparators) {
                    int cmp = comparator.compare(a, b);
                    if (cmp != 0) {
                        return cmp;
                    }
                }
                return 0;
            }
        };
    }
}
