package com;

import com.calculator.Bundle;
import com.model.Order;
import com.model.OrderItem;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderTest {

    @Test
    public void getOrder() {
        Order order = new Order(null);
        OrderItem img = order.getOrder("IMG", 21);
        assertEquals(21, img.getNumber());
        assertEquals(Bundle.IMG, img.getBundle());
        img = order.getOrder("VID", 11);
        assertEquals(11, img.getNumber());
        assertEquals(Bundle.VID, img.getBundle());
        img = order.getOrder("FLAC", 12);
        assertEquals(12, img.getNumber());
        assertEquals(Bundle.FLAC, img.getBundle());
    }
}