package com.bvan.cp.oop.io;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author bvanchuhov
 */
public interface ObjectReader<T> extends Closeable {
    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    T read() throws IOException;
}
