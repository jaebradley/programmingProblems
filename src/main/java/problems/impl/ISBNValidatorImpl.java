package problems.impl;

import java.util.List;

import problems.interfaces.ISBNValidator;
import problems.interfaces.InverseMultiplierListProductSumGenerator;
import problems.utils.NumberUtil;

public class ISBNValidatorImpl implements ISBNValidator {

  private final InverseMultiplierListProductSumGenerator inverseMultiplierListProductSumGenerator;

  public ISBNValidatorImpl(
      final InverseMultiplierListProductSumGenerator inverseMultiplierListProductSumGenerator) {
    this.inverseMultiplierListProductSumGenerator = inverseMultiplierListProductSumGenerator;
  }

  @Override
  public boolean validateISBN(final long candidate) {
    if (candidate < 0) {
      throw new IllegalArgumentException("candidate must be positive value");
    }
    final List<Integer> digits = NumberUtil.positiveIntegerDigits(candidate);
    return inverseMultiplierListProductSumGenerator.generateInverseMultiplierListProductSum(digits) % 11 == 0;
  }
}
