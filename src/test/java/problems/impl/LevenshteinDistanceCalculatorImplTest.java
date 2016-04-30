package problems.impl;

import org.junit.Assert;
import org.junit.Test;
import problems.interfaces.LevenshteinDistanceCalculator;

public class LevenshteinDistanceCalculatorImplTest {
  private final LevenshteinDistanceCalculator levenshteinDistanceCalculator = new LevenshteinDistanceCalculatorImpl();

  @Test
  public void itShouldCalculateDistance() {
    Assert.assertEquals(levenshteinDistanceCalculator.calculateLevenshteinDistance("jae", "jae"), 0);
    Assert.assertEquals(levenshteinDistanceCalculator.calculateLevenshteinDistance("jae", "ja"), 1);
    Assert.assertEquals(levenshteinDistanceCalculator.calculateLevenshteinDistance("jae", "jar"), 1);
  }
}