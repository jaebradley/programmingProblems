package problems.impl;

import java.util.ArrayList;
import java.util.List;

import problems.interfaces.TornNumberValidator;
import problems.utils.NumberUtil;
import problems.utils.SplitInteger;

public class TornNumberValidatorImpl implements TornNumberValidator {
  @Override public boolean isTornNumber(final SplitInteger splitInteger) {
    if (splitInteger.getLeftDigits().size() != splitInteger.getRightDigits().size()) {
      return false;
    }

    final List<Integer> allDigits = new ArrayList<>(splitInteger.getLeftDigits());
    allDigits.addAll(splitInteger.getRightDigits());
    return NumberUtil.digitsToInteger(allDigits) ==
        NumberUtil.square(
          NumberUtil.digitsToInteger(splitInteger.getLeftDigits()) + NumberUtil.digitsToInteger(splitInteger.getRightDigits())
        );
  }
}
