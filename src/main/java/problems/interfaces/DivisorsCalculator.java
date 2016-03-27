package problems.interfaces;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DivisorsCalculator {
  Set<Long> calculateDivisors(final long positiveInteger);

  long calculateGreatestCommonDivisor(final List<Long> numbers);

  Map<Long, Integer> calculateDivisorCount(final List<Long> numbers);

  Set<Long> calculateCommonDivisors(final List<Long> numbers);
}
