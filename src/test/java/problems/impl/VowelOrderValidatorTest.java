package problems.impl;

import org.junit.Assert;
import org.junit.Test;

public class VowelOrderValidatorTest {

    @Test
    public void testExpected() {
        Assert.assertFalse(VowelOrderValidator.areVowelsOrdered("JAYE"));
    }

}