package com.challenge.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.challenge.models.JsonOutput;
import com.challenge.models.Order;
import com.challenge.models.Product;
import com.challenge.models.User;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TextToJsonConverter {
    public List<User> parseInputFile(String inputFilePath) {
        List<User> users = new ArrayList<>();
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int userId = Integer.parseInt(line.substring(0, 10));
                String userName = line.substring(10, 55).trim();
                int orderId = Integer.parseInt(line.substring(55, 65));
                int productId = Integer.parseInt(line.substring(65, 75));
                double productValue = Double.parseDouble(line.substring(75, 87).trim());
                LocalDate orderDate = LocalDate.parse(line.substring(87, 95).trim(), inputFormatter);

                User user = users.stream()
                        .filter(u -> u.getId() == userId)
                        .findFirst()
                        .orElseGet(() -> {
                            User newUser = new User(userId, userName, new ArrayList<>());
                            users.add(newUser);
                            return newUser;
                        });

                Order order = user.getOrders().stream()
                        .filter(o -> o.getId() == orderId)
                        .findFirst()
                        .orElseGet(() -> {
                            Order newOrder = new Order(orderId, orderDate, new ArrayList<>());
                            user.getOrders().add(newOrder);
                            return newOrder;
                        });

                Product product = new Product(productId, productValue);
                order.getProducts().add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }

    public String convertToJson(List<User> users) {
        JsonOutput jsonOutput = new JsonOutput(users);
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        String json = "";

        try {
            json = mapper.writeValueAsString(jsonOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }
}
