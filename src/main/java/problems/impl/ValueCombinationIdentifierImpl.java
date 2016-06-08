package problems.impl;

import problems.exceptions.NoValueCombinationIdentifiedException;
import problems.interfaces.ValueCombinationIdentifier;
import problems.models.TwoValueCombination;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValueCombinationIdentifierImpl implements ValueCombinationIdentifier {
  @Override
  public TwoValueCombination identifyTwoValuesThatSumToTarget(final long target, final List<Long> values) throws NoValueCombinationIdentifiedException {
    if (null == values) {
      throw new IllegalArgumentException("values must be non-null");
    }

    if (values.size() < 2) {
      throw new IllegalArgumentException("less than two values");
    }

    final Map<Long, Long> valuePairs = new HashMap<>();
    for (long value : values) {
      final long pairValue = target - value;
      final Long lookupValue = valuePairs.get(pairValue);
      if (null == lookupValue) {
        valuePairs.put(value, pairValue);
      } else {
        return new TwoValueCombination(value, pairValue);
      }
    }

    throw new NoValueCombinationIdentifiedException();
  }
}
