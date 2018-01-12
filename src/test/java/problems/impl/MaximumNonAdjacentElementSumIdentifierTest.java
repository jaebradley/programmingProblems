package problems.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumNonAdjacentElementSumIdentifierTest {
    @Test
    public void itShouldIdentifySum1() {
        int[] values = new int[] { 5, 1, 1, 7, 3};
        int expected = 12;
        assertEquals(expected, MaximumNonAdjacentElementSumIdentifier.identify(values));
    }

    @Test
    public void itShouldThrowAnExceptionForNullValues() {
        try {
            MaximumNonAdjacentElementSumIdentifier.identify(null);
        } catch (RuntimeException e) {
            // expected
        }
    }

    @Test
    public void itShouldThrowAnExceptionForEmptyValues() {
        try {
            MaximumNonAdjacentElementSumIdentifier.identify(new int[] {});
        } catch (RuntimeException e) {
            // expected
        }
    }

    @Test
    public void itShouldReturnValueForSingleElementValues() {
        int value = 5;
        int[] values = new int[] { value };
        assertEquals(value, MaximumNonAdjacentElementSumIdentifier.identify(values));
    }

    @Test
    public void itShouldReturnGreaterValueForTwoElementValues() {
        assertEquals(5, MaximumNonAdjacentElementSumIdentifier.identify(new int[]{4, 5}));
    }

    @Test
    public void itShouldReturnGreatestSingleValueForThreeElementValues() {
        assertEquals(3, MaximumNonAdjacentElementSumIdentifier.identify(new int[]{-1, 1, 3}));
    }

    @Test
    public void itShouldReturnGreatestCombinedValuesForThreeElementValues() {
        assertEquals(8, MaximumNonAdjacentElementSumIdentifier.identify(new int[]{2, 7, 6}));
    }
}