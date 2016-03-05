package problems.impl;

import java.util.ArrayList;
import java.util.List;

import problems.exceptions.TornNumberCandidateOddDigitCountException;
import problems.interfaces.TornNumberGenerator;
import problems.interfaces.TornNumberValidator;
import problems.utils.NumberUtil;
import problems.utils.SplitInteger;

public class TornNumberGeneratorImpl implements TornNumberGenerator {
  private final TornNumberValidator tornNumberValidator;

  public TornNumberGeneratorImpl(final TornNumberValidator tornNumberValidator) {
    this.tornNumberValidator = tornNumberValidator;
  }

  @Override public SplitInteger generateSplitIntegerFromTornNumberCandidate(final int tornNumberCandidate) throws TornNumberCandidateOddDigitCountException{
    if (tornNumberCandidate < 1) {
      throw new IllegalArgumentException("torn number candidate must be a positive integer");
    }

    final int digitCount = NumberUtil.positiveIntegerDigitCount(tornNumberCandidate);
    if (!NumberUtil.isEven(digitCount)) {
      throw new TornNumberCandidateOddDigitCountException();
    }

    final List<Integer> digits = NumberUtil.positiveIntegerDigits(tornNumberCandidate);
    final List<Integer> leftDigits = digits.subList(0, Math.floorDiv(digitCount, 2));
    final List<Integer> rightDigits = digits.subList(Math.floorDiv(digitCount, 2), digitCount);
    return new SplitInteger(leftDigits, rightDigits);
  }

  @Override public List<Integer> generateTornNumbers(final int upperLimitInclusive) {
    if (upperLimitInclusive < 1) {
      throw new IllegalArgumentException("positive upper limit");
    }

    final List<Integer> tornNumbers = new ArrayList<>();
    int squareRoot = 0;
    int tornNumberCandidate = NumberUtil.square(squareRoot);
    while (tornNumberCandidate <= upperLimitInclusive) {
      try {
        final SplitInteger splitInteger = generateSplitIntegerFromTornNumberCandidate(tornNumberCandidate);
        if (tornNumberValidator.isTornNumber(splitInteger)) {
          tornNumbers.add(tornNumberCandidate);
        }

        squareRoot++;
        tornNumberCandidate = NumberUtil.square(squareRoot);
      } catch (TornNumberCandidateOddDigitCountException e) {
        squareRoot++;
        tornNumberCandidate = NumberUtil.square(squareRoot);
      }
    }
    return tornNumbers;
  }
}
