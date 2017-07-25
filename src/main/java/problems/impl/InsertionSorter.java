package problems.impl;

/**
 * Insertion sort, in place
 * https://en.wikipedia.org/wiki/Insertion_sort
 *
 * The idea is to start with the second element in the input array (in the single element case, it's already sorted).
 * Moving backwards, compare the value against each previous element in the array until
 * 1. You reach the beginning of the array
 * 2. You find an element that is <= your value
 * As you continue backwards, move each value you consider "up" an index
 */

public class InsertionSorter {
    public static void sort(int[] values) {
        for (int index = 1; index < values.length; index++) {
            int value = values[index];
            int nextIndex = index - 1;
            while (nextIndex >= 0 && values[nextIndex] > value) {
                values[nextIndex + 1] = values[nextIndex];
                nextIndex--;
            }
            values[nextIndex + 1] = value;
        }
    }
}
