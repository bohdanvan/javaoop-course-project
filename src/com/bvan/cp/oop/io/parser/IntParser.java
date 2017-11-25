package com.bvan.cp.oop.io.parser;

import com.bvan.cp.oop.io.IllegalFormatException;

/**
 * @author bvanchuhov
 */
public class IntParser implements Parser<Integer> {

    @Override
    public Integer parse(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalFormatException("can't parse string to int: " + s, e);
        }
    }
}
