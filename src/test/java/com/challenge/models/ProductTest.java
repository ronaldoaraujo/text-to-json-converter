package com.challenge.models;

import org.junit.Test;

public class ProductTest {

    @Test
    public void testConstructor() {
        Product product = new Product(1, 10.0);

        assert product.getId() == 1;
        assert product.getValue() == 10.0;
    }

    @Test
    public void testGettersAndSetters() {
        Product product = new Product();

        product.setId(1);
        product.setValue(10.0);

        assert product.getId() == 1;
        assert product.getValue() == 10.0;
    }

    @Test
    public void testEquals() {
        Product product1 = new Product(1, 10.0);
        Product product2 = new Product(1, 10.0);

        assert product1.equals(product2);
    }

    @Test
    public void testHashCode() {
        Product product1 = new Product(1, 10.0);
        Product product2 = new Product(1, 10.0);

        assert product1.hashCode() == product2.hashCode();
    }
}
