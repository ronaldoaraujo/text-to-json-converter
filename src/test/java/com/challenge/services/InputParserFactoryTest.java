package com.challenge.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;

public class InputParserFactoryTest {

    @Test
    public void testCreateTextParser() {
        InputParser parser = InputParserFactory.createParser(InputParserFactory.Format.TEXT);
        assertEquals(TextParser.class, parser.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateParserWithUnsupportedFormat() {
        InputParserFactory.createParser(mock(InputParserFactory.Format.class));
    }
}
