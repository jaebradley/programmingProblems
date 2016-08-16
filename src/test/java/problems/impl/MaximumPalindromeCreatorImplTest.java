package problems.impl;

import org.junit.Test;
import problems.interfaces.MaximumPalindromeCreator;

import static org.junit.Assert.*;

public class MaximumPalindromeCreatorImplTest {
  private final MaximumPalindromeCreator maximumPalindromeCreator = new MaximumPalindromeCreatorImpl();

  @Test
  public void testExpected() {
    assertEquals(maximumPalindromeCreator.createMaximumPalindrome("12345", 2), "54345");
    assertEquals(maximumPalindromeCreator.createMaximumPalindrome("14325", 2), "54345");
    assertEquals(maximumPalindromeCreator.createMaximumPalindrome("12325", 3), "92929");
  }

}