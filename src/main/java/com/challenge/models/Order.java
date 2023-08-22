package com.challenge.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public record Order(@JsonProperty("order_id") Long id,
                    @JsonFormat(pattern = "yyyy-MM-dd") LocalDate date,
                    List<Product> products) {

    @JsonProperty("total")
    public BigDecimal getTotal() {
        return products.stream()
                       .map(Product::value)
                       .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
