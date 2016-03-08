package problems.utils;

import org.junit.Assert;
import org.junit.Test;

public class NumberUtilTest {

  @Test
  public void testPositiveIntegerDigitCount() {
    try {
      NumberUtil.positiveIntegerDigitCount(-1);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    try {
      NumberUtil.positiveIntegerDigitCount(0);
      Assert.fail();
    } catch (IllegalArgumentException e){
      // expected
    }

    Assert.assertEquals(NumberUtil.positiveIntegerDigitCount(1), 1);
    Assert.assertEquals(NumberUtil.positiveIntegerDigitCount(2), 1);
    Assert.assertEquals(NumberUtil.positiveIntegerDigitCount(9), 1);
    Assert.assertEquals(NumberUtil.positiveIntegerDigitCount(10), 2);
    Assert.assertEquals(NumberUtil.positiveIntegerDigitCount(99), 2);
    Assert.assertEquals(NumberUtil.positiveIntegerDigitCount(100), 3);
  }

}
