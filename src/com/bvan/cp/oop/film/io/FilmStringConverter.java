package com.bvan.cp.oop.film.io;

import com.bvan.cp.common.Joiner;
import com.bvan.cp.oop.film.Film;
import com.bvan.cp.oop.io.StringConverter;

/**
 * @author bvanchuhov
 */
public class FilmStringConverter implements StringConverter<Film> {

    private final String valuesDelimiter;
    private final String genresDelimiter;

    public FilmStringConverter(String valuesDelimiter, String genresDelimiter) {
        this.valuesDelimiter = valuesDelimiter;
        this.genresDelimiter = genresDelimiter;
    }

    @Override
    public String toString(Film film) {
        return new Joiner(valuesDelimiter).join(
                film.getId(),
                film.getName(),
                film.getReleaseYear(),
                new Joiner(genresDelimiter).join(film.getGenres().toArray())
        );
    }
}
