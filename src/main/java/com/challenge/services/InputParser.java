package com.challenge.services;

import java.io.IOException;
import java.util.List;

import com.challenge.models.User;

public interface InputParser {
    List<User> parse(String filePath) throws IOException;
}
