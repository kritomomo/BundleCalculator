package com.calculator;

import com.model.OrderItem;

import java.util.List;

public class BundleCalculator {

    public static int getMinCount(int totalOrder, Bundle bundle, int[] bundleUsed) {
        //Save the minimum number of bundles
        int[] f = new int[totalOrder + 1];
        f[0] = 0;
        //Require f[order], first find f[1]~f[order-1]
        for (int order = 1; order < totalOrder + 1; order++) {
            //Attach initial value to f[order]
            if (order >= bundle.getBundles().get(0).getNumber()) {
                f[order] = f[order - bundle.getBundles().get(0).getNumber()] + 1;
                //Save the bundle type to bundleUsed
                bundleUsed[order] = bundle.getBundles().get(0).getNumber();
            } else {
                f[order] = Integer.MAX_VALUE - totalOrder;
            }
            //View other larger bundles
            for (int type = 1; type < bundle.getBundles().size(); type++) {
                if (order >= bundle.getBundles().get(type).getNumber() && (f[order] > f[order - bundle.getBundles().get(type).getNumber()] + 1)) {
                    f[order] = f[order - bundle.getBundles().get(type).getNumber()] + 1;
                    bundleUsed[order] = bundle.getBundles().get(type).getNumber();
                }
            }
        }
        return f[totalOrder];
    }

    public static String calculateOrder(List<OrderItem> orders) {
        StringBuilder builder = new StringBuilder();
        for (OrderItem order : orders) {
            builder.append(order.calculateOrder());
        }
        return builder.toString();
    }

}
