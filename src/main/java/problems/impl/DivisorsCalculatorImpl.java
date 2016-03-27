package problems.impl;

import java.util.HashSet;
import java.util.Set;

import problems.interfaces.DivisorsCalculator;

public class DivisorsCalculatorImpl implements DivisorsCalculator {
  @Override public Set<Integer> calculateDivisors(final long positiveInteger) {
    if (positiveInteger < 1) {
      throw new IllegalArgumentException("input value must be positive");
    }

    final Set<Integer> divisors = new HashSet<>();
    for (int candidateDivisor = 1; candidateDivisor <= Math.ceil(Math.sqrt(positiveInteger)); candidateDivisor++) {
      if (0 == positiveInteger % candidateDivisor) {
        divisors.add(candidateDivisor);
        divisors.add(new Double(positiveInteger / candidateDivisor).intValue());
      }
    }
    return divisors;
  }
}
