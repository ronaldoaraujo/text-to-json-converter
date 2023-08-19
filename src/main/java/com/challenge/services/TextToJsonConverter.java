package com.challenge.services;

import java.io.IOException;
import java.util.List;

import com.challenge.models.JsonOutput;
import com.challenge.models.User;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TextToJsonConverter {
    private InputParser parser;

    public TextToJsonConverter(InputParser parser) {
        this.parser = parser;
    }

    public String convertToJson(String inputFilePath) {
        List<User> users = parser.parse(inputFilePath);
        return convertToJson(users);
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
