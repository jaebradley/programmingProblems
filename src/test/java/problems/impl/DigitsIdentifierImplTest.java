package problems.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.DigitsIdentifier;

public class DigitsIdentifierImplTest {
  private final DigitsIdentifier digitsIdentifier = new DigitsIdentifierImpl();

  @Test
  public void itShouldIdentifyDigits() {
    Assert.assertEquals(digitsIdentifier.identifyDigits(-10), new ArrayList<>(Arrays.asList(1, 0)));
    Assert.assertEquals(digitsIdentifier.identifyDigits(-1), new ArrayList<>(Arrays.asList(1)));
    Assert.assertEquals(digitsIdentifier.identifyDigits(0), new ArrayList<>(Arrays.asList(0)));
    Assert.assertEquals(digitsIdentifier.identifyDigits(1), new ArrayList<>(Arrays.asList(1)));
    Assert.assertEquals(digitsIdentifier.identifyDigits(10), new ArrayList<>(Arrays.asList(1, 0)));
    Assert.assertEquals(digitsIdentifier.identifyDigits(100), new ArrayList<>(Arrays.asList(1, 0, 0)));
  }
}
