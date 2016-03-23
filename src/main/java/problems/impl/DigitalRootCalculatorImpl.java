package problems.impl;

import problems.interfaces.DigitalRootCalculator;
import problems.interfaces.DigitsIdentifier;
import problems.interfaces.ListSummator;

public class DigitalRootCalculatorImpl implements DigitalRootCalculator{
  private final ListSummator listSummator;
  private final DigitsIdentifier digitsIdentifier;

  public DigitalRootCalculatorImpl(final ListSummator listSummator,
                                   final DigitsIdentifier digitsIdentifier) {
    this.listSummator = listSummator;
    this.digitsIdentifier = digitsIdentifier;
  }

  /**
   * The digital root of a non-negative integer is the single digit value obtained by an iterative process of summing
   * digits, on each iteration using the result from the previous iteration to compute a digit sum.
   * The process continues until a single-digit number is reached.
   *
   * https://en.wikipedia.org/wiki/Digital_root
   *
   * @param value number
   * @return digital root of the inputted number
   */
  @Override
  public long calculateDigitalRoot(final long value) {
    long digitSum = listSummator.sumList(digitsIdentifier.identifyDigits(value));
    while (digitSum > 9) {
      long previousDigitSum = digitSum;
      digitSum = listSummator.sumList(digitsIdentifier.identifyDigits(digitSum));
      if (previousDigitSum <= digitSum) {
        throw new RuntimeException("digital root computation not decreasing");
      }
    }
    if (digitSum < 0) {
      throw new RuntimeException("computed digital root is negative");
    }
    return digitSum;
  }
}
