package com.bvan.cp.oop.film.io.parser;

import com.bvan.cp.oop.film.Film;
import com.bvan.cp.oop.film.Genre;
import com.bvan.cp.oop.io.IllegalFormatException;
import com.bvan.cp.oop.io.parser.ListDsvParser;
import com.bvan.cp.oop.io.parser.Parser;

import java.util.List;

/**
 * Delimiter-separated values (DSV) film parser.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Delimiter-separated_values">Delimiter-separated values</a>
 * @author bvanchuhov
 */
public class FilmParser implements Parser<Film> {

    private final String valuesDelimiter;
    private final Parser<List<Genre>> genresParser;

    private final Parser<Integer> releaseYearParser = new ReleaseYearParser();

    public FilmParser(String valuesDelimiter, Parser<List<Genre>> genresParser) {
        this.valuesDelimiter = valuesDelimiter;
        this.genresParser = genresParser;
    }

    public FilmParser(String valuesDelimiter, String genresDelimiter) {
        this(valuesDelimiter, new ListDsvParser<>(genresDelimiter, new GenreParser()));
    }

    @Override
    public Film parse(String s) {
        String[] tokens = s.split(valuesDelimiter);
        if (tokens.length < 3) {
            throw new IllegalArgumentException("some values are missed: " + s);
        }

        return new Film.Builder()
                .name(tokens[0])
                .releaseYear(releaseYearParser.parse(tokens[1]))
                .genres(genresParser.parse(tokens[2]))
                .build();
    }

}
