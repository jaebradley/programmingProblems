package problems.impl;

import java.util.NoSuchElementException;

public class BinarySearcher {
    /**
     * Executes a binary search for some target value given an input array of sorted values
     * @param values a sorted array
     * @param target a value to search for
     * @return the index of the target value, if it exists. If the target value does not exist, a NoSuchElementException is thrown.
     */
    public static int search(int[] values, int target) {
        return searchSubArray(values, 0, values.length - 1, target);
    }

    private static int searchSubArray(int[] values, int leftIndex, int rightIndex, int target) {
        if (values.length == 0 || leftIndex < 0 || rightIndex < 0) {
            throw new NoSuchElementException(String.format("Unable to find target: {} in values", target));
        }

        if (target == values[leftIndex]) {
            return leftIndex;
        }

        if (target == values[rightIndex]) {
            return rightIndex;
        }

        int middleIndex = Double.valueOf(Math.floor((rightIndex - leftIndex) / 2)).intValue();

        int middleValue = values[middleIndex];

        if (target < middleValue) {
            return searchSubArray(values, leftIndex + 1, middleIndex - 1, target);
        }

        else if (target > middleValue) {
            return searchSubArray(values, middleIndex + 1, rightIndex - 1, target);
        }

        else {
            return middleIndex;
        }
    }
}
