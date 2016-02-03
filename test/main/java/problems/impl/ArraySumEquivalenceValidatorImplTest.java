package problems.impl;

import org.junit.Assert;
import org.junit.Test;

public class ArraySumEquivalenceValidatorImplTest {
    private final ArraySumEquivalenceValidatorImpl arraySumEquivalenceValidator = new ArraySumEquivalenceValidatorImpl();

    @Test
    public void itShouldReturnTrue() {
        final int[] candidate1 = new int[] {0};
        Assert.assertTrue(arraySumEquivalenceValidator.validateArraySumEquivalence(candidate1));

        final int[] candidate2 = new int[] {0, 0};
        Assert.assertTrue(arraySumEquivalenceValidator.validateArraySumEquivalence(candidate2));

        final int[] candidate3 = new int[] {0, 0, 0};
        Assert.assertTrue(arraySumEquivalenceValidator.validateArraySumEquivalence(candidate3));

        final int[] candidate4 = new int[] {1, 0, 1};
        Assert.assertTrue(arraySumEquivalenceValidator.validateArraySumEquivalence(candidate4));

        final int[] candidate5 = new int[] {1, 2, 3, 4, 2};
        Assert.assertTrue(arraySumEquivalenceValidator.validateArraySumEquivalence(candidate5));
    }

    @Test
    public void itShouldReturnFalse() {
        final int[] candidate1 = new int[] {1};
        Assert.assertFalse(arraySumEquivalenceValidator.validateArraySumEquivalence(candidate1));

        final int[] candidate2 = new int[] {0, 1};
        Assert.assertFalse(arraySumEquivalenceValidator.validateArraySumEquivalence(candidate2));

        final int[] candidate3 = new int[] {1, 0};
        Assert.assertFalse(arraySumEquivalenceValidator.validateArraySumEquivalence(candidate3));

        final int[] candidate4 = new int[] {1, 1, 1};
        Assert.assertFalse(arraySumEquivalenceValidator.validateArraySumEquivalence(candidate4));

        final int[] candidate5 = new int[] {1, 2, 3, 3, 2};
        Assert.assertFalse(arraySumEquivalenceValidator.validateArraySumEquivalence(candidate5));
    }

    @Test
    public void itShouldThrowException() {
        final int[] candidate = new int[]{};
        try {
            arraySumEquivalenceValidator.validateArraySumEquivalence(candidate);
            Assert.fail();
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}