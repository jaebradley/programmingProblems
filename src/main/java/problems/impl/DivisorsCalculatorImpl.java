package problems.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
  public Set<Long> calculateDivisors(final long positiveInteger) {
    if (positiveInteger < 1) {
      throw new IllegalArgumentException("input value must be positive");
    }

    final Set<Long> divisors = new HashSet<>();
    for (long candidateDivisor = 1; candidateDivisor <= Math.ceil(Math.sqrt(positiveInteger)); candidateDivisor++) {
      if (0 == positiveInteger % candidateDivisor) {
        divisors.add(candidateDivisor);
        divisors.add(new Double(positiveInteger / candidateDivisor).longValue());
      }
    }
    return divisors;
  }

  @Override
  public long calculateGreatestCommonDivisor(final List<Long> numbers) {
    final Set<Long> commonDivisors = calculateCommonDivisors(numbers);
    if (commonDivisors.isEmpty()) {
      return 1;
    }
    return Collections.max(commonDivisors);
  }

  @Override
  public Set<Long> calculateCommonDivisors(final List<Long> numbers) {
    if (numbers.isEmpty()) {
      throw new IllegalArgumentException("numbers can't be empty");
    }
    final Set<Long> commonDivisors = new HashSet<>();
    for (Entry<Long, Integer> entry : calculateDivisorCount(numbers).entrySet()) {
      if (entry.getValue() == numbers.size()) {
        commonDivisors.add(entry.getKey());
      }
    }
    return commonDivisors;
  }

  @Override
  public Map<Long, Integer> calculateDivisorCount(final List<Long> numbers) {
    final Map<Long, Integer> divisorCount = new HashMap<>();
    for (final long number : numbers) {
      final Set<Long> divisors = calculateDivisors(number);
      for (final long divisor : divisors) {
        final Integer count = divisorCount.get(divisor);
        if (null == count) {
          divisorCount.put(divisor, 1);
        } else {
          divisorCount.put(divisor, count + 1);
        }
      }
    }

    return divisorCount;
  }
}
