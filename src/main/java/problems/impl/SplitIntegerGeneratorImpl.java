package problems.impl;

import java.util.List;

import problems.interfaces.DigitCountCalculator;
import problems.interfaces.DigitsIdentifier;
import problems.interfaces.SplitIntegerGenerator;
import problems.utils.SplitInteger;

public class SplitIntegerGeneratorImpl implements SplitIntegerGenerator {

  private final DigitCountCalculator digitCountCalculator;
  private final DigitsIdentifier digitsIdentifier;

  public SplitIntegerGeneratorImpl(final DigitCountCalculator digitCountCalculator, final DigitsIdentifier digitsIdentifier) {
    this.digitCountCalculator = digitCountCalculator;
    this.digitsIdentifier = digitsIdentifier;
  }

  @Override
  public SplitInteger generateSplitInteger(final int candidate) {
    if (candidate < 1) {
      throw new IllegalArgumentException("candidate value must be a positive integer");
    }

    final int digitCount = digitCountCalculator.calculateDigitCount(candidate);
    final List<Integer> digits = digitsIdentifier.identifyDigits(candidate);
    final List<Integer> leftDigits = digits.subList(0, Math.floorDiv(digitCount, 2));
    final List<Integer> rightDigits = digits.subList(Math.floorDiv(digitCount, 2), digitCount);
    return new SplitInteger(leftDigits, rightDigits);
  }
}
