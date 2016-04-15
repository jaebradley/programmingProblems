package problems.impl;

import org.junit.Assert;
import org.junit.Test;
import problems.interfaces.FactorialCalculator;

public class FactorialCalculatorImplTest {

  private final FactorialCalculator factorialCalculator = new FactorialCalculatorImpl();

  @Test
  public void itShouldThrowException() {
    try {
      factorialCalculator.calculateFactorial(-1);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }
  }

  @Test
  public void itShouldCalculateFactorial() {
    Assert.assertEquals(factorialCalculator.calculateFactorial(0), 1);
    Assert.assertEquals(factorialCalculator.calculateFactorial(1), 1);
    Assert.assertEquals(factorialCalculator.calculateFactorial(3), 6);
  }
}