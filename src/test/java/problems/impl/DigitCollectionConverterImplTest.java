package problems.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.DigitCollectionConverter;

public class DigitCollectionConverterImplTest {
  private final DigitCollectionConverter digitCollectionConverter = new DigitCollectionConverterImpl();

  @Test
  public void itShouldThrowException() {
    final List<Integer> emptyList = new ArrayList<>();
    try {
      digitCollectionConverter.convertDigitCollectionToInteger(emptyList);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }
  }

  @Test
  public void itShouldConvertDigitsToInteger() {
    final List<Integer> digits = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    Assert.assertEquals(digitCollectionConverter.convertDigitCollectionToInteger(digits), 123456789);
  }
}
