package problems.utils;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class NumberUtilTest {

  @Test
  public void testConstruction() {
    final NumberUtil numberUtil = new NumberUtil();
    Assert.assertNotNull(numberUtil);
  }

  @Test
  public void testPositiveIntegerDigits() {
    try {
      NumberUtil.positiveIntegerDigits(-1);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    try {
      NumberUtil.positiveIntegerDigits(0);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    Assert.assertEquals(NumberUtil.positiveIntegerDigits(1), new ArrayList<>(Arrays.asList(1)));
    Assert.assertEquals(NumberUtil.positiveIntegerDigits(10), new ArrayList<>(Arrays.asList(1, 0)));
    Assert.assertEquals(NumberUtil.positiveIntegerDigits(100), new ArrayList<>(Arrays.asList(1, 0, 0)));
  }

}
