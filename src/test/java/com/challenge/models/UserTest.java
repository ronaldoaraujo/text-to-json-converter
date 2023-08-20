package com.challenge.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

public class UserTest {

    @Test
    public void testConstructor() {
        User user = new User(1, "John Doe", new ArrayList<Order>());

        assertEquals(1, user.getId());
        assertEquals("John Doe", user.getName());
        assertEquals(0, user.getOrders().size());
    }

    @Test
    public void testGettersAndSetters() {
        User user = new User();

        user.setId(1);
        user.setName("John Doe");
        user.setOrders(new ArrayList<Order>());

        assertEquals(1, user.getId());
        assertEquals("John Doe", user.getName());
        assertEquals(0, user.getOrders().size());
    }

    @Test
    public void testOrdersAdd() {
        User user = new User(1, "John Doe", new ArrayList<Order>());
        Order order = new Order(1, null, null);

        user.getOrders().add(order);

        assertEquals(1, user.getOrders().size());
    }

    @Test
    public void testEquals() {
        User user1 = new User(1, "John Doe", new ArrayList<Order>());
        User user2 = new User(1, "John Doe", new ArrayList<Order>());
        User user3 = new User(2, "Eric Estrada", new ArrayList<Order>());

        assertEquals(user1, user1);
        assertEquals(user1, user2);
        assertNotEquals(user1, user3);
        assertNotEquals(user1, null);
        assertNotEquals(user1, new Object());
    }

    @Test
    public void testHashCode() {
        User user1 = new User(1, "John Doe", new ArrayList<Order>());
        User user2 = new User(1, "John Doe", new ArrayList<Order>());

        assertEquals(user1.hashCode(), user2.hashCode());
    }
}
