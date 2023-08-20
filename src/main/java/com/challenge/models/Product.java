package com.challenge.models;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"product_id", "value"})
public class Product {

    @JsonProperty("product_id")
    private int id;
    private double value;

    public Product() {
    }

    public Product(int id, double value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return id == product.id && value == product.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }
}
