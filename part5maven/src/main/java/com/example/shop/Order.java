package com.example.shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    private final List<OrderItem> items = new ArrayList<>();
    private OrderStatus status = OrderStatus.NEW;

    public void addItem(OrderItem item) {
        if (status == OrderStatus.PAID) {
            throw new IllegalStateException("Cannot modify paid order");
        }
        items.add(item);
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}