package problems.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.DigitsIdentifier;
import problems.interfaces.ISBNValidator;
import problems.interfaces.InverseMultiplierListProductSumGenerator;

public class ISBNValidatorImplTest {
  private final List<Integer> testValues1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 0));
  private final List<Integer> testValues2 = new ArrayList<>(Arrays.asList(1));
  private final DigitsIdentifier digitsIdentifier1 = new DigitsIdentifier() {
    @Override
    public List<Integer> identifyDigits(final long number) {
      return testValues1;
    }
  };
  private final DigitsIdentifier digitsIdentifier2 = new DigitsIdentifier() {
    @Override
    public List<Integer> identifyDigits(final long number) {
      return testValues2;
    }
  };
  private final InverseMultiplierListProductSumGenerator inverseMultiplierListProductSumGenerator = new InverseMultiplierListProductSumGenerator() {
    @Override public long generateInverseMultiplierListProductSum(final List<Integer> values) {
      if (values.equals(testValues1)) {
        return 11;
      } else {
        return 10;
      }
    }
  };
  private final ISBNValidator isbnValidator1 = new ISBNValidatorImpl(inverseMultiplierListProductSumGenerator, digitsIdentifier1);
  private final ISBNValidator isbnValidator2 = new ISBNValidatorImpl(inverseMultiplierListProductSumGenerator, digitsIdentifier2);

  @Test
  public void itShouldThrowException() {
    try {
      isbnValidator1.validateISBN(-1);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }
  }

  @Test
  public void itShouldReturnTooFewDigits() {
    Assert.assertFalse(isbnValidator2.validateISBN(1));
  }

  @Test
  public void itShouldValidateIsbn() {
    Assert.assertTrue(isbnValidator1.validateISBN(1));
  }

}
