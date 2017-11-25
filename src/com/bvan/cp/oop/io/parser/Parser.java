package com.bvan.cp.oop.io.parser;

import com.bvan.cp.oop.io.IllegalFormatException;

/**
 * @author bvanchuhov
 */
public interface Parser<T> {
    /**
     * @throws IllegalFormatException
     */
    T parse(String s);
}
