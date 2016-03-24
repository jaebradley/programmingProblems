package problems.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.DigitCollectionConverter;
import problems.interfaces.TornNumberValidator;
import problems.utils.SplitInteger;

public class TornNumberValidatorImplTest {

  private final DigitCollectionConverter converter1 = new DigitCollectionConverter() {
    @Override public int convertDigitCollectionToInteger(final Collection<Integer> digits) {
      return 0;
    }
  };
  private final TornNumberValidator tornNumberValidator1 = new TornNumberValidatorImpl(converter1);

  private final DigitCollectionConverter converter2 = new DigitCollectionConverter() {
    @Override public int convertDigitCollectionToInteger(final Collection<Integer> digits) {
      return 2;
    }
  };
  private final TornNumberValidator tornNumberValidator2 = new TornNumberValidatorImpl(converter2);

  private final List<Integer> exampleDigits = new ArrayList<>(
      Arrays.asList(1, 2, 3, 4)
  );
  private final List<Integer> moreExampleDigits = new ArrayList<>(
      Arrays.asList(5, 6, 7)
  );
  private final SplitInteger balancedSplitInteger = new SplitInteger(exampleDigits, exampleDigits);

  @Test
  public void itShouldReturnFalse() {
    final SplitInteger leftDigitsUnbalanced = new SplitInteger(exampleDigits, moreExampleDigits);
    final SplitInteger rightDigitsUnbalanced = new SplitInteger(moreExampleDigits, exampleDigits);
    Assert.assertFalse(tornNumberValidator1.isTornNumber(leftDigitsUnbalanced));
    Assert.assertFalse(tornNumberValidator1.isTornNumber(rightDigitsUnbalanced));
    Assert.assertFalse(tornNumberValidator2.isTornNumber(balancedSplitInteger));
  }

  @Test
  public void testExpected() {
    Assert.assertTrue(tornNumberValidator1.isTornNumber(balancedSplitInteger));
  }

}
