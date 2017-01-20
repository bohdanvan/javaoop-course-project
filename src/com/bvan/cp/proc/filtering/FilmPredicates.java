package com.bvan.cp.proc.filtering;

import com.bvan.cp.proc.entity.Film;

/**
 * @author bvanchuhov
 */
public class FilmPredicates {

    private FilmPredicates() {}

    public static Predicate<Film> containsInName(String nameSubstring) {
        return new Predicate<Film>() {
            @Override
            public boolean apply(Film elem) {
                return elem.getName().toLowerCase().contains(nameSubstring.toLowerCase());
            }
        };
    }

    public static Predicate<Film> withReleaseYearBetween(int minYear, int maxYear) {
        return new Predicate<Film>() {
            @Override
            public boolean apply(Film elem) {
                return elem.getReleaseYear() >= minYear && elem.getReleaseYear() <= maxYear;
            }
        };
    }
}
