package problems.impl;

import org.junit.Assert;
import org.junit.Test;

public class VowelOrderValidatorTest {

    @Test
    public void testExpected() {
        Assert.assertTrue(VowelOrderValidator.areVowelsOrderedUsingStack("AEIOUY"));
        Assert.assertFalse(VowelOrderValidator.areVowelsOrderedUsingStack("EA"));
        Assert.assertFalse(VowelOrderValidator.areVowelsOrderedUsingStack("AEIOYU"));

        Assert.assertTrue(VowelOrderValidator.areVowelsOrdered("AEIOUY"));
        Assert.assertFalse(VowelOrderValidator.areVowelsOrdered("EA"));
        Assert.assertFalse(VowelOrderValidator.areVowelsOrdered("AEIOYU"));
    }

}
