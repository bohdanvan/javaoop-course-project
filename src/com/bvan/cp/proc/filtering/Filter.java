package com.bvan.cp.proc.filtering;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bvanchuhov
 */
public class Filter {

    private Filter() {}

    public static <T> List<T> filter(List<T> elems, Predicate<T> predicate) {
        List<T> res = new ArrayList<>();

        for (T elem : elems) {
            if (predicate.apply(elem)) {
                res.add(elem);
            }
        }

        return res;
    }
}
