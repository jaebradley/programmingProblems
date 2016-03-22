package problems.impl;

import java.util.List;

import problems.interfaces.DigitalRootCalculator;
import problems.interfaces.ListSummator;
import problems.utils.NumberUtil;

public class DigitalRootCalculatorImpl implements DigitalRootCalculator{
  private final ListSummator listSummator;

  public DigitalRootCalculatorImpl(final ListSummator listSummator) {
    this.listSummator = listSummator;
  }

  @Override public long calculateDigitalRoot(final long value) {
    if (value < 0) {
      throw new IllegalArgumentException("input value must be non-negative");
    }
    List<Integer> digits = NumberUtil.positiveIntegerDigits(value);
    long listSum = listSummator.sumList(digits);
    while (listSum > 9) {
      digits = NumberUtil.positiveIntegerDigits(listSum);
      listSum = listSummator.sumList(digits);
    }
    return listSum;
  }
}
