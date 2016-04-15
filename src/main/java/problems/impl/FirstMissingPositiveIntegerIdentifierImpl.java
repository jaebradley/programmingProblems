package problems.impl;

import problems.interfaces.FirstMissingPositiveIntegerIdentifier;

public class FirstMissingPositiveIntegerIdentifierImpl implements FirstMissingPositiveIntegerIdentifier {

  /**
   * Given an array of integers, identify if any of these array values are between 1 and the
   * length of the array, inclusive.
   *
   * If an array value is between 1 and the length of the array, then it is considered "seen" and
   * it's boolean index (minus 1, since we start counting from 1) is set to true.
   *
   * @param values array of integers
   * @return array of booleans that represents if any of the input values is between 1 and the
   * length of the input array
   */
  @Override
  public boolean[] identifyIfFirstIntegersHaveBeenSeen(final int[] values) {
    final boolean[] seenValues = new boolean[values.length];
    for (final int value : values) {
      if (value > 0 && value <= values.length && !seenValues[value - 1]) {
        seenValues[value - 1] = true;
      }
    }
    return seenValues;
  }

  /**
   * Identify the first positive integer not in the input integer array.
   *
   * If the input integer array is -1, -2 then the first positive integer is 1.
   *
   * @param values input integer array
   * @return first positive integer not in input integer array
   */
  @Override
  public int identifyFirstMissingPositiveInteger(final int[] values) {
    final boolean[] seenIntegers = identifyIfFirstIntegersHaveBeenSeen(values);
    for (int index = 0; index < seenIntegers.length; index++) {
      if (!seenIntegers[index]) {
        return index + 1;
      }
    }

    return seenIntegers.length + 1;
  }
}
