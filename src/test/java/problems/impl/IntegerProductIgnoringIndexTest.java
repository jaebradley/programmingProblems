package problems.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerProductIgnoringIndexTest {
    @Test
    public void itShouldThrowForEmptyIndex() {
        try {
            IntegerProductIgnoringIndex.calculateProducts(new int[] {});
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    @Test
    public void itShouldReturnOneElementIndex() {
        try {
            IntegerProductIgnoringIndex.calculateProducts(new int[] { 10 });
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    @Test
    public void itShouldReturnProduct() {
        int[] values = new int[] {
                2, 7, 4, 3
        };
        int[] expected = new int[] {
                84, 24, 42, 56
        };

        assertArrayEquals(expected, IntegerProductIgnoringIndex.calculateProducts(values));
    }
}