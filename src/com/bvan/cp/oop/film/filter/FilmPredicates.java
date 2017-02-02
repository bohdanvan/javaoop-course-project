package com.bvan.cp.oop.film.filter;

import com.bvan.cp.oop.film.Film;
import com.bvan.cp.oop.filter.Predicate;

/**
 * @author bvanchuhov
 */
public class FilmPredicates {

    private FilmPredicates() {}

    public static Predicate<Film> withId(final long id) {
        return new Predicate<Film>() {
            @Override
            public boolean apply(Film elem) {
                return elem.getId() == id;
            }
        };
    }

    public static Predicate<Film> containsInName(final String nameSubstring) {
        return new Predicate<Film>() {
            @Override
            public boolean apply(Film elem) {
                return elem.getName().toLowerCase().contains(nameSubstring.toLowerCase());
            }
        };
    }

    public static Predicate<Film> withReleaseYearBetween(final int minYear, final int maxYear) {
        return new Predicate<Film>() {
            @Override
            public boolean apply(Film elem) {
                return elem.getReleaseYear() >= minYear && elem.getReleaseYear() <= maxYear;
            }
        };
    }
}
