package com.bvan.cp.oop.film;

import com.bvan.cp.oop.filter.Predicate;

import java.io.Serializable;
import java.util.*;

/**
 * @author bvanchuhov
 */
public class Films implements Iterable<Film>, Serializable {

    private final List<Film> films = new ArrayList<>();

    public void add(Film film) {
        films.add(film);
    }

    public Films filter(Predicate<Film> predicate) {
        Films res = new Films();

        for (Film film : films) {
            if (predicate.apply(film)) {
                res.add(film);
            }
        }

        return res;
    }

    public void sort(Comparator<Film> comparator) {
        Collections.sort(films, comparator);
    }

    @Override
    public Iterator<Film> iterator() {
        return films.iterator();
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        for (Film film : films) {
            joiner.add(film.toString());
        }
        return "Films:\n" + joiner.toString();
    }
}
