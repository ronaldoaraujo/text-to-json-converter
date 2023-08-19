package com.challenge.models;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.challenge.serializers.DoubleSerializer;

@JsonPropertyOrder({"order_id", "total", "date", "products"})
public class Order {

    @JsonProperty("order_id")
    private int id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private List<Product> products;

    public Order() {
    }

    public Order(int id, LocalDate date, List<Product> products) {
        this.id = id;
        this.date = date;
        this.products = products;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Order id(int id) {
        setId(id);
        return this;
    }

    public Order date(LocalDate date) {
        setDate(date);
        return this;
    }

    public Order products(List<Product> products) {
        setProducts(products);
        return this;
    }

    @JsonProperty("total")
    @JsonSerialize(using = DoubleSerializer.class)
    public double getTotal() {
        double total = 0.0;
        for (Product product : products) {
            total += product.getValue();
        }
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Order)) {
            return false;
        }
        Order order = (Order) o;
        return id == order.id && Objects.equals(date, order.date) && Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, products);
    }
}
