package problems.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

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
    final Stack<Integer> initialDigits = new Stack<>();
    int number = positiveInt;
    while (number > 0) {
      initialDigits.add(number % 10);
      number = number / 10;
    }

    while (!initialDigits.isEmpty()) {
      digits.add(initialDigits.pop());
    }

    return digits;
  }

  public static List<Integer> positiveIntegerDigits(final long positiveInt) {
    if (positiveInt < 1) {
      throw new IllegalArgumentException("positiveInt is less than 1");
    }

    final List<Integer> digits = new ArrayList<>();
    final Stack<Integer> initialDigits = new Stack<>();
    long number = positiveInt;
    while (number > 0) {
      initialDigits.add(Math.toIntExact(number % 10));
      number = number / 10;
    }

    while (!initialDigits.isEmpty()) {
      digits.add(initialDigits.pop());
    }

    return digits;
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
