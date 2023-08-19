package com.challenge.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.challenge.models.Order;
import com.challenge.models.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TextToJsonConverterTest {

    @Test
    public void testParseInputFile() {
        TextToJsonConverter textToJsonConverter = new TextToJsonConverter();
        String inputFilePath = "src/test/resources/data_1.txt";

        List<User> users = textToJsonConverter.parseInputFile(inputFilePath);
        User user = users.get(0);
        Order order = user.getOrders().get(0);

        assertEquals(100, users.size());
        assertEquals(10, user.getOrders().size());
        assertEquals(4, order.getProducts().size());
    }

    @Test
    public void testConvertToJson() throws IOException {
        TextToJsonConverter textToJsonConverter = new TextToJsonConverter();
        String inputFilePath = "src/test/resources/data_1.txt";

        List<User> users = textToJsonConverter.parseInputFile(inputFilePath);
        String json = textToJsonConverter.convertToJson(users);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(json);

        assertTrue(jsonNode.has("users"));
        assertTrue(jsonNode.get("users").isArray());
        assertEquals(100, jsonNode.get("users").size());
    }
}
