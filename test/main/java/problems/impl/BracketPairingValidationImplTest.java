package main.java.problems.impl;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BracketPairingValidationImplTest {
    private final BracketPairingValidationImpl bracketPairingValidation = new BracketPairingValidationImpl();

    @Test
    public void testBracketValidation() {
        final List<String> testStrings = new ArrayList<>();
        testStrings.add("[]");
        testStrings.add("{}");
        testStrings.add("()");
        testStrings.add("[{()}]");
        testStrings.add("({[]})");
        testStrings.add("{([])}");
        testStrings.add("{}[]()");
        testStrings.add("foo");
        for (final String testString : testStrings) {
            Assert.assertTrue(bracketPairingValidation.validateBracketPairs(testString));
        }
    }

    @Test
    public void testBracketInvalidation() {
        final List<String> testStrings = new ArrayList<>();
        testStrings.add("[");
        testStrings.add("{");
        testStrings.add("(");
        testStrings.add("[()}]");
        testStrings.add("([]})");
        testStrings.add("{[}]");
        testStrings.add("}](");
        testStrings.add("{}[](");
        testStrings.add("{f}[o](o");
        for (final String testString : testStrings) {
            Assert.assertFalse(bracketPairingValidation.validateBracketPairs(testString));
        }
    }

}