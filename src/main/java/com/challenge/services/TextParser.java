package com.challenge.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.challenge.models.LineData;
import com.challenge.models.User;

public class TextParser extends AbstractParser implements InputParser {

    @Override
    public List<User> parse(String filePath) {
        String line;
        users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((line = reader.readLine()) != null) {
                LineData lineData = parseLine(line);
                buildCollection(lineData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }

    private LineData parseLine(String line) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        int userId = Integer.parseInt(line.substring(0, 10));
        String userName = line.substring(10, 55).trim();
        int orderId = Integer.parseInt(line.substring(55, 65));
        int productId = Integer.parseInt(line.substring(65, 75));
        double productValue = Double.parseDouble(line.substring(75, 87).trim());
        LocalDate orderDate = LocalDate.parse(line.substring(87, 95).trim(), inputFormatter);

        return new LineData(userId, userName, orderId, productId, productValue, orderDate);
    }
}
