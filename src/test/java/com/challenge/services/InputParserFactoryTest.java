package com.challenge.services;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class InputParserFactoryTest {

    @Test
    public void testCreateParser() {
        InputParser parser = InputParserFactory.createParser(InputParserFactory.Format.TEXT);

        assertTrue(parser instanceof TextParser);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateParserWithInvalidFormat() {
        InputParserFactory.createParser(null);
    }
}
