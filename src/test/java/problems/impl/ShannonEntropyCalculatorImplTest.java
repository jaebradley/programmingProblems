package problems.impl;

import org.junit.Assert;
import org.junit.Test;
import problems.interfaces.ShannonEntropyCalculator;

import java.math.BigDecimal;

public class ShannonEntropyCalculatorImplTest {

  private final ShannonEntropyCalculator calculator = new ShannonEntropyCalculatorImpl();

  @Test
  public void testCalculateShannonEntropy() {
    Assert.assertEquals(calculator.calculateShannonEntropy("1223334444"), new BigDecimal("1.84643934467101537000000000000000000000000"));
    Assert.assertEquals(calculator.calculateShannonEntropy("Hello, world!"), new BigDecimal("3.1808329872054406153846161273175590350232"));
  }

  @Test
  public void testCalculateEventInformation() {
    Assert.assertEquals(calculator.calculateEventInformation(1, 10), new BigDecimal("-0.3321928094887362000000000000000000000000"));
  }

}