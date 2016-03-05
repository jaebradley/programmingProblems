package problems.utils;

import java.util.ArrayList;
import java.util.List;

public class NumberUtil {
  public static int positiveIntegerDigitCount(final int positiveInt) {
    if (positiveInt < 1) {
      throw new IllegalArgumentException("positiveInt is less than 1");
    }
    return Double.valueOf(Math.log10(positiveInt)).intValue() + 1;
  }

  public static int square(final int squareRoot) {
    return Math.multiplyExact(squareRoot, squareRoot);
  }

  public static boolean isEven(final int number) {
    return (number % 2 == 0);
  }

  public static List<Integer>positiveIntegerDigits(final int positiveInt) {
    if (positiveInt < 1) {
      throw new IllegalArgumentException("positiveInt is less than 1");
    }

    final List<Integer> digits = new ArrayList<>();
    int number = positiveInt;
    while (number > 0) {
      number = number % 10;
      digits.add(number);
    }
    return digits;
  }
}
