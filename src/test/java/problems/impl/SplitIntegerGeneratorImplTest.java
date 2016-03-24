package problems.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.DigitCountCalculator;
import problems.interfaces.SplitIntegerGenerator;
import problems.utils.SplitInteger;

public class SplitIntegerGeneratorImplTest {
  private final DigitCountCalculator oddDigitCountCalculator = new DigitCountCalculator() {
    @Override public int calculateDigitCount(final int number) {
      return 1;
    }
  };
  private final DigitCountCalculator evenDigitCountCalculator = new DigitCountCalculator() {
    @Override public int calculateDigitCount(final int number) {
      return 2;
    }
  };
  private final DigitCountCalculator zeroDigitCountCalculator = new DigitCountCalculator() {
    @Override public int calculateDigitCount(final int number) {
      return 0;
    }
  };
  private final SplitIntegerGenerator oddDigitSplitIntegerGenerator = new SplitIntegerGeneratorImpl(oddDigitCountCalculator);
  private final SplitIntegerGenerator evenDigitSplitIntegerGenerator = new SplitIntegerGeneratorImpl(evenDigitCountCalculator);
  private final SplitIntegerGenerator zeroDigitSplitIntegerGenerator = new SplitIntegerGeneratorImpl(zeroDigitCountCalculator);

  @Test
  public void testExpected() {
    try {
      oddDigitSplitIntegerGenerator.generateSplitInteger(-1);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    try {
      oddDigitSplitIntegerGenerator.generateSplitInteger(0);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    final SplitInteger singleInteger = oddDigitSplitIntegerGenerator.generateSplitInteger(1);
    Assert.assertEquals(singleInteger.getRightDigits(), new ArrayList<>(Arrays.asList(1)));
    Assert.assertTrue(singleInteger.getLeftDigits().isEmpty());

    final SplitInteger oddDigitCountSplitInteger = oddDigitSplitIntegerGenerator.generateSplitInteger(123456789);
    Assert.assertEquals(oddDigitCountSplitInteger.getLeftDigits(), new ArrayList());
    Assert.assertEquals(oddDigitCountSplitInteger.getRightDigits(), new ArrayList(Arrays.asList(1)));

    final SplitInteger evenDigitCountSplitInteger = evenDigitSplitIntegerGenerator.generateSplitInteger(12345678);
    Assert.assertEquals(evenDigitCountSplitInteger.getLeftDigits(), new ArrayList(Arrays.asList(1)));
    Assert.assertEquals(evenDigitCountSplitInteger.getRightDigits(), new ArrayList(Arrays.asList(2)));
  }

}
