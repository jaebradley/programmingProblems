package problems.impl;

import org.junit.Assert;
import org.junit.Test;
import problems.exceptions.NoFirstMissingPositiveIntegerException;
import problems.interfaces.FirstMissingPositiveIntegerIdentifier;

import java.util.Arrays;

public class FirstMissingPositiveIntegerIdentifierImplTest {
  private final FirstMissingPositiveIntegerIdentifier firstMissingPositiveIntegerIdentifier = new FirstMissingPositiveIntegerIdentifierImpl();

  @Test
  public void itShouldReturnSeenValues() {
    Assert.assertTrue(Arrays.equals(firstMissingPositiveIntegerIdentifier.identifyIfFirstIntegersHaveBeenSeen(new int[]{}), new boolean[]{}));
    Assert.assertTrue(Arrays.equals(firstMissingPositiveIntegerIdentifier.identifyIfFirstIntegersHaveBeenSeen(new int[]{-1}), new boolean[]{false}));
    Assert.assertTrue(Arrays.equals(firstMissingPositiveIntegerIdentifier.identifyIfFirstIntegersHaveBeenSeen(new int[]{0}), new boolean[]{false}));
    Assert.assertTrue(Arrays.equals(firstMissingPositiveIntegerIdentifier.identifyIfFirstIntegersHaveBeenSeen(new int[]{1}), new boolean[]{true}));
    Assert.assertTrue(Arrays.equals(firstMissingPositiveIntegerIdentifier.identifyIfFirstIntegersHaveBeenSeen(new int[]{2}), new boolean[]{false}));
    Assert.assertTrue(Arrays.equals(firstMissingPositiveIntegerIdentifier.identifyIfFirstIntegersHaveBeenSeen(new int[]{2, 3}), new boolean[]{false, true}));
    Assert.assertTrue(Arrays.equals(firstMissingPositiveIntegerIdentifier.identifyIfFirstIntegersHaveBeenSeen(new int[]{1, 3, 3, 1}), new boolean[]{true, false, true, false}));
  }

  @Test
  public void itShouldIdentifyFirstMissingPositiveInteger() {
    Assert.assertEquals(firstMissingPositiveIntegerIdentifier.identifyFirstMissingPositiveInteger(new int[]{}), 1);
    Assert.assertEquals(firstMissingPositiveIntegerIdentifier.identifyFirstMissingPositiveInteger(new int[]{-1}), 1);
    Assert.assertEquals(firstMissingPositiveIntegerIdentifier.identifyFirstMissingPositiveInteger(new int[]{0}), 1);
    Assert.assertEquals(firstMissingPositiveIntegerIdentifier.identifyFirstMissingPositiveInteger(new int[]{1}), 2);
    Assert.assertEquals(firstMissingPositiveIntegerIdentifier.identifyFirstMissingPositiveInteger(new int[]{2}), 1);
    Assert.assertEquals(firstMissingPositiveIntegerIdentifier.identifyFirstMissingPositiveInteger(new int[]{2, 3}), 1);
    Assert.assertEquals(firstMissingPositiveIntegerIdentifier.identifyFirstMissingPositiveInteger(new int[]{1, 3, 3, 1}), 2);
  }

}