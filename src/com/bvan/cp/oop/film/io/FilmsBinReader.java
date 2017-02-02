package com.bvan.cp.oop.film.io;

import com.bvan.cp.oop.film.Films;
import com.bvan.cp.oop.io.IllegalFormatException;
import com.bvan.cp.oop.io.ObjectReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

/**
 * @author bvanchuhov
 */
public class FilmsBinReader implements ObjectReader<Films> {

    private final ObjectInput objectInput;

    public FilmsBinReader(ObjectInput objectInput) {
        this.objectInput = objectInput;
    }

    public FilmsBinReader(InputStream inputStream) throws IOException {
        this((ObjectInput) new ObjectInputStream(inputStream));
    }

    @Override
    public Films read() throws IOException, IllegalFormatException {
        try {
            return (Films) objectInput.readObject();
        } catch (ClassNotFoundException e) {
            throw new IllegalFormatException("Films class cannot be found", e);
        }
    }

    @Override
    public void close() throws IOException {
        if (objectInput != null) {
            objectInput.close();
        }
    }
}
