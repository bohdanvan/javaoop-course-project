package com.bvan.cp.oop.film.io;

import com.bvan.cp.oop.film.Film;
import com.bvan.cp.oop.film.Films;
import com.bvan.cp.oop.io.IllegalFormatException;
import com.bvan.cp.oop.io.ObjectReader;
import com.bvan.cp.oop.io.parser.Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author bvanchuhov
 */
public class FilmsTextReader implements ObjectReader<Films> {

    private final BufferedReader reader;
    private final Parser<Film> filmParser;

    public FilmsTextReader(BufferedReader reader, Parser<Film> filmParser) {
        this.reader = reader;
        this.filmParser = filmParser;
    }

    public FilmsTextReader(Reader reader, Parser<Film> filmParser) {
        this(new BufferedReader(reader), filmParser);
    }

    @Override
    public Films read() throws IOException, IllegalFormatException {
        Films films = new Films();

        String line;
        while ((line = reader.readLine()) != null) {
            Film film = filmParser.parse(line);
            films.add(film);
        }

        return films;
    }

    @Override
    public void close() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }
}
