package com.challenge.services;

import java.util.List;

import org.junit.Test;

import com.challenge.models.Order;
import com.challenge.models.User;

public class TextToJsonConverterTest {

    @Test
    public void testParseInputFile() {
        TextToJsonConverter textToJsonConverter = new TextToJsonConverter();
        String inputFilePath = "src/test/resources/data_1.txt";

        List<User> users = textToJsonConverter.parseInputFile(inputFilePath);
        User user = users.get(0);
        Order order = user.getOrders().get(0);

        assert users.size() == 100;
        assert user.getOrders().size() == 10;
        assert order.getProducts().size() == 4;
    }
}
