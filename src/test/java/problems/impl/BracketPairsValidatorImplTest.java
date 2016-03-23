package problems.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.BracketPairsValidator;

public class BracketPairsValidatorImplTest {

  private final BracketPairsValidator bracketPairsValidator = new BracketPairsValidatorImpl();

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
      Assert.assertTrue(bracketPairsValidator.validBracketPairs(testString));
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
      Assert.assertFalse(bracketPairsValidator.validBracketPairs(testString));
    }
  }

}
