package main.java.problems.impl;

import org.junit.Assert;
import org.junit.Test;

public class ReverseWordsInStringImplTest {
    private final ReverseWordsInStringImpl reverseWordsInString = new ReverseWordsInStringImpl();

    @Test
    public void testExpected() {
        final String testString = "a fox jumped over a log";
        final String expectedReverseString = "a xof depmuj revo a gol";
        final String result = reverseWordsInString.reverseWordsInString(testString);
        final String resultStackImpl = reverseWordsInString.reverseWordsInStringUsingStack(testString);
        Assert.assertEquals(expectedReverseString, result);
        Assert.assertEquals(expectedReverseString, resultStackImpl);
    }

    @Test
    public void testExpectedWithSpaces() {
        final String testString = " a fox   jumped      over a log  ";
        final String expectedReverseString = " a xof   depmuj      revo a gol  ";
        final String result = reverseWordsInString.reverseWordsInString(testString);
        final String resultStackImpl = reverseWordsInString.reverseWordsInStringUsingStack(testString);
        Assert.assertEquals(expectedReverseString, result);
        Assert.assertEquals(expectedReverseString, resultStackImpl);
    }
}