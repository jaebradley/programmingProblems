package problems.impl;

import problems.interfaces.ArraySumEquivalenceValidator;

public class ArraySumEquivalenceValidatorImpl implements ArraySumEquivalenceValidator {
    @Override
    public boolean validateArraySumEquivalence(final int[] arr) {
        if (0 == arr.length) {
            throw new IllegalArgumentException("input array must contain at least one element");
        }

        if (1 == arr.length) {
            return 0 == arr[0];
        } else {
            int index = 0;
            int leftSum = arr[0];
            int rightSum = 0;
            for (int i = 1; i < arr.length; i++) {
                rightSum += arr[i];
            }
            while (leftSum != rightSum && index < arr.length - 1) {
                leftSum += arr[index + 1];
                rightSum -= arr[index + 1];
                ++index;
            }

            return leftSum == rightSum;
        }
    }
}
