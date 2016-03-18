package problems.impl;

import java.util.List;

import problems.interfaces.ISBNValidator;
import problems.utils.NumberUtil;

public class ISBNValidatorImpl implements ISBNValidator {
  private static final int ISBN_NUMBER_LENGTH = 10;

  @Override
  public long sumISBNCandidateDigits(final List<Integer> candidateDigits) {
    if (candidateDigits.size() != ISBN_NUMBER_LENGTH) {
      throw new IllegalArgumentException(String.format("candidate must have exactly %s digits", ISBN_NUMBER_LENGTH));
    }
    long digitSum = 0;
    for (int index = ISBN_NUMBER_LENGTH; index > 0; index--) {
      digitSum += index * candidateDigits.get(index);
    }
    return digitSum;
  }

  @Override
  public boolean validateISBN(final long candidate) {
    if (candidate < 0) {
      throw new IllegalArgumentException("candidate must be positive value");
    }
    final List<Integer> digits = NumberUtil.positiveIntegerDigits(candidate);
    return sumISBNCandidateDigits(digits) % 11 == 0;
  }
}
