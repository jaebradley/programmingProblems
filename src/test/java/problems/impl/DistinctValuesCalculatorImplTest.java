package problems.impl;

import org.junit.Assert;
import org.junit.Test;
import problems.interfaces.DistinctValuesCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class DistinctValuesCalculatorImplTest {

  private final DistinctValuesCalculator distinctValuesCalculator = new DistinctValuesCalculatorImpl();
  private final Collection<Long> nullCollection = new ArrayList<>(Arrays.asList(null, null, null));
  private final Collection<Long> duplicates = new ArrayList<>(Arrays.asList(1L, null, 1L, 2L, 2L, null, 3L));

  @Test
  public void itShouldThrowAnException() {
    try {
      distinctValuesCalculator.calculateDistinctNonNullValues(null);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }
  }

  @Test
  public void itShouldCalculateNonNullDistinctValues() {
    Assert.assertEquals(distinctValuesCalculator.calculateDistinctNonNullValues(nullCollection), 0);
    Assert.assertEquals(distinctValuesCalculator.calculateDistinctNonNullValues(duplicates), 3);
  }
}