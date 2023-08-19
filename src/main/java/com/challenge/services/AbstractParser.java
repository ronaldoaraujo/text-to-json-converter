package com.challenge.services;

import java.util.ArrayList;
import java.util.List;

import com.challenge.models.LineData;
import com.challenge.models.Order;
import com.challenge.models.Product;
import com.challenge.models.User;

public abstract class AbstractParser {
    protected List<User> users;

    protected void buildCollection(LineData lineData) {
        Order order = buildOrder(lineData);
        Product product = new Product(lineData.getProductId(), lineData.getProductValue());
        order.getProducts().add(product);
    }

    private Order buildOrder(LineData lineData) {
        User user = buildUser(lineData);

        return user.getOrders().stream()
                .filter(o -> o.getId() == lineData.getOrderId())
                .findFirst()
                .orElseGet(() -> {
                    Order newOrder = new Order(lineData.getOrderId(), lineData.getOrderDate(), new ArrayList<>());
                    user.getOrders().add(newOrder);
                    return newOrder;
                });
    }

    private User buildUser(LineData lineData) {
        return users.stream()
                .filter(u -> u.getId() == lineData.getUserId())
                .findFirst()
                .orElseGet(() -> {
                    User newUser = new User(lineData.getUserId(), lineData.getUserName(), new ArrayList<>());
                    users.add(newUser);
                    return newUser;
                });
    }
}
