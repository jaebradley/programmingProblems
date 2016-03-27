package problems.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NumberUtil {
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

}
