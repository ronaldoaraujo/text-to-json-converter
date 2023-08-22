package com.challenge.models;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Product(@JsonProperty("product_id") Long id, BigDecimal value) {}
