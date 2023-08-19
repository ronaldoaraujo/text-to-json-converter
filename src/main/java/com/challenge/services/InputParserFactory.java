package com.challenge.services;

public class InputParserFactory {

    public enum Format {
        TEXT
    }

    public static InputParser createParser(Format format) {
        if (format == Format.TEXT)
            return new TextParser();
        else
            throw new IllegalArgumentException("Unsupported format: " + format);
    }
}
