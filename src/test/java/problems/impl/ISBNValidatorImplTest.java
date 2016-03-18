package problems.impl;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.ISBNValidator;

public class ISBNValidatorImplTest {
  private final ISBNValidator isbnValidator = new ISBNValidatorImpl();

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

    Assert.assertFalse(isbnValidator.validateISBN(1000000000));
  }

}
