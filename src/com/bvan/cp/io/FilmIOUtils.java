package com.bvan.cp.io;

import com.bvan.cp.entity.Film;
import com.bvan.cp.entity.Genre;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.bvan.cp.io.Validator.isInt;
import static com.bvan.cp.io.Validator.isReleaseYear;

/**
 * @author bvanchuhov
 */
public class FilmIOUtils {

    private FilmIOUtils() {}

    public static final String CSV_DELIMITER = ";";

    // Input from text file

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    public static List<Film> readFilmsFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return readFilms(reader);
        }
    }

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    public static List<Film> readFilms(BufferedReader reader) throws IOException {
        List<Film> res = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            Film film = parseFilm(line);
            res.add(film);
        }

        return res;
    }

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    public static Film readFilmFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return readFilm(reader);
        }
    }

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    public static Film readFilm(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        return parseFilm(line);
    }

    // Output into text file

    public static void writeFilmsIntoFile(String fileName, List<Film> films) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            writeFilms(writer, films);
        }
    }

    public static void writeFilms(PrintWriter writer, List<Film> films) {
        for (Film film : films) {
            writer.println(film.toOutputString(CSV_DELIMITER));
        }
    }

    // Input from binary file

    public static void writeFilmsIntoBinFile(String fileName, List<Film> films) throws IOException {
        try (ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutput.writeObject(films);
        }
    }

    // Output into binary file

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    public static List<Film> readFilmsFromBinFile(String fileName) throws IOException {
        try (ObjectInput objectInput = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Film>)objectInput.readObject();
        } catch (ClassNotFoundException | ClassCastException e) {
            throw new IllegalFormatException("Binary file is corrupted", e);
        }
    }

    // Common

    /**
     * @throws IllegalFormatException
     */
    public static Film parseFilm(String line) {
        String[] tokens = line.split(CSV_DELIMITER);

        if (tokens.length < 3) {
            throw new IllegalFormatException("Missing values, should be (name;release-year;genres): " + line);
        }
        if (!isInt(tokens[1])) {
            throw new IllegalFormatException("Release year in not a number: " + tokens[1]);
        }

        String name = tokens[0].trim();
        int releaseYear = Integer.parseInt(tokens[1].trim());
        if (!isReleaseYear(releaseYear)) {
            throw new IllegalFormatException("Illegal release year: " + releaseYear);
        }

        Set<Genre> genres = parseGenre(tokens[2]);
        if (genres == null) {
            return null;
        }

        return new Film(name, releaseYear, genres);
    }

    /**
     * @throws IllegalFormatException
     */
    public static Set<Genre> parseGenre(String line) {
        Set<Genre> genres = new HashSet<>();

        String[] genreTokens = line.split(",");
        for (String genreToken : genreTokens) {
            genreToken = genreToken.trim();

            if (!Genre.isGenre(genreToken)) {
                throw new IllegalFormatException("Illegal genre: " + genreToken);
            }

            genres.add(Genre.valueOf(genreToken));
        }

        return genres;
    }
}
