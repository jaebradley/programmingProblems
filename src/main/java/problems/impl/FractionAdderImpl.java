package problems.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import problems.interfaces.FractionAdder;
import problems.utils.Fraction;
import problems.utils.NumberUtil;

/**
 * Implementation for adding fractions
 */

public class FractionAdderImpl implements FractionAdder {
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
    final int combinedNumerator = firstFraction.getNumerator() * secondFraction.getDenominator() + firstFraction.getDenominator() * secondFraction.getNumerator();
    final int combinedDenominator = firstFraction.getDenominator() * secondFraction.getDenominator();
    final Set<Integer> numeratorDivisors = NumberUtil.getDivisorsForPositiveInteger(Math.abs(combinedNumerator));
    final Set<Integer> denominatorDivisors = NumberUtil.getDivisorsForPositiveInteger(Math.abs(combinedDenominator));
    final Set<Integer> commonDivisors = new HashSet<>(numeratorDivisors);
    commonDivisors.retainAll(denominatorDivisors);
    final int greatestCommonDivisor = Collections.max(commonDivisors);
    return new Fraction(
        new Double(combinedNumerator / greatestCommonDivisor).intValue(),
        new Double(combinedDenominator / greatestCommonDivisor).intValue()
    );

  }
}
