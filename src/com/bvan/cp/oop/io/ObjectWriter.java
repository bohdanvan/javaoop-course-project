package com.bvan.cp.oop.io;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author bvanchuhov
 */
public interface ObjectWriter<T> extends Closeable {
    void write(T val) throws IOException;
}
