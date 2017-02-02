package com.bvan.cp.proc.entity;

import com.bvan.cp.common.Joiner;

import java.io.Serializable;
import java.util.*;

/**
 * @author bvanchuhov
 */
public final class Film implements Entity, Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int releaseYear;
    private Set<Genre> genres = new TreeSet<>();

    public Film(String name) {
        this.name = name;
    }

    public Film(String name, int releaseYear, Collection<Genre> genres) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.genres = new TreeSet<>(genres);
    }

    public String getName() {
        return name;
    }

    public Film setName(String name) {
        this.name = name;
        return this;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public Film setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public Film addGenre(Genre genre) {
        genres.add(genre);
        return this;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film)) return false;
        Film film = (Film) o;
        return releaseYear == film.releaseYear &&
                Objects.equals(name, film.name) &&
                Objects.equals(genres, film.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, releaseYear, genres);
    }

    @Override
    public String toOutputString(String delimiter) {
        return new Joiner(delimiter).join(name, releaseYear, new Joiner(", ").join(genres.toArray()));
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", releaseYear=" + releaseYear +
                ", genres=" + genres +
                '}';
    }
}
