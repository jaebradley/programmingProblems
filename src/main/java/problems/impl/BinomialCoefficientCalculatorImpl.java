package problems.impl;

import problems.interfaces.BinomialCoefficientCalculator;
import problems.interfaces.FactorialCalculator;

public class BinomialCoefficientCalculatorImpl implements BinomialCoefficientCalculator {
  private final FactorialCalculator factorialCalculator;

  public BinomialCoefficientCalculatorImpl(final FactorialCalculator factorialCalculator) {
    this.factorialCalculator = factorialCalculator;
  }

  @Override
  public int calculateBinomialCoefficient(final int n, final int k) {
    if (n < 0) {
      throw new IllegalArgumentException("n value cannot be negative");
    }

    if (k < 0) {
      throw new IllegalArgumentException("k value cannot be negative");
    }

    return factorialCalculator.calculateFactorial(n) / (factorialCalculator.calculateFactorial(k) * factorialCalculator.calculateFactorial(n - k));
  }
}
