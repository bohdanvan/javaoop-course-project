package com.bvan.cp.oop.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author bvanchuhov
 */
public class CompositeComparator<T> implements Comparator<T> {

    private final List<Comparator<T>> comparators;

    public static <T> Comparator<T> multiCriterion(Comparator<T>... comparators) {
        return new CompositeComparator<T>(comparators);
    }

    public CompositeComparator(List<Comparator<T>> comparators) {
        this.comparators = comparators;
    }

    public CompositeComparator(Comparator<T>... comparators) {
        this(Arrays.asList(comparators));
    }

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
}
