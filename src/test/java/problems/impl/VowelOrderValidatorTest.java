package problems.impl;

import org.junit.Assert;
import org.junit.Test;

public class VowelOrderValidatorTest {

    @Test
    public void testExpected() {
        Assert.assertTrue(VowelOrderValidator.areVowelsOrdered(""));
        Assert.assertTrue(VowelOrderValidator.areVowelsOrdered("J"));
        Assert.assertTrue(VowelOrderValidator.areVowelsOrdered("E"));
        Assert.assertTrue(VowelOrderValidator.areVowelsOrdered("AEIOUY"));
        Assert.assertFalse(VowelOrderValidator.areVowelsOrdered("EA"));
    }

}
