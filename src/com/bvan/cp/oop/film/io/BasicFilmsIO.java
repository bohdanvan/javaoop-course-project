package com.bvan.cp.oop.film.io;

import com.bvan.cp.oop.film.Films;
import com.bvan.cp.oop.film.io.parser.FilmParser;
import com.bvan.cp.oop.io.IllegalFormatException;
import com.bvan.cp.oop.io.ObjectReader;
import com.bvan.cp.oop.io.ObjectWriter;

import java.io.*;

/**
 * @author bvanchuhov
 */
public class BasicFilmsIO {

    private BasicFilmsIO() {}

    public static Films readFromTextFile(String fileName) throws IOException, IllegalFormatException {
        FilmParser filmParser = new FilmParser(";", ",");
        try (ObjectReader<Films> filmsReader = new FilmsTextReader(new FileReader(fileName), filmParser)) {
            return filmsReader.read();
        }
    }

    public static void writeIntoTextFile(String fileName, Films films) throws IOException {
        FilmStringConverter filmConverter = new FilmStringConverter(";", ",");
        try (ObjectWriter<Films> filmsWriter = new FilmsTextWriter(new FileWriter(fileName), filmConverter)) {
            filmsWriter.write(films);
        }
    }

    public static void writeIntoBinFile(String fileName, Films films) throws IOException {
        try (ObjectWriter<Films> filmsWriter = new FilmsBinWriter(new FileOutputStream(fileName))) {
            filmsWriter.write(films);
        }
    }

    public static Films readFromBinFile(String fileName) throws IOException, IllegalFormatException {
        try (ObjectReader<Films> filmsReader = new FilmsBinReader(new FileInputStream(fileName))) {
            return filmsReader.read();
        }
    }
}
