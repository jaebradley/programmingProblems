package problems.impl;

import org.junit.Assert;
import org.junit.Test;

public class ReverseWordOrderInStringImplTest {
    private final ReverseWordOrderInStringImpl reverseWordOrderInString = new ReverseWordOrderInStringImpl();

    @Test
    public void testExpected() {
        final String testString = "the brown fox jumped over the log";
        final String expectedResult = "log the over jumped fox brown the";
        Assert.assertEquals(expectedResult, reverseWordOrderInString.reverseWordOrder(testString));
    }

}