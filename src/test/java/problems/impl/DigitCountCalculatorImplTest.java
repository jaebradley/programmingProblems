package problems.impl;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.DigitCountCalculator;

public class DigitCountCalculatorImplTest {

  private final DigitCountCalculator digitCountCalculator = new DigitCountCalculatorImpl();

  @Test
  public void itShouldCountDigitsSuccessfully() {
    Assert.assertEquals(digitCountCalculator.calculateDigitCount(0), 1);
    Assert.assertEquals(digitCountCalculator.calculateDigitCount(-1), 1);
    Assert.assertEquals(digitCountCalculator.calculateDigitCount(1), 1);
    Assert.assertEquals(digitCountCalculator.calculateDigitCount(-9), 1);
    Assert.assertEquals(digitCountCalculator.calculateDigitCount(9), 1);
    Assert.assertEquals(digitCountCalculator.calculateDigitCount(-10), 2);
    Assert.assertEquals(digitCountCalculator.calculateDigitCount(10), 2);
  }
}
