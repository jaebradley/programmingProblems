package problems.impl;

import org.junit.Assert;
import org.junit.Test;
import problems.interfaces.BinomialCoefficientCalculator;
import problems.interfaces.PascalsTriangleRowValuesCalculator;

import java.util.Arrays;

public class PascalsTriangleRowValuesCalculatorImplTest {

  private final BinomialCoefficientCalculator testBinomialCoefficientCalculator = new BinomialCoefficientCalculator() {
    @Override
    public int calculateBinomialCoefficient(final int n, final int k) {
      return 1;
    }
  };
  private final PascalsTriangleRowValuesCalculator pascalsTriangleRowValuesCalculator = new PascalsTriangleRowValuesCalculatorImpl(testBinomialCoefficientCalculator);

  @Test
  public void itShouldThrowException() {
    try {
      pascalsTriangleRowValuesCalculator.calculateRowValues(-1);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }
  }

  @Test
  public void itShouldCalculateRowValues() {
    Assert.assertEquals(pascalsTriangleRowValuesCalculator.calculateRowValues(3), Arrays.asList(1, 1, 1, 1));
  }
}