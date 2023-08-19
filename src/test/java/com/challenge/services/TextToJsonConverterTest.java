package com.challenge.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TextToJsonConverterTest {
    private TextToJsonConverter converter;

    @Before
    public void setUp() {
        InputParserFactory parserFactory = new TextParserFactory();
        InputParser parser = parserFactory.createParser();

        converter = new TextToJsonConverter(parser);
    }

    @Test
    public void testConvertToJson() throws IOException {
        String inputFilePath = "src/test/resources/data_1.txt";
        String json = converter.convertToJson(inputFilePath);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(json);

        assertTrue(jsonNode.has("users"));
        assertTrue(jsonNode.get("users").isArray());
        assertEquals(100, jsonNode.get("users").size());
    }
}
