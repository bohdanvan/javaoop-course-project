package com.bvan.cp.oop.film.io;

import com.bvan.cp.oop.film.Film;
import com.bvan.cp.oop.film.Films;
import com.bvan.cp.oop.io.ObjectWriter;
import com.bvan.cp.oop.io.StringConverter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * @author bvanchuhov
 */
public class FilmsTextWriter implements ObjectWriter<Films> {

    private final PrintWriter writer;
    private final StringConverter<Film> filmConverter;

    public FilmsTextWriter(PrintWriter writer, StringConverter<Film> filmConverter) {
        this.writer = writer;
        this.filmConverter = filmConverter;
    }

    public FilmsTextWriter(Writer writer, StringConverter<Film> filmConverter) {
        this(new PrintWriter(writer), filmConverter);
    }

    @Override
    public void write(Films films) {
        for (Film film : films) {
            String s = filmConverter.toString(film);
            writer.println(s);
        }
    }

    @Override
    public void close() throws IOException {
        if (writer != null) {
            writer.close();
        }
    }
}
