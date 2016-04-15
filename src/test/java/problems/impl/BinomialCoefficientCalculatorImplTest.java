package problems.impl;

import org.junit.Assert;
import org.junit.Test;
import problems.interfaces.BinomialCoefficientCalculator;
import problems.interfaces.FactorialCalculator;

public class BinomialCoefficientCalculatorImplTest {

  private final FactorialCalculator testFactorialCalculator = new FactorialCalculator() {
    @Override
    public int calculateFactorial(final int n) {
      return 1;
    }
  };
  private final BinomialCoefficientCalculator binomialCoefficientCalculator = new BinomialCoefficientCalculatorImpl(testFactorialCalculator);

  @Test
  public void itShouldThrowException() {
    try {
      binomialCoefficientCalculator.calculateBinomialCoefficient(-1, 0);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    try {
      binomialCoefficientCalculator.calculateBinomialCoefficient(0, -1);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    try {
      binomialCoefficientCalculator.calculateBinomialCoefficient(5, 10);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }
  }

  @Test
  public void itShouldCalculate() {
    Assert.assertEquals(binomialCoefficientCalculator.calculateBinomialCoefficient(10, 5), 1);
    Assert.assertEquals(binomialCoefficientCalculator.calculateBinomialCoefficient(10, 10), 1);
  }
}