package com.challenge.services;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.challenge.models.Order;
import com.challenge.models.User;

public class TextParserTest {
    @Test
    public void testParserUsersCount() throws IOException {
        String inputFilePath = "src/test/resources/data_1.txt";

        InputParser parser = new TextParser();
        List<User> users = parser.parse(inputFilePath);

        assertEquals(100, users.size());
    }

    @Test
    public void testParserWithEmptyFile() throws IOException {
        String inputFilePath = "src/test/resources/empty.txt";

        InputParser parser = InputParserFactory.createParser(InputParserFactory.Format.TEXT);
        List<User> users = parser.parse(inputFilePath);

        assertEquals(0, users.size());
    }

    @Test
    public void testParserForEspecifiqUser() throws IOException {
        String inputFilePath = "src/test/resources/data_1.txt";

        InputParser parser = new TextParser();
        List<User> users = parser.parse(inputFilePath);
        User user = users.stream().filter(u -> u.id().equals(70L)).findFirst().get();

        assertEquals(70, user.id().longValue());
        assertEquals("Palmer Prosacco", user.name());
    }

    @Test
    public void testOrdersForEspecifiqUser() throws IOException {
        String inputFilePath = "src/test/resources/data_1.txt";

        InputParser parser = new TextParser();
        List<User> users = parser.parse(inputFilePath);
        User user = users.stream().filter(u -> u.id().equals(70L)).findFirst().get();
        Long[] expectedOrders = {749L,750L,751L,752L,753L,754L,755L,756L,757L,758L};
        Long[] actualOrders = user.orders().stream().map(o -> o.id()).toArray(Long[]::new);
        Arrays.sort(actualOrders);

        assertArrayEquals(expectedOrders, actualOrders);
    }

    @Test
    public void testProductForEspecifiqOrder() throws IOException {
        String inputFilePath = "src/test/resources/data_1.txt";

        InputParser parser = new TextParser();
        List<User> users = parser.parse(inputFilePath);
        User user = users.stream().filter(u -> u.id().equals(70L)).findFirst().get();
        Order order = user.orders().stream().filter(o -> o.id().equals(749L)).findFirst().get();

        Long[] expectedProducts = {2L, 3L, 5L, 5L};
        Long[] actualProducts = order.products().stream().map(o -> o.id()).toArray(Long[]::new);
        Arrays.sort(actualProducts);

        assertArrayEquals(expectedProducts, actualProducts);
    }

    @Test
    public void testOrderTotal() throws IOException {
        String inputFilePath = "src/test/resources/data_1.txt";

        InputParser parser = new TextParser();
        List<User> users = parser.parse(inputFilePath);
        User user = users.stream().filter(u -> u.id().equals(70L)).findFirst().get();
        Order order = user.orders().stream().filter(o -> o.id().equals(749L)).findFirst().get();

        BigDecimal expectedTotal = new BigDecimal("3537.89");

        assertEquals(expectedTotal, order.total());
    }
}
