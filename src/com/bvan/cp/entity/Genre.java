package com.bvan.cp.entity;

/**
 * @author bvanchuhov
 */
public enum Genre {
    ACTION,
    ADVENTURE,
    FANTASY,
    ANIMATION,
    COMEDY,
    CRIME,
    DETECTIVE,
    DRAMA,
    DOCUMENTARY,
    FAMILY,
    HORROR,
    ROMANCE,
    SCI_FI,
    THRILLER,
    WAR
    ;

    public static boolean isGenre(String s) {
        for (Genre genre : Genre.values()) {
            if (genre.name().equals(s)) {
                return true;
            }
        }
        return false;
    }
}
