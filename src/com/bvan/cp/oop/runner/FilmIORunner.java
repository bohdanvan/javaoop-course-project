package com.bvan.cp.oop.runner;

import com.bvan.cp.oop.film.Films;
import com.bvan.cp.oop.io.IllegalFormatException;

import java.io.*;

import static com.bvan.cp.oop.film.io.BasicFilmsIO.*;

/**
 * @author bvanchuhov
 */
public class FilmIORunner {

    private static final String INPUT_TEXT_FILE = "files/films.csv";
    private static final String OUTPUT_TEXT_FILE = "files/films-out.csv";
    private static final String BIN_FILE = "files/films.dat";

    public static void main(String[] args) {
        try {
            System.out.println("Reading from text file: " + INPUT_TEXT_FILE);
            Films films = readFromTextFile(INPUT_TEXT_FILE);

            System.out.println("Writing into text file: " + OUTPUT_TEXT_FILE);
            writeIntoTextFile(OUTPUT_TEXT_FILE, films);

            System.out.println("Writing into bin file: " + BIN_FILE);
            writeIntoBinFile(BIN_FILE, films);

            System.out.println("Reading from bin file: " + BIN_FILE);
            Films filmsFromBinFile = readFromBinFile(BIN_FILE);
            System.out.println(filmsFromBinFile);

            System.out.println("DONE");
        } catch (IOException e) {
            System.out.println("IO Error. " + e.getMessage());
        } catch (IllegalFormatException e) {
            System.out.println("Illegal format. " + e.getMessage());
        }
    }
}
