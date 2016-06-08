package problems.impl;

import problems.exceptions.NoValueCombinationIdentifiedException;
import problems.interfaces.ValueCombinationIdentifier;
import problems.models.TwoValueCombination;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of values and some target, find the first combination of values (if they exist) that sums to the target value
 *
 * Inspired by this problem: https://www.hackerrank.com/challenges/icecream-parlor
 */

public class ValueCombinationIdentifierImpl implements ValueCombinationIdentifier {

  /**
   * For a given target value, find the pair of values (if they exist) in the inputted List of values that sum to the
   * target value. If no pair of values is found, a NoValueCombinationIdentifiedException is thrown.
   * 
   * @param target value that two candidate values need to sum to
   * @param values List of candidate values
   * @return TwoValueCombination object that contains the pair of values that sum to the given target value
   * @throws NoValueCombinationIdentifiedException if no pair of values can be identified
   */
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
