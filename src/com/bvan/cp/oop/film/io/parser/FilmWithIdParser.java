package com.bvan.cp.oop.film.io.parser;

import com.bvan.cp.oop.film.Film;
import com.bvan.cp.oop.film.Genre;
import com.bvan.cp.oop.io.IllegalFormatException;
import com.bvan.cp.oop.io.parser.LongParser;
import com.bvan.cp.oop.io.parser.Parser;

import java.util.List;

/**
 * @author bvanchuhov
 */
public class FilmWithIdParser implements Parser<Film> {

    private final String valuesDelimiter;
    private final Parser<Film> filmParser;

    private final Parser<Long> idParser = new LongParser();

    public FilmWithIdParser(String valuesDelimiter, Parser<List<Genre>> genresParser) {
        this.valuesDelimiter = valuesDelimiter;
        this.filmParser = new FilmParser(valuesDelimiter, genresParser);
    }

    public FilmWithIdParser(String valuesDelimiter, String genresDelimiter) {
        this.valuesDelimiter = valuesDelimiter;
        this.filmParser = new FilmParser(valuesDelimiter, genresDelimiter);
    }

    @Override
    public Film parse(String s) {
        int firstDelimiterIndex = s.indexOf(valuesDelimiter);
        if (firstDelimiterIndex < 0 || firstDelimiterIndex == s.length() - 1) {
            throw new IllegalFormatException("some values are missed: " + s);
        }

        long id = idParser.parse(s.substring(0, firstDelimiterIndex));
        Film film = filmParser.parse(s.substring(firstDelimiterIndex + 1));

        return new Film.Builder()
                .id(id)
                .name(film.getName())
                .releaseYear(film.getReleaseYear())
                .genres(film.getGenres())
                .build();
    }
}
