package com;

import com.calculator.Bundle;
import com.calculator.BundleCalculator;
import com.model.OrderItem;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BundleCalculatorTest {
    @Test
    public void testMin() {
        int min = BundleCalculator.getMinCount(10, Bundle.IMG, new int[11]);
        assertEquals(1, min);
    }

    @Test
    public void testCalculator() {
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem(10, Bundle.IMG));
        orderItems.add(new OrderItem(15, Bundle.FLAC));
        orderItems.add(new OrderItem(13, Bundle.VID));
        assertEquals("10 IMG  $800.0\n" +
                "\t1 x 10 $800.0\n" +
                "15 FLAC  $1957.5\n" +
                "\t1 x 6 $810.0\n" +
                "\t1 x 9 $1147.5\n" +
                "13 VID  $2370.0\n" +
                "\t1 x 3 $570.0\n" +
                "\t2 x 5 $1800.0\n", BundleCalculator.calculateOrder(orderItems));
    }
}