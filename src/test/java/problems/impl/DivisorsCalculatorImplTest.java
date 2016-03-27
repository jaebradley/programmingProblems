package problems.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

}
