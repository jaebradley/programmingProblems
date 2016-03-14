package problems.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import problems.interfaces.FractionAdder;
import problems.utils.Fraction;
import problems.utils.NumberUtil;

public class FractionAdderImpl implements FractionAdder {
  @Override public Fraction addFractions(final Fraction firstFraction, final Fraction secondFraction) {
    final int combinedNumerator = firstFraction.getNumerator() * secondFraction.getDenominator() + firstFraction.getDenominator() * secondFraction.getNumerator();
    final int combinedDenominator = firstFraction.getDenominator() * secondFraction.getDenominator();
    final Set<Integer> gcdNumerators = NumberUtil.getDivisorsForPositiveInteger(Math.abs(combinedNumerator));
    final Set<Integer> gcdDenominators = NumberUtil.getDivisorsForPositiveInteger(Math.abs(combinedDenominator));
    final Set<Integer> intersection = new HashSet<>(gcdNumerators);
    intersection.retainAll(gcdDenominators);
    if (intersection.isEmpty()) {
      return new Fraction(
          combinedNumerator,
          combinedDenominator
      );
    }

    final int maxDivisor = Collections.max(intersection);
    return new Fraction(
        new Double(combinedNumerator / maxDivisor).intValue(),
        new Double(combinedDenominator / maxDivisor).intValue()
    );

  }
}
