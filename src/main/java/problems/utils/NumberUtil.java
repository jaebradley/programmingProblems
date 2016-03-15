package problems.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

  public static List<Integer> positiveIntegerDigits(final int positiveInt) {
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

  public static int digitsToInteger(final List<Integer> digits) {
    final StringBuilder stringBuilder = new StringBuilder();
    final Iterator<Integer> iterator = digits.iterator();
    while(iterator.hasNext())
    {
      stringBuilder.append(iterator.next());
    }
    return Integer.valueOf(stringBuilder.toString());
  }

  public static Set<Integer> getDivisorsForPositiveInteger(final int positiveInteger) {
    if (positiveInteger < 1) {
      throw new RuntimeException("positive integer must be greater than 0");
    }

    final Set<Integer> divisors = new HashSet<>();
    for (int candidateDivisor = 1; candidateDivisor <= Math.ceil(Math.sqrt(positiveInteger)); candidateDivisor++) {
      if (positiveInteger % candidateDivisor == 0) {
        divisors.add(candidateDivisor);
        divisors.add(new Double(positiveInteger / candidateDivisor).intValue());
      }
    }
    return divisors;
  }
}
