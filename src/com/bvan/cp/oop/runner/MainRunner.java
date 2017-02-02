package com.bvan.cp.oop.runner;

import com.bvan.cp.oop.film.Films;
import com.bvan.cp.oop.film.io.BasicFilmsIO;
import com.bvan.cp.oop.io.IllegalFormatException;

import java.io.IOException;

import static com.bvan.cp.oop.film.sorting.FilmComparators.byName;
import static com.bvan.cp.oop.film.sorting.FilmComparators.byReleaseYear;
import static com.bvan.cp.oop.film.filter.FilmPredicates.containsInName;
import static com.bvan.cp.oop.film.filter.FilmPredicates.withReleaseYearBetween;
import static com.bvan.cp.oop.filter.AndPredicate.allOf;
import static com.bvan.cp.oop.sorting.CompositeComparator.multiCriterion;
import static java.util.Collections.reverseOrder;

/**
 * @author bvanchuhov
 */
public class MainRunner {

    private static final String INPUT_TEXT_FILE = "files/films.csv";
    private static final String OUTPUT_BIN_FILE = "files/films.dat";

    public static void main(String[] args) {
        Films films = readFilmsFromFile(INPUT_TEXT_FILE);

        films = films.filter(allOf(containsInName("a"), withReleaseYearBetween(2000, 2014)));
        films.sort(multiCriterion(reverseOrder(byReleaseYear()), byName()));
        System.out.println(films);

        writeFilmsIntoBinFile(films, OUTPUT_BIN_FILE);
    }

    private static Films readFilmsFromFile(String fileName) {
        try {
            return BasicFilmsIO.readFromTextFile(fileName);
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

    private static void writeFilmsIntoBinFile(Films films, String fileName) {
        try {
            BasicFilmsIO.writeIntoBinFile(fileName, films);
        } catch (IOException e) {
            System.out.println("IO Error. " + e.getMessage());
        }
    }
}
