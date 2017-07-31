package problems.impl;

/**
 * Given a list of integers, find the highest product you can get from three of the integers.
 *
 * https://www.interviewcake.com/question/python/highest-product-of-3
 */

public class MaximumTripletProductCalculator {
    public static int calculateMaximumTripletProduct(int[] values) {
        if (values.length < 3) {
            throw new IllegalArgumentException("Not enough values");
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;

        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int i : values) {
            if (i > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = i;
            } else if (i > secondMax) {
                thirdMax = secondMax;
                secondMax = i;
            } else if (i > thirdMax) {
                thirdMax = i;
            }

            if (i < min) {
                secondMin = min;
                min = i;
            } else if (i < secondMin) {
                secondMin = i;
            }
        }

        int maxProduct = max * secondMax * thirdMax;
        int maxProductUsingMinimumValues = min * secondMin * max;

        if (maxProduct > maxProductUsingMinimumValues) {
            return maxProduct;
        }

        return maxProductUsingMinimumValues;
    }
}
