package problems.interfaces;

import java.util.Collection;

public interface DistinctValuesCalculator {
  long calculateDistinctNonNullValues(final Collection<Long> values);
}
