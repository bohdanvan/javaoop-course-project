package com.bvan.cp.runner;

import com.bvan.cp.entity.Film;

import java.util.ArrayList;
import java.util.List;

import static com.bvan.cp.common.CommonUtils.printList;
import static com.bvan.cp.entity.Genre.*;
import static com.bvan.cp.filtering.CommonPredicates.allOf;
import static com.bvan.cp.filtering.FilmPredicates.containsInName;
import static com.bvan.cp.filtering.FilmPredicates.withReleaseYearBetween;
import static com.bvan.cp.filtering.Filter.filter;
import static com.bvan.cp.sorting.CommonComparators.multiCriterion;
import static com.bvan.cp.sorting.FilmComparators.byName;
import static com.bvan.cp.sorting.FilmComparators.byReleaseYear;
import static java.util.Arrays.asList;
import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;

/**
 * @author bvanchuhov
 */
public class FilteringSortingRunner {

    public static void main(String[] args) {
        List<Film> films = createFilms();

        films = filter(films, allOf(containsInName("a"), withReleaseYearBetween(2000, 2014)));
        sort(films, multiCriterion(reverseOrder(byReleaseYear()), byName()));

        printList(films);
    }

    public static List<Film> createFilms() {
        List<Film> films = new ArrayList<>();
        films.add(new Film("Pulp Fiction", 1994, asList(THRILLER, COMEDY, CRIME)));
        films.add(new Film("Her", 2013, asList(ROMANCE, DRAMA, SCI_FI)));
        films.add(new Film("Captain Fantastic", 2016, asList(DRAMA, ROMANCE, COMEDY)));
        return films;
    }
}
