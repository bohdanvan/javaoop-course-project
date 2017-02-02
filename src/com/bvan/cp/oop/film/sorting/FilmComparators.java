package com.bvan.cp.oop.film.sorting;

import com.bvan.cp.oop.film.Film;
import java.util.Comparator;

/**
 * @author bvanchuhov
 */
public class FilmComparators {

    private FilmComparators() {}

    public static Comparator<Film> byId() {
        return new Comparator<Film>() {
            @Override
            public int compare(Film a, Film b) {
                return Long.compare(a.getId(), b.getId());
            }
        };
    }

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
