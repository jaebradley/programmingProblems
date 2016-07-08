package problems.impl;

import org.junit.Assert;
import org.junit.Test;
import problems.interfaces.PalindromeConversionCounter;

public class PalindromeConversionCounterImplTest {

  private final PalindromeConversionCounter counter = new PalindromeConversionCounterImpl();

  @Test
  public void testExpectedCounting() {
    Assert.assertEquals(counter.count("A"), 0);
    Assert.assertEquals(counter.count("AB"), 1);
    Assert.assertEquals(counter.count("ABA"), 0);
    Assert.assertEquals(counter.count("ACBD"), 4);
  }

  @Test
  public void testExpectedException() {
    try {
      counter.count("1");
    } catch (IllegalArgumentException e) {
      // expected
    }

    try {
      counter.count("A1B");
    } catch (IllegalArgumentException e) {
      // expected
    }
  }
}