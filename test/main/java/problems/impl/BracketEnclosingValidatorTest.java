package problems.impl;

import org.junit.Assert;
import org.junit.Test;

public class BracketEnclosingValidatorTest {

  @Test
  public void testExpected() {
    Assert.assertTrue(BracketEnclosingValidator.validBracketEnclosing("[{()}]"));
  }

}
