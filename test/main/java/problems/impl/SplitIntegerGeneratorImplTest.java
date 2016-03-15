package problems.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.SplitIntegerGenerator;
import problems.utils.SplitInteger;

public class SplitIntegerGeneratorImplTest {
  private final SplitIntegerGenerator splitIntegerGenerator = new SplitIntegerGeneratorImpl();

  @Test
  public void testExpected() {
    try {
      splitIntegerGenerator.generateSplitInteger(-1);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    try {
      splitIntegerGenerator.generateSplitInteger(0);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    final SplitInteger singleInteger = splitIntegerGenerator.generateSplitInteger(1);
    Assert.assertEquals(singleInteger.getRightDigits(), new ArrayList<>(Arrays.asList(1)));
    Assert.assertTrue(singleInteger.getLeftDigits().isEmpty());

    final SplitInteger oddDigitCountSplitInteger = splitIntegerGenerator.generateSplitInteger(123456789);
    Assert.assertEquals(oddDigitCountSplitInteger.getLeftDigits(), new ArrayList(Arrays.asList(1, 2, 3, 4)));
    Assert.assertEquals(oddDigitCountSplitInteger.getRightDigits(), new ArrayList(Arrays.asList(5, 6, 7, 8, 9)));

    final SplitInteger evenDigitCountSplitInteger = splitIntegerGenerator.generateSplitInteger(12345678);
    Assert.assertEquals(evenDigitCountSplitInteger.getLeftDigits(), new ArrayList(Arrays.asList(1, 2, 3, 4)));
    Assert.assertEquals(evenDigitCountSplitInteger.getRightDigits(), new ArrayList(Arrays.asList(5, 6, 7, 8)));
  }

}
