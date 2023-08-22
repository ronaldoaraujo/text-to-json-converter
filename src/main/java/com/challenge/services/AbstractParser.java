package com.challenge.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.challenge.models.LineData;
import com.challenge.models.Order;
import com.challenge.models.Product;
import com.challenge.models.User;

public abstract class AbstractParser {
    protected Map<Long, User> usersMap = new HashMap<>();

    protected void buildCollection(LineData lineData) {
        User user = getUserOrCreate(lineData);
        Order order = getOrderOrCreate(user, lineData);
        Product product = new Product(lineData.productId(), lineData.productValue());

        order.products().add(product);
    }

    private Order getOrderOrCreate(User user, LineData lineData) {
        return user.orders().stream()
                .filter(o -> o.id().equals(lineData.orderId()))
                .findFirst()
                .orElseGet(() -> {
                    Order newOrder = new Order(lineData.orderId(), lineData.orderDate(), new ArrayList<>());
                    user.orders().add(newOrder);
                    return newOrder;
                });
    }

    private User getUserOrCreate(LineData lineData) {
        return usersMap.computeIfAbsent(lineData.userId(), userId ->
            new User(userId, lineData.userName(), new ArrayList<>())
        );
    }
}
