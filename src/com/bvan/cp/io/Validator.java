package com.bvan.cp.io;

/**
 * @author bvanchuhov
 */
public class Validator {

    private Validator() {}

    public static boolean isReleaseYear(int year) {
        return year >= 1880 && year <= 2050;
    }

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
