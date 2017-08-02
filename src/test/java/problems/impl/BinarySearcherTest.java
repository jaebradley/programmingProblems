package problems.impl;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class BinarySearcherTest {
    private final int[] values = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

    @Test
    public void itShouldFindElements() {
        for (int value : values) {
            assertEquals(value - 1, BinarySearcher.search(values, value));
        }
    }

    @Test
    public void itShouldThrowForAnEmptyArray() {
        try {
            BinarySearcher.search(new int[] {}, 1);
        } catch (NoSuchElementException e) {
            // expected
        }
    }

    @Test
    public void itShouldThrowSinceItCannotFindElement() {
        try {
            BinarySearcher.search(values, -1);
        } catch (NoSuchElementException e) {
            // expected
        }
    }

    @Test
    public void itShouldFindElementInSingleElementArray() {
        assertEquals(0, BinarySearcher.search(new int[] { 10 }, 10));
    }
}