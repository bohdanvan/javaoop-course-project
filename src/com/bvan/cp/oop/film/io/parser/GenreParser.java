package com.bvan.cp.oop.film.io.parser;

import com.bvan.cp.oop.film.Genre;
import com.bvan.cp.oop.io.parser.Parser;

import static com.bvan.cp.oop.film.Genre.isGenre;

/**
 * @author bvanchuhov
 */
public class GenreParser implements Parser<Genre> {

    @Override
    public Genre parse(String token) {
        String s = token.trim();
        if (!isGenre(s)) {
            throw new IllegalArgumentException("illegal genre: " + s);
        }
        return Genre.valueOf(s);
    }
}
