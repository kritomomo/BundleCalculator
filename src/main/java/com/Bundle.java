package com;

import java.util.ArrayList;
import java.util.List;

public enum Bundle {
    IMG(new int[]{5, 10}, new double[]{450, 800}),
    FLAC(new int[]{3, 6, 9}, new double[]{427.5, 810, 1147.5}),
    VID(new int[]{3, 5, 9}, new double[]{570, 900, 1530});

    private List<Pair> bundles;

    private Bundle(int[] numbers, double[] prices) {
        bundles = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            bundles.add(new Pair(numbers[i], prices[i]));
        }
    }

    public List<Pair> getBundles() {
        return bundles;
    }

}
