package com.bvan.cp.oop.film;

import com.bvan.cp.oop.gen.Generator;
import com.bvan.cp.oop.gen.LongIdGenerator;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author bvanchuhov
 */
public final class Film implements Serializable {

    private static final long serialVersionUID = 1L;

    private final long id;
    private final String name;
    private final int releaseYear;
    private final Set<Genre> genres;

    public Film(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.releaseYear = builder.releaseYear;
        this.genres = builder.genres;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
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
    public String toString() {
        return "Film{" +
                "id = " + id +
                ", name='" + name + '\'' +
                ", releaseYear=" + releaseYear +
                ", genres=" + genres +
                '}';
    }

    public static class Builder {

        private static Generator<Long> idGenerator = LongIdGenerator.INSTANCE;

        private long id = idGenerator.generate();
        private String name;
        private int releaseYear;
        private Set<Genre> genres = new TreeSet<>();

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder releaseYear(int releaseYear) {
            this.releaseYear = releaseYear;
            return this;
        }

        public Builder addGenre(Genre genre) {
            genres.add(genre);
            return this;
        }

        public Builder genres(Collection<Genre> genres) {
            this.genres = new TreeSet<>(genres);
            return this;
        }

        public Film build() {
            return new Film(this);
        }
    }
}
