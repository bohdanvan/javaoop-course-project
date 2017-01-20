package com.bvan.cp.proc.sorting;

import com.bvan.cp.proc.entity.Film;

import java.util.Comparator;

/**
 * @author bvanchuhov
 */
public class FilmComparators {

    private FilmComparators() {}

    public static Comparator<Film> byReleaseYear() {
        return new Comparator<Film>() {
            @Override
            public int compare(Film a, Film b) {
                return Integer.compare(a.getReleaseYear(), b.getReleaseYear());
            }
        };
    }

    public static Comparator<Film> byName() {
        return new Comparator<Film>() {
            @Override
            public int compare(Film a, Film b) {
                return a.getName().compareTo(b.getName());
            }
        };
    }
}
