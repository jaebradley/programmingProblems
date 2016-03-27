package problems.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import problems.interfaces.DivisorsCalculator;
import problems.interfaces.FractionAdder;
import problems.utils.Fraction;

/**
 * Implementation for adding fractions
 */

public class FractionAdderImpl implements FractionAdder {

  private final DivisorsCalculator divisorsCalculator;

  public FractionAdderImpl(final DivisorsCalculator divisorsCalculator) {
    this.divisorsCalculator = divisorsCalculator;
  }

  /**
   * Multiplies the numerator from the first fraction and the denominator of the second fraction, and multiplies the
   * numerator from the second fraction and the denominator from the first fraction, and sums these two values
   * to get the common numerator.
   *
   * Multiplies denominators from both fractions to get the common denominator. Then, finds the greatest common divisor
   * for the common numerator and denominator. If none exists, it returns a new fraction with the common numerator / denominator
   * as the appropriate value. If a greatest common divisor exists, it divides both values by this divisor and returns a
   * new fraction with the reduced values.
   *
   * @param firstFraction one of the fractions to be summed
   * @param secondFraction one of the fractions to be summed
   * @return fraction object in fully reduced form
   */
  @Override public Fraction sumFractions(final Fraction firstFraction, final Fraction secondFraction) {
    final long combinedNumerator = firstFraction.getNumerator() * secondFraction.getDenominator() + firstFraction.getDenominator() * secondFraction.getNumerator();
    final long combinedDenominator = firstFraction.getDenominator() * secondFraction.getDenominator();
    final List<Long> fractionValues = new ArrayList<>(Arrays.asList(combinedDenominator, combinedNumerator));
    final long greatestCommonDivisor = divisorsCalculator.calculateGreatestCommonDivisor(fractionValues);
    return new Fraction(
        new Double(combinedNumerator / greatestCommonDivisor).longValue(),
        new Double(combinedDenominator / greatestCommonDivisor).longValue()
    );

  }
}
