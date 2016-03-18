package problems.utils;

import org.junit.Assert;
import org.junit.Test;

public class FractionTest {

  @Test
  public void testExpected() {
    try {
      new Fraction(1, 0);
      Assert.fail();
    } catch (RuntimeException e) {
      // expected
    }
    final Fraction fraction = new Fraction(-2, 2);
    Assert.assertNotNull(fraction);
    Assert.assertEquals(fraction.getNumerator(), -2);
    Assert.assertEquals(fraction.getDenominator(), 2);
  }
}
