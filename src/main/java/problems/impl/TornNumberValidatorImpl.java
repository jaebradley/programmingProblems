package problems.impl;

import java.util.ArrayList;
import java.util.List;

import problems.interfaces.DigitCollectionConverter;
import problems.interfaces.TornNumberValidator;
import problems.utils.SplitInteger;

public class TornNumberValidatorImpl implements TornNumberValidator {
  private final DigitCollectionConverter digitCollectionConverter;

  public TornNumberValidatorImpl(final DigitCollectionConverter digitCollectionConverter) {
    this.digitCollectionConverter = digitCollectionConverter;
  }

  @Override public boolean isTornNumber(final SplitInteger splitInteger) {
    if (splitInteger.getLeftDigits().size() != splitInteger.getRightDigits().size()) {
      return false;
    }

    final List<Integer> allDigits = new ArrayList<>(splitInteger.getLeftDigits());
    allDigits.addAll(splitInteger.getRightDigits());
    final int leftAndRightValuesSum = digitCollectionConverter.convertDigitCollectionToInteger(splitInteger.getLeftDigits()) + digitCollectionConverter.convertDigitCollectionToInteger(splitInteger.getRightDigits();
    return digitCollectionConverter.convertDigitCollectionToInteger(allDigits) == Math.multiplyExact(leftAndRightValuesSum, leftAndRightValuesSum);
  }
}
