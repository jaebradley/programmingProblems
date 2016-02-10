package problems.impl;

import org.junit.Assert;
import org.junit.Test;

public class BracketPairsValidatorTest {

  @Test
  public void testExpected() {
    Assert.assertFalse(BracketPairsValidator.validBracketPairs("[a{)}]"));
  }

}
