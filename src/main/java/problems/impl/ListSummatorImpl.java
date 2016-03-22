package problems.impl;

import java.util.List;

import problems.interfaces.ListSummator;

public class ListSummatorImpl implements ListSummator {
  @Override
  public long sumList(final List<Integer> numbers) {
    long listSum = 0;
    for (final int number : numbers) {
      listSum += number;
    }
    return listSum;
  }
}
