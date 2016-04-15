package problems.impl;

import problems.interfaces.BinomialCoefficientCalculator;
import problems.interfaces.FactorialCalculator;

public class BinomialCoefficientCalculatorImpl implements BinomialCoefficientCalculator {
  private final FactorialCalculator factorialCalculator;

  public BinomialCoefficientCalculatorImpl(final FactorialCalculator factorialCalculator) {
    this.factorialCalculator = factorialCalculator;
  }

  /**
   * Calculate binomial coefficient for a given n and k value
   *
   * See https://en.wikipedia.org/wiki/Binomial_coefficient for more information about binomial coefficients
   * @param n
   * @param k
   * @return binomial coefficient given an n and k value
   */

  @Override
  public int calculateBinomialCoefficient(final int n, final int k) {
    if (n < 0) {
      throw new IllegalArgumentException("n value cannot be negative");
    }

    if (k < 0) {
      throw new IllegalArgumentException("k value cannot be negative");
    }

    if (n < k) {
      throw new IllegalArgumentException("n value cannot be less than k value");
    }

    return factorialCalculator.calculateFactorial(n) / (factorialCalculator.calculateFactorial(k) * factorialCalculator.calculateFactorial(n - k));
  }
}
