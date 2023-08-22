package com.challenge.services;

import java.io.IOException;
import java.util.List;

import com.challenge.models.JsonOutput;
import com.challenge.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class TextToJsonConverter {
    private InputParser parser;

    public TextToJsonConverter(InputParser parser) {
        this.parser = parser;
    }

    public String convertToJson(String inputFilePath) throws IOException {
        List<User> users = parser.parse(inputFilePath);
        return convertToJson(users);
    }

    private String convertToJson(List<User> users) throws IOException  {
        JsonOutput jsonOutput = new JsonOutput(users);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String json = "";

        json = mapper.writeValueAsString(jsonOutput);

        return json;
    }
}
