package problems.impl;

import problems.interfaces.FactorialCalculator;

public class FactorialCalculatorImpl implements FactorialCalculator {

  /**
   * Should calculate factorial for inputted integer value
   * @param n integer value to calculate factorial from
   * @return factorial value for input integer
   */
  @Override
  public int calculateFactorial(final int n) {
    if (n < 0) {
      throw new IllegalArgumentException("n value should be non-negative");
    }

    int factorialValue = 1;

    if (n == 0) {
      return factorialValue;
    }

    for (int multiplier = n; multiplier > 0; multiplier--) {
      factorialValue *= multiplier;
    }

    return factorialValue;
  }
}
