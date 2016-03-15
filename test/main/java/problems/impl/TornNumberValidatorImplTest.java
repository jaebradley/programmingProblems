package problems.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.TornNumberValidator;
import problems.utils.SplitInteger;

public class TornNumberValidatorImplTest {
  private final TornNumberValidator tornNumberValidator = new TornNumberValidatorImpl();
  private final List<Integer> exampleDigits = new ArrayList<>(
      Arrays.asList(1, 2, 3, 4)
  );
  private final List<Integer> moreExampleDigits = new ArrayList<>(
      Arrays.asList(5, 6, 7)
  );

  @Test
  public void testExpected() {
    final SplitInteger leftDigitsUnbalanced = new SplitInteger(exampleDigits, moreExampleDigits);
    final SplitInteger rightDigitsUnbalanced = new SplitInteger(moreExampleDigits, exampleDigits);
    Assert.assertFalse(tornNumberValidator.isTornNumber(leftDigitsUnbalanced));
    Assert.assertFalse(tornNumberValidator.isTornNumber(rightDigitsUnbalanced));

    final SplitInteger tornNumber = new SplitInteger(
        new ArrayList<>(
            Arrays.asList(3, 0)
        ),
        new ArrayList<>(
            Arrays.asList(2, 5)
        )
    );
    Assert.assertTrue(tornNumberValidator.isTornNumber(tornNumber));
  }

}
