package com.bvan.cp.oop.io;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author bvanchuhov
 */
public interface ObjectReader<T> extends Closeable {
    T read() throws IOException, IllegalFormatException;
}
