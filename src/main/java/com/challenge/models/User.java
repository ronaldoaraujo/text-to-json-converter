package com.challenge.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record User(@JsonProperty("user_id") Long id, String name, List<Order> orders) {}
