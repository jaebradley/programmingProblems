package problems.impl;

/**
 * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers.
 */

public class MaximumNonAdjacentElementSumIdentifier {
    public static int identify(int[] values) {
        if (values == null || values.length == 0) {
            throw new RuntimeException("Unable to identify sum");
        }

        if (values.length == 1) {
            return values[0];
        }

        int firstSum = 0;
        int secondSum = values[0];
        int previousValueSum = values[1];

        for (int i = 2; i < values.length; i++) {
            int value = values[i];
            int maximumCurrentElementSum = Math.max(firstSum, secondSum) + value;
            firstSum = Math.max(firstSum, secondSum);
            secondSum = previousValueSum;
            previousValueSum = maximumCurrentElementSum;
        }

        return Math.max(secondSum, previousValueSum);
    }
}
