package problems.impl;

import java.util.Collection;

import problems.interfaces.DigitCollectionConverter;

public class DigitCollectionConverterImpl implements DigitCollectionConverter {

  /**
   * Given a collection of integers, return the numerical value if these integers were concatenated.
   *
   * @param digits collection of integers
   * @return integer, representing the numerical value of the concatenated input collection
   */
  @Override
  public int convertDigitCollectionToInteger(final Collection<Integer> digits) {
    if (digits.isEmpty()) {
      throw new IllegalArgumentException("empty input collection");
    }
    final StringBuilder stringBuilder = new StringBuilder();
    for (int digit : digits) {
      stringBuilder.append(digit);
    }
    return Integer.valueOf(stringBuilder.toString());
  }
}
