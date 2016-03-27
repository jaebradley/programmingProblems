package problems.impl;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.DivisorsCalculator;

public class DivisorsCalculatorImplTest {

  private final DivisorsCalculator divisorsCalculator = new DivisorsCalculatorImpl();

  @Test
  public void itShouldThrowException() {
    try {
      divisorsCalculator.calculateDivisors(-1);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    try {
      divisorsCalculator.calculateDivisors(0);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }
  }

  @Test
  public void itShouldCalculateDivisors() {
    Set<Integer> oneDivisors = new HashSet<>(Arrays.asList(1));
    Set<Integer> twoDivisors = new HashSet<>(Arrays.asList(1, 2));
    Set<Integer> fourDivisors = new HashSet<>(Arrays.asList(1, 2, 4));
    Assert.assertEquals(divisorsCalculator.calculateDivisors(1), oneDivisors);
    Assert.assertEquals(divisorsCalculator.calculateDivisors(2), twoDivisors);
    Assert.assertEquals(divisorsCalculator.calculateDivisors(4), fourDivisors);
  }

  @Test
  public void itShouldCalculateDivisorCount() {
    Assert.assertEquals(divisorsCalculator.calculateDivisorCount(new ArrayList<>()), new HashMap<Long, Integer>());

    final List<Long> testNumbers1 = new ArrayList<>(Arrays.asList(1L, 2L));
    final Map<Long, Integer> testNumbers1DivisorsMap = new HashMap<>();
    testNumbers1DivisorsMap.put(1L, 2);
    testNumbers1DivisorsMap.put(2L, 1);
    Assert.assertEquals(divisorsCalculator.calculateDivisorCount(testNumbers1), testNumbers1DivisorsMap);
  }

}
