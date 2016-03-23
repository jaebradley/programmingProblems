package problems.impl;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.VowelOrderValidator;

public class VowelOrderValidatorImplTest {

    private final VowelOrderValidator vowelOrderValidator = new VowelOrderValidatorImpl();

    @Test
    public void testExpected() {
        Assert.assertTrue(vowelOrderValidator.areVowelsOrdered(""));
        Assert.assertTrue(vowelOrderValidator.areVowelsOrdered("J"));
        Assert.assertTrue(vowelOrderValidator.areVowelsOrdered("E"));
        Assert.assertTrue(vowelOrderValidator.areVowelsOrdered("AEIOUY"));
        Assert.assertFalse(vowelOrderValidator.areVowelsOrdered("EA"));
    }

}
