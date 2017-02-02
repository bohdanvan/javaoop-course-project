package com.bvan.cp.oop.io.parser;

import com.bvan.cp.oop.io.IllegalFormatException;

/**
 * @author bvanchuhov
 */
public interface Parser<T> {
    T parse(String s) throws IllegalFormatException;
}
