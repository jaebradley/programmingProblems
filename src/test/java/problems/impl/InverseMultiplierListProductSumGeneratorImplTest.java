package problems.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.InverseMultiplierListProductSumGenerator;

public class InverseMultiplierListProductSumGeneratorImplTest {

  private final InverseMultiplierListProductSumGenerator inverseMultiplierListProductSumGenerator = new InverseMultiplierListProductSumGeneratorImpl();

  @Test
  public void testExpected() {
    try {
      inverseMultiplierListProductSumGenerator.generateInverseMultiplierListProductSum(null);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }
    Assert.assertEquals(inverseMultiplierListProductSumGenerator.generateInverseMultiplierListProductSum(new ArrayList<>()), 0);
    Assert.assertEquals(inverseMultiplierListProductSumGenerator.generateInverseMultiplierListProductSum(new ArrayList<>(
        Arrays.asList(10))), 10);
    Assert.assertEquals(inverseMultiplierListProductSumGenerator.generateInverseMultiplierListProductSum(new ArrayList<>(
        Arrays.asList(1, 2, 3))), 10);
  }
}
