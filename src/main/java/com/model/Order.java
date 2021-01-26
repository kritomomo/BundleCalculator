package com.model;

import com.calculator.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Order {
    List<OrderItem> orders;

    public Order(ArrayList<String> orderString) {
        orders = new ArrayList<>();
        if (orderString != null) {
            for (int i = 0; i < orderString.size() - 1; i++) {
                try {
                    orders.add(getOrder(orderString.get(i + 1), Integer.parseInt(orderString.get(i))));
                } catch (NumberFormatException e) {
                }
            }
        }
    }

    public OrderItem getOrder(String format, int number) {
        switch (format) {
            case "VID":
                return new OrderItem(number, Bundle.VID);
            case "FLAC":
                return new OrderItem(number, Bundle.FLAC);
            case "IMG":
                return new OrderItem(number, Bundle.IMG);
            default:
                return null;
        }
    }

    public List<OrderItem> getOrders() {
        return orders;
    }
}
