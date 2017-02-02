package com.bvan.cp.oop.io.parser;

import com.bvan.cp.oop.io.IllegalFormatException;

/**
 * @author bvanchuhov
 */
public class LongParser implements Parser<Long> {

    @Override
    public Long parse(String s) throws IllegalFormatException {
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException e) {
            throw new IllegalFormatException("can't parse string to long: " + s, e);
        }
    }
}
