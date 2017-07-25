package problems.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class InsertionSorterTest {
    @Test
    public void itShouldNotChangeAlreadySortedArray() {
        int[] values = {1, 2, 3, 4};
        int[] expected = {1, 2, 3, 4};
        InsertionSorter.sort(values);
        assertArrayEquals(expected, values);
    }

    @Test
    public void itShouldSortEmptyArray() {
        int[] values = {};
        int[] expected = {};
        InsertionSorter.sort(values);
        assertArrayEquals(expected, values);
    }

    @Test
    public void itShouldSortSingleElementArray() {
        int[] values = {1};
        int[] expected = {1};
        InsertionSorter.sort(values);
        assertArrayEquals(expected, values);
    }

    @Test
    public void itShouldSortArray() {
        int[] values = {5, 4, 3, 4, 6, 5, 1, 4};
        int[] expected = {1, 3, 4, 4, 4, 5, 5, 6};
        InsertionSorter.sort(values);
        assertArrayEquals(expected, values);
    }
}