package problems.impl;

import java.util.List;

import problems.interfaces.DigitCountCalculator;
import problems.interfaces.SplitIntegerGenerator;
import problems.utils.NumberUtil;
import problems.utils.SplitInteger;

public class SplitIntegerGeneratorImpl implements SplitIntegerGenerator {

  private final DigitCountCalculator digitCountCalculator;

  public SplitIntegerGeneratorImpl(final DigitCountCalculator digitCountCalculator) {
    this.digitCountCalculator = digitCountCalculator;
  }

  @Override
  public SplitInteger generateSplitInteger(final int candidate) {
    if (candidate < 1) {
      throw new IllegalArgumentException("candidate value must be a positive integer");
    }

    final int digitCount = digitCountCalculator.calculateDigitCount(candidate);
    final List<Integer> digits = NumberUtil.positiveIntegerDigits(candidate);
    final List<Integer> leftDigits = digits.subList(0, Math.floorDiv(digitCount, 2));
    final List<Integer> rightDigits = digits.subList(Math.floorDiv(digitCount, 2), digitCount);
    return new SplitInteger(leftDigits, rightDigits);
  }
}
