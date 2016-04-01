package problems.impl;

import problems.interfaces.DigitsIdentifier;
import problems.interfaces.ISBNValidator;
import problems.interfaces.InverseMultiplierListProductSumGenerator;

import java.util.List;

public class ISBNValidatorImpl implements ISBNValidator {

  private final InverseMultiplierListProductSumGenerator inverseMultiplierListProductSumGenerator;
  private final DigitsIdentifier digitsIdentifier;

  public ISBNValidatorImpl(final InverseMultiplierListProductSumGenerator inverseMultiplierListProductSumGenerator, final DigitsIdentifier digitsIdentifier) {
    this.inverseMultiplierListProductSumGenerator = inverseMultiplierListProductSumGenerator;
    this.digitsIdentifier = digitsIdentifier;
  }

  @Override
  public boolean validateISBN(final long candidate) {
    if (candidate < 0) {
      throw new IllegalArgumentException("candidate must be non-negative value");
    }
    final List<Integer> digits = digitsIdentifier.identifyDigits(candidate);
    return digits.size() == 11 && inverseMultiplierListProductSumGenerator.generateInverseMultiplierListProductSum(digits) % 11 == 0;
  }
}
