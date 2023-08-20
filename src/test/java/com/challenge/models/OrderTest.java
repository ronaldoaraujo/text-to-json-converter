package com.challenge.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {
        private LocalDate currentDate;

        @Before
        public void setUp() {
            currentDate = LocalDate.now();
        }

        @Test
        public void testConstructor() {
            Order order = new Order(1, currentDate, new ArrayList<Product>());

            assertEquals(1, order.getId());
            assertEquals(currentDate, order.getDate());
            assertEquals(0, order.getProducts().size());
        }

        @Test
        public void testGettersAndSetters() {
            Order order = new Order();

            order.setId(1);
            order.setDate(currentDate);
            order.setProducts(new ArrayList<Product>());

            assertEquals(1, order.getId());
            assertEquals(currentDate, order.getDate());
            assertEquals(0, order.getProducts().size());
        }

        @Test
         public void testProductsAdd() {
            Order order = new Order(1, currentDate, new ArrayList<Product>());
            Product product = new Product(1, 10.0);

            order.getProducts().add(product);

            assertEquals(1, order.getProducts().size());
         }

         @Test
         public void testGetTotal() {
            Order order = new Order(1, currentDate, new ArrayList<Product>());
            Product product1 = new Product(1, 10.0);
            Product product2 = new Product(2, 20.0);

            order.getProducts().add(product1);
            order.getProducts().add(product2);

            assertEquals(30.0, order.getTotal(), 0.0);
         }

        @Test
        public void testEquals() {
            Order order1 = new Order(1, currentDate, new ArrayList<Product>());
            Order order2 = new Order(1, currentDate, new ArrayList<Product>());
            Order order3 = new Order(2, currentDate, new ArrayList<Product>());

            assertEquals(order1, order1);
            assertEquals(order1, order2);
            assertNotEquals(order1, order3);
            assertNotEquals(order1, null);
            assertNotEquals(order1, new Object());
        }

        @Test
        public void testHashCode() {
            Order order1 = new Order(1, currentDate, new ArrayList<Product>());
            Order order2 = new Order(1, currentDate, new ArrayList<Product>());

            assertEquals(order1.hashCode(), order2.hashCode());
        }
}
