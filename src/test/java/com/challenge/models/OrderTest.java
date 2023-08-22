package com.challenge.models;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class OrderTest {
    @Test
    public void testGetTotalWithEmptyProducts() {
        List<Product> products = Arrays.asList();
        BigDecimal expectedTotal = BigDecimal.ZERO;

        Order order = new Order(null, null, products);
        BigDecimal actualTotal = order.total();

        assertEquals(expectedTotal, actualTotal);
    }

    @Test
    public void testGetTotalWithMultipleProducts() {
        List<Product> products = Arrays.asList(
            new Product(1L, new BigDecimal("100.50")),
            new Product(2L, new BigDecimal("150.75"))
        );
        BigDecimal expectedTotal = new BigDecimal("251.25");

        Order order = new Order(null, null, products);
        BigDecimal actualTotal = order.total();

        assertEquals(expectedTotal, actualTotal);
    }
}
