package com;

import com.calculator.Bundle;
import com.model.OrderItem;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderItemTest {
    @Test
    public void testConstructor() {
        OrderItem item = new OrderItem(10, Bundle.IMG);
        assertEquals(10, item.getNumber());
        assertEquals(5, item.getBundle().getBundles().get(0).getNumber());
        assertEquals(10, item.getBundle().getBundles().get(1).getNumber());
        assertEquals(450, item.getBundle().getBundles().get(0).getPrice(), 0);
        assertEquals(800, item.getBundle().getBundles().get(1).getPrice(), 0);
    }

    @Test
    public void testCalculateOrder() {
        OrderItem item = new OrderItem(10, Bundle.IMG);
        String s = item.calculateOrder();
        assertEquals("10 IMG  $800.0\n\t1 x 10 $800.0\n", s);
        item = new OrderItem(1, Bundle.IMG);
        s = item.calculateOrder();
        assertEquals("5 IMG  $450.0\n\t1 x 5 $450.0\n", s);
        item = new OrderItem(13, Bundle.IMG);
        s = item.calculateOrder();
        assertEquals("13 IMG  $1250.0\n\t1 x 5 $450.0\n\t1 x 10 $800.0\n", s);
        item = new OrderItem(19, Bundle.FLAC);
        s = item.calculateOrder();
        assertEquals("19 FLAC  $2722.5\n\t1 x 3 $427.5\n\t2 x 9 $2295.0\n", s);
    }
}