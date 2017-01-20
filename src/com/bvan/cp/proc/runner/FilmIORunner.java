package com.bvan.cp.proc.runner;

import com.bvan.cp.proc.entity.Film;
import com.bvan.cp.proc.io.IllegalFormatException;

import java.io.IOException;
import java.util.List;

import static com.bvan.cp.proc.io.FilmIOUtils.readFilmsFromFile;
import static com.bvan.cp.proc.io.FilmIOUtils.writeFilmsIntoBinFile;

/**
 * @author bvanchuhov
 */
public class FilmIORunner {

    public static final String INPUT_TEXT_FILE = "files/films.csv";
    public static final String OUTPUT_BIN_FILE = "files/films.dat";

    public static void main(String[] args) {
        try {
            List<Film> films = readFilmsFromFile(INPUT_TEXT_FILE);
            writeFilmsIntoBinFile(OUTPUT_BIN_FILE, films);
            System.out.println("DONE");
        } catch (IOException e) {
            System.out.println("IO Error. " + e.getMessage());
        } catch (IllegalFormatException e) {
            System.out.println("Illegal format. " + e.getMessage());
        }
    }
}
