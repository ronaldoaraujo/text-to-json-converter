package com.challenge.models;

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

            assert order.getId() == 1;
            assert order.getDate() == currentDate;
            assert order.getProducts().size() == 0;
        }

        @Test
        public void testGettersAndSetters() {
            Order order = new Order();

            order.setId(1);
            order.setDate(currentDate);
            order.setProducts(new ArrayList<Product>());

            assert order.getId() == 1;
            assert order.getDate() == currentDate;
            assert order.getProducts().size() == 0;
        }

        @Test
         public void testProductsAdd() {
            Order order = new Order(1, currentDate, new ArrayList<Product>());
            Product product = new Product(1, 10.0);

            order.getProducts().add(product);

            assert order.getProducts().size() == 1;
         }

         @Test
         public void testGetTotal() {
            Order order = new Order(1, currentDate, new ArrayList<Product>());
            Product product1 = new Product(1, 10.0);
            Product product2 = new Product(2, 20.0);

            order.getProducts().add(product1);
            order.getProducts().add(product2);

            assert order.getTotal() == 30.0;
         }

        @Test
        public void testEquals() {
            Order order1 = new Order(1, currentDate, new ArrayList<Product>());
            Order order2 = new Order(1, currentDate, new ArrayList<Product>());

            assert order1.equals(order2);
        }

        @Test
        public void testHashCode() {
            Order order1 = new Order(1, currentDate, new ArrayList<Product>());
            Order order2 = new Order(1, currentDate, new ArrayList<Product>());

            assert order1.hashCode() == order2.hashCode();
        }
}
