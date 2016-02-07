package problems.impl;

import org.junit.Assert;
import org.junit.Test;

public class VowelOrderValidatorImplTest {

    @Test
    public void testExpected() {
        Assert.assertFalse(VowelOrderValidatorImpl.areVowelsOrdered("JAYE"));
    }

}