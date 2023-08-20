package com.challenge.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class ProductTest {

    @Test
    public void testConstructor() {
        Product product = new Product(1, 10.0);

        assertEquals(10.0, product.getValue(), 0.0);
    }

    @Test
    public void testGettersAndSetters() {
        Product product = new Product();

        product.setId(1);
        product.setValue(10.0);

        assertEquals(1, product.getId());
        assertEquals(10.0, product.getValue(), 0.0);
    }

    @Test
    public void testEquals() {
        Product product1 = new Product(1, 10.0);
        Product product2 = new Product(1, 10.0);
        Product product3 = new Product(2, 11.0);

        assertEquals(product1, product1);
        assertEquals(product1, product2);
        assertNotEquals(product1, product3);
        assertNotEquals(product1, null);
        assertNotEquals(product1, new Object());
    }

    @Test
    public void testHashCode() {
        Product product1 = new Product(1, 10.0);
        Product product2 = new Product(1, 10.0);

        assertEquals(product1.hashCode(), product2.hashCode());
    }
}
