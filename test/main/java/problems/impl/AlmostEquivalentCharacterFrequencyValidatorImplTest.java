package main.java.problems.impl;

import org.junit.Assert;
import org.junit.Test;

public class AlmostEquivalentCharacterFrequencyValidatorImplTest {
    private final AlmostEquivalentCharacterFrequencyValidatorImpl almostEquivalentCharacterFrequencyValidator = new AlmostEquivalentCharacterFrequencyValidatorImpl();

    @Test
    public void itShouldReturnTrue() {
        final String candidate1 = "aabb";
        Assert.assertTrue(almostEquivalentCharacterFrequencyValidator.validateAlmostEquivalentCharacterFrequency(candidate1));

        final String candidate2 = "a";
        Assert.assertTrue(almostEquivalentCharacterFrequencyValidator.validateAlmostEquivalentCharacterFrequency(candidate2));

        final String candidate3 = "aabbc";
        Assert.assertTrue(almostEquivalentCharacterFrequencyValidator.validateAlmostEquivalentCharacterFrequency(candidate3));
    }

    @Test
    public void itShouldReturnFalse() {
        final String candidate1 = "aabbcd";
        Assert.assertFalse(almostEquivalentCharacterFrequencyValidator.validateAlmostEquivalentCharacterFrequency(candidate1));

        final String candidate2 = "abbc";
        Assert.assertFalse(almostEquivalentCharacterFrequencyValidator.validateAlmostEquivalentCharacterFrequency(candidate2));
    }

    @Test
    public void itShouldReturnException() {
        final String candidate1 = "";
        try {
            almostEquivalentCharacterFrequencyValidator.validateAlmostEquivalentCharacterFrequency(candidate1);
            Assert.fail();
        } catch (IllegalArgumentException e) {
            // expected
        }

        final String candidate2 = "    ";
        try {
            almostEquivalentCharacterFrequencyValidator.validateAlmostEquivalentCharacterFrequency(candidate2);
            Assert.fail();
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}