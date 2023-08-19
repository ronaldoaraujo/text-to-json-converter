package com.challenge.models;

import java.util.ArrayList;

import org.junit.Test;

public class UserTest {

    @Test
    public void testConstructor() {
        User user = new User(1, "John Doe", new ArrayList<Order>());

        assert user.getId() == 1;
        assert user.getName() == "John Doe";
        assert user.getOrders().size() == 0;
    }

    @Test
    public void testGettersAndSetters() {
        User user = new User();

        user.setId(1);
        user.setName("John Doe");
        user.setOrders(new ArrayList<Order>());

        assert user.getId() == 1;
        assert user.getName() == "John Doe";
        assert user.getOrders().size() == 0;
    }

    @Test
    public void testOrdersAdd() {
        User user = new User(1, "John Doe", new ArrayList<Order>());
        Order order = new Order(1, null, null);

        user.getOrders().add(order);

        assert user.getOrders().size() == 1;
    }

    @Test
    public void testEquals() {
        User user1 = new User(1, "John Doe", new ArrayList<Order>());
        User user2 = new User(1, "John Doe", new ArrayList<Order>());

        assert user1.equals(user2);
    }

    @Test
    public void testHashCode() {
        User user1 = new User(1, "John Doe", new ArrayList<Order>());
        User user2 = new User(1, "John Doe", new ArrayList<Order>());

        assert user1.hashCode() == user2.hashCode();
    }
}
