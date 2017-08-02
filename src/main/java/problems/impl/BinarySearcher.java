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
        if (values.length == 0) {
            throw new NoSuchElementException(String.format("Unable to find target: {} in values", target));
        }

        int leftIndex = 0;
        int rightIndex = values.length - 1;
        while (leftIndex < rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
            int middleValue = values[middleIndex];

            if (target < middleValue) {
                rightIndex = middleIndex;
            } else if (target > middleValue) {
                leftIndex = middleIndex + 1;
            } else {
                return middleIndex;
            }
        }

        return leftIndex;
    }
}
