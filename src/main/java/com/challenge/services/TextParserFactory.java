package com.challenge.services;

public class TextParserFactory implements InputParserFactory {
    @Override
    public InputParser createParser() {
        return new TextParser();
    }
}
