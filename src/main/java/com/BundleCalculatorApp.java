package com;

import com.calculator.BundleCalculator;
import com.model.Order;

import java.util.ArrayList;

public class BundleCalculatorApp {
    public static void main(String[] args) {
        OrderInput input = new OrderInput();
        ArrayList<String> order = input.readFile("order.txt");
        Order o = new Order(order);
        String s = BundleCalculator.calculateOrder(o.getOrders());
        System.out.println(s);
        OrderOutput output = new OrderOutput();
        output.writeFile(s, "out.txt");
    }
}
