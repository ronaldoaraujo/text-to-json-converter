package com.challenge.services;

import java.util.List;

import com.challenge.models.User;

public interface InputParser {
    List<User> parse(String filePath);
}
