package problems.impl;

import org.junit.Assert;
import org.junit.Test;
import problems.interfaces.LevenshteinDistanceCalculator;

public class LevenshteinDistanceCalculatorImplTest {
  private final LevenshteinDistanceCalculator levenshteinDistanceCalculator = new LevenshteinDistanceCalculatorImpl();
  private final int[][] levenshteinDistanceMatrix = new int[2][3];

  @Test
  public void itShouldCalculateDistance() {
    Assert.assertEquals(levenshteinDistanceCalculator.calculateLevenshteinDistance("jae", "jae"), 0);
    Assert.assertEquals(levenshteinDistanceCalculator.calculateLevenshteinDistance("jae", "ja"), 1);
    Assert.assertEquals(levenshteinDistanceCalculator.calculateLevenshteinDistance("jae", "jar"), 1);
  }

  @Test
  public void itShouldThrowException() {
    try {
      levenshteinDistanceCalculator.calculateLevenshteinDistance(null, "jae");
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    try {
      levenshteinDistanceCalculator.calculateLevenshteinDistanceForEmptyStrings("jae", "jae");
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    try {
      levenshteinDistanceCalculator.calculateLevenshteinDistance("jae", null);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    levenshteinDistanceMatrix[0] = new int[] {
            1, 2, 3
    };
    levenshteinDistanceMatrix[1] = new int[] {
            4, 5, 6
    };
    try {
      levenshteinDistanceCalculator.calculateIndexValue(levenshteinDistanceMatrix, -1, 1, 'J', 'A');
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    try {
      levenshteinDistanceCalculator.calculateIndexValue(levenshteinDistanceMatrix, 1, -1, 'J', 'A');
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    try {
      levenshteinDistanceCalculator.calculateIndexValue(levenshteinDistanceMatrix, 10, 1, 'J', 'A');
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    try {
      levenshteinDistanceCalculator.calculateIndexValue(levenshteinDistanceMatrix, 1, 10, 'J', 'A');
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    Assert.assertEquals(levenshteinDistanceCalculator.calculateIndexValue(levenshteinDistanceMatrix, 0, 0, 'J', 'J'), 1);
    Assert.assertEquals(levenshteinDistanceCalculator.calculateIndexValue(levenshteinDistanceMatrix, 1, 1, 'J', 'A'), 2);
  }

  @Test
  public void itShouldCalculateLevenshteinDistanceForEmptyStrings() {
    Assert.assertEquals(levenshteinDistanceCalculator.calculateLevenshteinDistanceForEmptyStrings("", ""), 0);
    Assert.assertEquals(levenshteinDistanceCalculator.calculateLevenshteinDistanceForEmptyStrings("jae", ""), 3);
    Assert.assertEquals(levenshteinDistanceCalculator.calculateLevenshteinDistanceForEmptyStrings("", "jae"), 3);
  }
}