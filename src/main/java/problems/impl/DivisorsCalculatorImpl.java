package problems.impl;

import java.util.HashSet;
import java.util.Set;

import problems.interfaces.DivisorsCalculator;

public class DivisorsCalculatorImpl implements DivisorsCalculator {

  /**
   * Calculates divisors for a given positive integer.
   *
   * Divides the input value by each number between 1 and the square root of the input value, rounded up.
   * If the candidate divisor returns a remainder of zero, then add the candidate divisor and it's division value
   * to the Set of values to return.
   *
   * @param positiveInteger value to calculate divisors from
   * @return a Set of numbers that contains the divisors of the input value
   */

  @Override
  public Set<Integer> calculateDivisors(final long positiveInteger) {
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
