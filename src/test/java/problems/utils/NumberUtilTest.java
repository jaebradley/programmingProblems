package problems.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class NumberUtilTest {

  @Test
  public void testPositiveIntegerDigitCount() {
    try {
      NumberUtil.positiveIntegerDigitCount(-1);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    try {
      NumberUtil.positiveIntegerDigitCount(0);
      Assert.fail();
    } catch (IllegalArgumentException e){
      // expected
    }

    Assert.assertEquals(NumberUtil.positiveIntegerDigitCount(1), 1);
    Assert.assertEquals(NumberUtil.positiveIntegerDigitCount(2), 1);
    Assert.assertEquals(NumberUtil.positiveIntegerDigitCount(9), 1);
    Assert.assertEquals(NumberUtil.positiveIntegerDigitCount(10), 2);
    Assert.assertEquals(NumberUtil.positiveIntegerDigitCount(99), 2);
    Assert.assertEquals(NumberUtil.positiveIntegerDigitCount(100), 3);
  }

  @Test
  public void testSquare() {
    Assert.assertEquals(NumberUtil.square(-2), 4);
    Assert.assertEquals(NumberUtil.square(-1), 1);
    Assert.assertEquals(NumberUtil.square(0), 0);
    Assert.assertEquals(NumberUtil.square(1), 1);
    Assert.assertEquals(NumberUtil.square(2), 4);
  }

  @Test
  public void testIsEven() {
    Assert.assertTrue(NumberUtil.isEven(-2));
    Assert.assertFalse(NumberUtil.isEven(-1));
    Assert.assertTrue(NumberUtil.isEven(0));
    Assert.assertFalse(NumberUtil.isEven(1));
    Assert.assertTrue(NumberUtil.isEven(2));
  }

  @Test
  public void testPositiveIntegerDigits() {
    try {
      NumberUtil.positiveIntegerDigitCount(-1);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    try {
      NumberUtil.positiveIntegerDigitCount(0);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    Assert.assertEquals(NumberUtil.positiveIntegerDigits(1), new ArrayList<>(Arrays.asList(1)));
    Assert.assertEquals(NumberUtil.positiveIntegerDigits(10), new ArrayList<>(Arrays.asList(1, 0)));
    Assert.assertEquals(NumberUtil.positiveIntegerDigits(100), new ArrayList<>(Arrays.asList(1, 0, 0)));
  }

  @Test
  public void testDivisorsForPositiveIntegers() {
    try {
      NumberUtil.getDivisorsForPositiveInteger(-1);
      Assert.fail();
    } catch (RuntimeException e) {
      // expected
    }

    try {
      NumberUtil.getDivisorsForPositiveInteger(0);
      Assert.fail();
    } catch (RuntimeException e) {
      // expected
    }

    Set<Integer> oneDivisors = new HashSet<>(Arrays.asList(1));
    Set<Integer> twoDivisors = new HashSet<>(Arrays.asList(1, 2));
    Set<Integer> tenDivisors = new HashSet<>(Arrays.asList(1, 2, 5, 10));
    Assert.assertEquals(NumberUtil.getDivisorsForPositiveInteger(1), oneDivisors);
    Assert.assertEquals(NumberUtil.getDivisorsForPositiveInteger(2), twoDivisors);
    Assert.assertEquals(NumberUtil.getDivisorsForPositiveInteger(10), tenDivisors);
  }

  @Test
  public void testDigitsToInteger() {
    final List<Integer> emptyList = new ArrayList<>();
    try {
      NumberUtil.digitsToInteger(emptyList);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }
    final List<Integer> digits = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    Assert.assertEquals(NumberUtil.digitsToInteger(digits), 123456789);
  }

}
