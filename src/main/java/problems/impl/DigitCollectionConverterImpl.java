package problems.impl;

import java.util.Collection;

import problems.interfaces.DigitCollectionConverter;

public class DigitCollectionConverterImpl implements DigitCollectionConverter {
  @Override public int convertDigitCollectionToInteger(final Collection<Integer> digits) {
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
