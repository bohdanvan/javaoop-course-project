package com.bvan.cp.oop.film.io;

import com.bvan.cp.oop.film.Films;
import com.bvan.cp.oop.io.ObjectWriter;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * @author bvanchuhov
 */
public class FilmsBinWriter implements ObjectWriter<Films> {

    private final ObjectOutput objectOutput;

    public FilmsBinWriter(ObjectOutput objectOutput) {
        this.objectOutput = objectOutput;
    }

    public FilmsBinWriter(OutputStream outputStream) throws IOException {
        this((ObjectOutput) new ObjectOutputStream(outputStream));
    }

    @Override
    public void write(Films films) throws IOException {
        objectOutput.writeObject(films);
    }

    @Override
    public void close() throws IOException {
        if (objectOutput != null) {
            objectOutput.close();
        }
    }
}
