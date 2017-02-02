package com.bvan.cp.oop.io.parser;

/**
 * @author bvanchuhov
 */
public enum DsvFormat {
    CSV_COMMA(","),
    CSV_SEMICOLON(";"),
    TSV("\t");

    private final String delimiter;

    DsvFormat(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
