package com;

import org.junit.Test;

import static org.junit.Assert.*;

public class PairTest {
    @Test
    public void test() {
        Pair pair = new Pair(10, 450);
        assertEquals(10, pair.getNumber());
        assertEquals(450, pair.getPrice(), 0);
    }
}