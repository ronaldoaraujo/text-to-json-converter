package com.challenge.models;

import java.time.LocalDate;
import java.util.Objects;

public class LineData {
    private int userId;
    private String userName;
    private int orderId;
    private int productId;
    private double productValue;
    private LocalDate orderDate;

    public LineData() {
    }

    public LineData(int userId, String userName, int orderId, int productId, double productValue, LocalDate orderDate) {
        this.userId = userId;
        this.userName = userName;
        this.orderId = orderId;
        this.productId = productId;
        this.productValue = productValue;
        this.orderDate = orderDate;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getProductValue() {
        return this.productValue;
    }

    public void setProductValue(double productValue) {
        this.productValue = productValue;
    }

    public LocalDate getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LineData)) {
            return false;
        }
        LineData lineData = (LineData) o;
        return userId == lineData.userId && Objects.equals(userName, lineData.userName) && orderId == lineData.orderId && productId == lineData.productId && productValue == lineData.productValue && Objects.equals(orderDate, lineData.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, orderId, productId, productValue, orderDate);
    }
}
