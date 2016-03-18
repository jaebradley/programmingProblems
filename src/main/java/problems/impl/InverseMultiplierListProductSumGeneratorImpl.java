package problems.impl;

import java.util.List;

import problems.interfaces.InverseMultiplierListProductSumGenerator;

public class InverseMultiplierListProductSumGeneratorImpl implements InverseMultiplierListProductSumGenerator {
  @Override public long generateInverseMultiplierListProductSum(final List<Integer> values) {
    if (null == values) {
      throw new IllegalArgumentException("input must be non-null");
    }

    long digitSum = 0;
    for (int index = 0; index < values.size(); index++) {
      digitSum += values.get(index) * (values.size() - index);
    }
    return digitSum;
  }
}
