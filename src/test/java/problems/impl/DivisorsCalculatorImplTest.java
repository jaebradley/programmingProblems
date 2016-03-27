package problems.impl;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.DivisorsCalculator;

public class DivisorsCalculatorImplTest {

  private final List<Long> emptyNumbers = new ArrayList<>();
  private final Map<Long, Integer> emptyDivisorCount = new HashMap<>();
  private final Set<Long> emptySet = new HashSet<>();
  private final DivisorsCalculator divisorsCalculator = new DivisorsCalculatorImpl();
  private final List<Long> testNumbers1 = new ArrayList<>(Arrays.asList(1L, 2L));

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
    Assert.assertEquals(divisorsCalculator.calculateDivisorCount(emptyNumbers), emptyDivisorCount);
    final Map<Long, Integer> testNumbers1DivisorsMap = new HashMap<>();
    testNumbers1DivisorsMap.put(1L, 2);
    testNumbers1DivisorsMap.put(2L, 1);
    Assert.assertEquals(divisorsCalculator.calculateDivisorCount(testNumbers1), testNumbers1DivisorsMap);
  }

  @Test
  public void itShouldCalculateCommonDivisors() {
    Assert.assertEquals(divisorsCalculator.calculateCommonDivisors(emptyNumbers), emptySet);
    Assert.assertEquals(divisorsCalculator.calculateCommonDivisors(testNumbers1), new HashSet<>(Arrays.asList(1L)));
  }

  @Test
  public void itShouldCalculateGreatestCommonDivisor() {
    try {
      divisorsCalculator.calculateGreatestCommonDivisor(emptyNumbers);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    Assert.assertEquals(divisorsCalculator.calculateGreatestCommonDivisor(testNumbers1), 1);
  }

}
