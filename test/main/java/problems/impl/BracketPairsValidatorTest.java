package problems.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class BracketPairsValidatorTest {

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
      Assert.assertTrue(BracketPairsValidator.validBracketPairs(testString));
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
      Assert.assertFalse(BracketPairsValidator.validBracketPairs(testString));
    }
  }

}
