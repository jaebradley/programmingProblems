package problems.impl;


import java.util.Arrays;

/**
 * You have a list of integers, and for each index you want to find the product of every integer except the integer at that index.
 * https://www.interviewcake.com/question/python/product-of-other-numbers
 */

public class IntegerProductIgnoringIndex {
    public static int[] calculateProducts(int[] values) {
        if (values.length <= 2) {
            throw new IllegalArgumentException("Invalid values");
        }

        int[] products = new int[values.length + 1];
        products[0] = 1;

        for (int i = 0; i < values.length; i++) {
            products[i + 1] = products[i] * values[i];
        }

        int multiplier = products[0];
        for (int j = values.length - 1; j >= 0; j--) {
            products[j] *= multiplier;
            multiplier *= values[j];
        }

        return Arrays.copyOfRange(products, 0, products.length - 1);
    }
}
