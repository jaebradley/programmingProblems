package problems.impl;

import org.junit.Assert;
import org.junit.Test;
import problems.exceptions.NoValueCombinationIdentifiedException;
import problems.interfaces.ValueCombinationIdentifier;
import problems.models.TwoValueCombination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ValueCombinationIdentifierImplTest {

  private final ValueCombinationIdentifier valueCombinationIdentifier = new ValueCombinationIdentifierImpl();

  @Test
  public void testIllegalArguments() throws NoValueCombinationIdentifiedException {
    try {
      valueCombinationIdentifier.identifyTwoValuesThatSumToTarget(0, null);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    try {
      valueCombinationIdentifier.identifyTwoValuesThatSumToTarget(0, new ArrayList<>());
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }
  }

  @Test
  public void testExpectedBehavior() {
    final long target1 = 7L;
    final List<Long> values1 = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
    final TwoValueCombination expectedValueCombination1 = new TwoValueCombination(4L, 3L);
    try {
      assertEquals(valueCombinationIdentifier.identifyTwoValuesThatSumToTarget(target1, values1), expectedValueCombination1);
    } catch (NoValueCombinationIdentifiedException e) {
      Assert.fail();
    }

    final long target2 = 7L;
    final List<Long> values2 = new ArrayList<>(Arrays.asList(6L, 5L, 1L, 3L, 2L, 4L));
    final TwoValueCombination expectedValueCombination2 = new TwoValueCombination(1L, 6L);
    try {
      assertEquals(valueCombinationIdentifier.identifyTwoValuesThatSumToTarget(target2, values2), expectedValueCombination2);
    } catch (NoValueCombinationIdentifiedException e) {
      Assert.fail();
    }

    final long target3 = -7L;
    final List<Long> values3 = new ArrayList<>(Arrays.asList(-2L, 6L, -5L, -13L));
    final TwoValueCombination expectedValueCombination3 = new TwoValueCombination(-5L, -2L);
    try {
      assertEquals(valueCombinationIdentifier.identifyTwoValuesThatSumToTarget(target3, values3), expectedValueCombination3);
    } catch (NoValueCombinationIdentifiedException e) {
      Assert.fail();
    }
  }

  @Test
  public void testNoValueFound() {
    final long target = 7L;
    final List<Long> values = new ArrayList<>(Arrays.asList(1L, 1L, 1L));
    try {
      valueCombinationIdentifier.identifyTwoValuesThatSumToTarget(target, values);
      Assert.fail();
    } catch (NoValueCombinationIdentifiedException e) {
      // expected
    }
  }
}