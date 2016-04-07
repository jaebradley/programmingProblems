package problems.impl;

import problems.interfaces.DistinctValuesCalculator;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class DistinctValuesCalculatorImpl implements DistinctValuesCalculator {
  @Override
  public long calculateDistinctNonNullValues(final Collection<Long> values) {
    if (values == null) {
      throw new IllegalArgumentException("input can't be null");
    }
    final Set<Long> distinctValues = new HashSet<>(values);
    distinctValues.remove(null);
    return distinctValues.size();
  }
}
