package problems.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.DigitalRootCalculator;
import problems.interfaces.DigitsIdentifier;
import problems.interfaces.ListSummator;

public class DigitalRootCalculatorImplTest {

  private final ListSummator negativeListSummator = new ListSummator() {
    @Override public long sumList(final List<Integer> numbers) {
      return -1;
    }
  };
  private final DigitsIdentifier emptyListDigitsIdentifier = new DigitsIdentifier() {
    @Override public List<Integer> identifyDigits(final long number) {
      return new ArrayList<>();
    }
  };
  private final DigitalRootCalculator negativeDigitalRootCalculator = new DigitalRootCalculatorImpl(
      negativeListSummator, emptyListDigitsIdentifier);

  private final ListSummator tenReturningListSummator = new ListSummator() {
    @Override public long sumList(final List<Integer> numbers) {
      return 10;
    }
  };
  private final DigitalRootCalculator constantPositiveDigitalRootCalculator = new DigitalRootCalculatorImpl(tenReturningListSummator, emptyListDigitsIdentifier);

  private final List<Integer> list1 = new ArrayList<>(Arrays.asList(1));
  private final List<Integer> list2 = new ArrayList<>(Arrays.asList(2));
  private final ListSummator expectedBehaviorListSummator = new ListSummator() {
    @Override
    public long sumList(final List<Integer> numbers) {
      if (numbers == list1) {
        return 1;
      }

      if (numbers == list2) {
        return 10;
      }

      throw new RuntimeException("unexpected value");
    }
  };
  private final DigitsIdentifier expectedBehaviorDigitsIdentifier = new DigitsIdentifier() {
    @Override
    public List<Integer> identifyDigits(final long number) {
      if (number == 1) {
        return list2;
      }

      if (number == 10) {
        return list1;
      }

      throw new RuntimeException("unexpected value");
    }
  };
  private final DigitalRootCalculator expectedBehaviorDigitalRootCalculator = new DigitalRootCalculatorImpl(expectedBehaviorListSummator, expectedBehaviorDigitsIdentifier);

  @Test(expected = RuntimeException.class)
  public void itShouldThrowException() {
    negativeDigitalRootCalculator.calculateDigitalRoot(10);
    constantPositiveDigitalRootCalculator.calculateDigitalRoot(10);
  }

  @Test
  public void itShouldCalculate() {
    Assert.assertEquals(expectedBehaviorDigitalRootCalculator.calculateDigitalRoot(10), 1);
  }
}
