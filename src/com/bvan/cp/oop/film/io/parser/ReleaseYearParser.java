package com.bvan.cp.oop.film.io.parser;

import com.bvan.cp.oop.io.IllegalFormatException;
import com.bvan.cp.oop.io.parser.IntParser;
import com.bvan.cp.oop.io.parser.Parser;

/**
 * @author bvanchuhov
 */
public class ReleaseYearParser implements Parser<Integer> {

    @Override
    public Integer parse(String s) throws IllegalFormatException {
        int n = new IntParser().parse(s);
        if (!isReleaseYear(n)) {
            throw new IllegalFormatException("illegal release year: " + s);
        }
        return n;
    }

    private boolean isReleaseYear(int n) {
        return n >= 1870 && n <= 2050;
    }
}
