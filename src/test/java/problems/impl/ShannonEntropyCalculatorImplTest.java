package problems.impl;

import org.junit.Assert;
import org.junit.Test;
import problems.interfaces.ShannonEntropyCalculator;

public class ShannonEntropyCalculatorImplTest {

  private final ShannonEntropyCalculator calculator = new ShannonEntropyCalculatorImpl();

  @Test
  public void testCalculateShannonEntropy() {
    Assert.assertEquals(calculator.calculateShannonEntropy("1223334444"), 1.8464393446708698, 0);
  }

  @Test
  public void testCalculateEventInformation() {
    Assert.assertEquals(calculator.calculateEventInformation(1, 10), -0.33219280948871, 0);
  }

}