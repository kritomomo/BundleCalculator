package com.model;

import com.calculator.Bundle;
import com.calculator.BundleCalculator;
import com.calculator.Pair;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrderItem {
    private Bundle bundle;
    private int number;

    public OrderItem(int number, Bundle bundle) {
        this.number = number;
        this.bundle = bundle;
    }

    public String calculateOrder() {
        int orderNumber = number;
        if (orderNumber < bundle.getBundles().get(0).getNumber()) orderNumber = bundle.getBundles().get(0).getNumber();
        int min;
        ArrayList<String> imgUsed = new ArrayList<>();
        int tempImgOrder = orderNumber;
        do {
            int[] road = new int[tempImgOrder + 1];
            min = BundleCalculator.getMinCount(tempImgOrder, bundle, road);

            if (min > Integer.MAX_VALUE - tempImgOrder) {
                //System.out.println("order cannot be rounded up");
                tempImgOrder++;
            } else {
//                System.out.println(bundle.name() + " Order: " + orderNumber + ", The minimum number of bundles required is: " + min);
                for (int j = tempImgOrder; j > 0; ) {
//                    System.out.print(road[j] + "\t");
                    imgUsed.add(String.valueOf(road[j]));
                    //j is the currently used bundle value, road[j] is the recently added bundle under the current order
                    j = j - road[j];
                }
            }
        } while (min > Integer.MAX_VALUE - tempImgOrder);

        Map<String, Long> map = imgUsed.stream().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        StringBuilder s = new StringBuilder();
        s.append(orderNumber).append(" " + bundle.name() + " ");
        double bundlePrice = 0.0;
        StringBuilder s1 = new StringBuilder();
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            double price = bundle.getBundles().get(0).getPrice();
            for (Pair pair : bundle.getBundles()) {
                if (pair.getNumber() == Integer.parseInt(entry.getKey())) {
                    price = pair.getPrice();
                }
            }
            double totalPrice = entry.getValue() * price;
            bundlePrice += totalPrice;
            s1.append("\t" + entry.getValue()).append(" x ")
                    .append(entry.getKey()).append(" $").append(totalPrice).append("\n");
        }
        s.append(" ").append("$").append(bundlePrice).append("\n").append(s1);
        return s.toString();
    }

    public int getNumber() {
        return number;
    }

    public Bundle getBundle() {
        return bundle;
    }
}
