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

  @Override
  public long calculateDigitalRoot(final long value) {
    long digitSum = listSummator.sumList(digitsIdentifier.identifyDigits(value));
    while (digitSum > 9) {
      long previousDigitSum = digitSum;
      digitSum = listSummator.sumList(digitsIdentifier.identifyDigits(digitSum));
      if (previousDigitSum >= digitSum) {
        throw new RuntimeException("digital root computation not decreasing");
      }
    }
    if (digitSum < 0) {
      throw new RuntimeException("computed digital root is negative");
    }
    return digitSum;
  }
}
