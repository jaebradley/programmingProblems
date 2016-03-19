package problems.impl;

import java.util.List;

import problems.interfaces.DigitalRootCalculator;
import problems.interfaces.ListSummation;
import problems.utils.NumberUtil;

public class DigitalRootCalculatorImpl implements DigitalRootCalculator{
  private final ListSummation listSummation;

  public DigitalRootCalculatorImpl(final ListSummation listSummation) {
    this.listSummation = listSummation;
  }

  @Override public long calculateDigitalRoot(final long value) {
    if (value < 0) {
      throw new IllegalArgumentException("input value must be non-negative");
    }
    List<Integer> digits = NumberUtil.positiveIntegerDigits(value);
    long listSum = listSummation.sumList(digits);
    while (listSum > 9) {
      digits = NumberUtil.positiveIntegerDigits(listSum);
      listSum = listSummation.sumList(digits);
    }
    return listSum;
  }
}
