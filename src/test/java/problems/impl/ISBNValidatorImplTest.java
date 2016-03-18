package problems.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.ISBNValidator;
import problems.interfaces.InverseMultiplierListProductSumGenerator;

public class ISBNValidatorImplTest {
  private final List<Integer> testValues1 = new ArrayList<>(Arrays.asList(1));
  private final InverseMultiplierListProductSumGenerator inverseMultiplierListProductSumGenerator = new InverseMultiplierListProductSumGenerator() {
    @Override public long generateInverseMultiplierListProductSum(final List<Integer> values) {
      if (values == testValues1) {
        return 11;
      } else {
        return 10;
      }
    }
  };
  private final ISBNValidator isbnValidator = new ISBNValidatorImpl(inverseMultiplierListProductSumGenerator);

  @Test
  public void testValidateISBN() {
    try {
      isbnValidator.validateISBN(-1);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    try {
      isbnValidator.validateISBN(0);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    Assert.assertFalse(isbnValidator.validateISBN(1));
    Assert.assertTrue(isbnValidator.validateISBN(2));
  }

}
