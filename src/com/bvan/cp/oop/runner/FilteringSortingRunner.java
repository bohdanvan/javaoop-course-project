package com.bvan.cp.oop.runner;

import com.bvan.cp.oop.film.Film;
import com.bvan.cp.oop.film.Films;

import static com.bvan.cp.oop.FilmComparators.byName;
import static com.bvan.cp.oop.FilmComparators.byReleaseYear;
import static com.bvan.cp.oop.film.FilmPredicates.containsInName;
import static com.bvan.cp.oop.film.FilmPredicates.withReleaseYearBetween;
import static com.bvan.cp.oop.film.Genre.*;
import static com.bvan.cp.oop.filter.AndPredicate.allOf;
import static com.bvan.cp.oop.sorting.CompositeComparator.multiCriterion;
import static java.util.Arrays.asList;
import static java.util.Collections.reverseOrder;

/**
 * @author bvanchuhov
 */
public class FilteringSortingRunner {

    public static void main(String[] args) {
        Films films = createFilms();

        films = films.filter(allOf(containsInName("a"), withReleaseYearBetween(2000, 2014)));
        films.sort(multiCriterion(reverseOrder(byReleaseYear()), byName()));

        System.out.println(films);
    }

    public static Films createFilms() {
        Films films = new Films();
        films.add(new Film.Builder()
                .name("Pulp Fiction")
                .releaseYear(1994)
                .genres(asList(THRILLER, COMEDY, CRIME))
                .build()
        );
        films.add(new Film.Builder()
                .name("Her")
                .releaseYear(2013)
                .genres(asList(ROMANCE, DRAMA, SCI_FI))
                .build()
        );
        films.add(new Film.Builder()
                .name("Captain Fantastic")
                .releaseYear(2016)
                .genres(asList(DRAMA, ROMANCE, COMEDY))
                .build()
        );
        return films;
    }
}
