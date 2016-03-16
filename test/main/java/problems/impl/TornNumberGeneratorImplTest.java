package problems.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.SplitIntegerGenerator;
import problems.interfaces.TornNumberGenerator;
import problems.interfaces.TornNumberValidator;
import problems.utils.SplitInteger;

public class TornNumberGeneratorImplTest {
  private final int upperLimit = 4;
  private final SplitInteger testSplitInteger = new SplitInteger(
      new ArrayList<>(
          Arrays.asList(3, 0)
      ),
      new ArrayList<>(
          Arrays.asList(
              2, 5
          )
      )
  );
  private final SplitInteger anotherTestSplitInteger = new SplitInteger(
      new ArrayList<>(
          Arrays.asList(1, 2)
      ),
      new ArrayList<>(
          Arrays.asList(
              3, 4, 5
          )
      )
  );
  private final SplitIntegerGenerator splitIntegerGenerator = new SplitIntegerGenerator() {
    @Override public SplitInteger generateSplitInteger(final int candidate) {
      if (candidate == upperLimit) {
        return testSplitInteger;
      }

      return anotherTestSplitInteger;
    }
  };

  private final TornNumberValidator tornNumberValidator = new TornNumberValidator() {
    @Override public boolean isTornNumber(final SplitInteger splitInteger) {
      return splitInteger == testSplitInteger;
    }
  };
  private final TornNumberGenerator tornNumberGenerator = new TornNumberGeneratorImpl(tornNumberValidator, splitIntegerGenerator);

  @Test
  public void testNonPositiveUpperLimit() {
    try {
      tornNumberGenerator.generateTornNumbers(-1);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    try {
      tornNumberGenerator.generateTornNumbers(0);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }
  }

  @Test
  public void testExpected() {
    Assert.assertEquals(tornNumberGenerator.generateTornNumbers(1), new ArrayList<Integer>());
    Assert.assertEquals(tornNumberGenerator.generateTornNumbers(upperLimit), new ArrayList<Integer>(Arrays.asList(upperLimit)));
  }

}
