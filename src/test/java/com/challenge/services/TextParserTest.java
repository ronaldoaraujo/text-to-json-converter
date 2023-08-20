package com.challenge.services;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.challenge.models.Order;
import com.challenge.models.User;

public class TextParserTest {

    @Test
    public void testParse() {
        String inputFilePath = "src/test/resources/data_1.txt";

        InputParser parser = InputParserFactory.createParser(InputParserFactory.Format.TEXT);
        List<User> users = parser.parse(inputFilePath);
        User user = users.get(0);
        Order order = user.getOrders().get(0);


        assertEquals(100, users.size());
        assertEquals(10, user.getOrders().size());
        assertEquals(4, order.getProducts().size());
    }

    @Test
    public void testParseWithEmptyFile() {
        String inputFilePath = "src/test/resources/empty.txt";

        InputParser parser = InputParserFactory.createParser(InputParserFactory.Format.TEXT);
        List<User> users = parser.parse(inputFilePath);

        assertEquals(0, users.size());
    }
}
