package com.bvan.cp.common;

import java.util.List;

/**
 * @author bvanchuhov
 */
public class CommonUtils {

    private CommonUtils() {}

    public static <E> void printList(List<E> list) {
        for (E elem : list) {
            System.out.println(elem);
        }
    }
}
