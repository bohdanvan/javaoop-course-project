package com.bvan.cp.proc.runner;

import com.bvan.cp.proc.entity.Film;
import com.bvan.cp.proc.io.FilmIOUtils;
import com.bvan.cp.proc.io.IllegalFormatException;

import java.io.IOException;
import java.util.List;

import static com.bvan.cp.proc.common.CommonUtils.printList;
import static com.bvan.cp.proc.filtering.CommonPredicates.allOf;
import static com.bvan.cp.proc.filtering.FilmPredicates.containsInName;
import static com.bvan.cp.proc.filtering.FilmPredicates.withReleaseYearBetween;
import static com.bvan.cp.proc.filtering.Filter.filter;
import static com.bvan.cp.proc.sorting.CommonComparators.multiCriterion;
import static com.bvan.cp.proc.sorting.FilmComparators.byName;
import static com.bvan.cp.proc.sorting.FilmComparators.byReleaseYear;
import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;

/**
 * @author bvanchuhov
 */
public class MainRunner {

    public static final String INPUT_TEXT_FILE = "files/films.csv";
    public static final String OUTPUT_BIN_FILE = "files/films.dat";

    public static void main(String[] args) {
        List<Film> films = readFilmsFromFile(INPUT_TEXT_FILE);

        films = filter(films, allOf(
                containsInName("a"),
                withReleaseYearBetween(2000, 2014)
        ));
        sort(films, multiCriterion(
                        reverseOrder(byReleaseYear()),
                        byName())
        );

        printList(films);
        writeFilmsIntoBinFile(films, OUTPUT_BIN_FILE);
    }

    private static List<Film> readFilmsFromFile(String fileName) {
        try {
            return FilmIOUtils.readFilmsFromFile(fileName);
        } catch (IOException e) {
            System.out.println("IO Error. " + e.getMessage());
            System.exit(0);
            return null;
        } catch (IllegalFormatException e) {
            System.out.println("Illegal format. " + e.getMessage());
            System.exit(0);
            return null;
        }
    }

    private static void writeFilmsIntoBinFile(List<Film> films, String fileName) {
        try {
            FilmIOUtils.writeFilmsIntoBinFile(fileName, films);
        } catch (IOException e) {
            System.out.println("IO Error. " + e.getMessage());
        }
    }
}
