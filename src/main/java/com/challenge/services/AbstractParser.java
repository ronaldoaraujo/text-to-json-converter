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
        Product product = new Product(lineData.productId(), lineData.productValue());
        order.products().add(product);
    }

    private Order buildOrder(LineData lineData) {
        User user = buildUser(lineData);

        return user.orders().stream()
                .filter(o -> o.id().equals(lineData.orderId()))
                .findFirst()
                .orElseGet(() -> {
                    Order newOrder = new Order(lineData.orderId(), lineData.orderDate(), new ArrayList<>());
                    user.orders().add(newOrder);
                    return newOrder;
                });
    }

    private User buildUser(LineData lineData) {
        return users.stream()
                .filter(u -> u.id().equals(lineData.userId()))
                .findFirst()
                .orElseGet(() -> {
                    User newUser = new User(lineData.userId(), lineData.userName(), new ArrayList<>());
                    users.add(newUser);
                    return newUser;
                });
    }
}
