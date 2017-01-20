package com.bvan.cp.proc.runner;

import com.bvan.cp.proc.entity.Film;

import java.util.ArrayList;
import java.util.List;

import static com.bvan.cp.proc.common.CommonUtils.printList;
import static com.bvan.cp.proc.entity.Genre.*;
import static com.bvan.cp.proc.filtering.CommonPredicates.allOf;
import static com.bvan.cp.proc.filtering.FilmPredicates.containsInName;
import static com.bvan.cp.proc.filtering.FilmPredicates.withReleaseYearBetween;
import static com.bvan.cp.proc.filtering.Filter.filter;
import static com.bvan.cp.proc.sorting.CommonComparators.multiCriterion;
import static com.bvan.cp.proc.sorting.FilmComparators.byName;
import static com.bvan.cp.proc.sorting.FilmComparators.byReleaseYear;
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
