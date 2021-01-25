package com;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OrderInputTest {
    @Test
    public void test() {
        OrderInput input = new OrderInput();
        ArrayList<String> s = input.readFile("orderTest.txt");
        String[] expected = new String[] {"11", "IMG", "12", "FLAC", "13", "VID"};
        for (int i = 0; i < s.size(); i++) {
            assertEquals(s.get(i), expected[i]);
        }
    }

}