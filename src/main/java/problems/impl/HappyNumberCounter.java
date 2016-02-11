package problems.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HappyNumberCounter {

  public static int getFirstDigit(final long number) {
    return Math.toIntExact(number % 10);
  }

  public static long digitSquareSumCalculator(final long number) {
    int remainder = getFirstDigit(number);
    long quotient = number / 10;
    long digitSum = remainder * remainder;
    while (quotient > 0) {
      remainder = getFirstDigit(quotient);
      quotient = quotient / 10;
      digitSum = remainder * remainder;
    }

    return digitSum;
  }

  public static long countHappyNumbersInRange(final long start, final long end) {
    final Map<Long, Boolean> happyNumbers = new HashMap<>();
    long count = 0;
    for (long index = start; index <= end; index++) {
      long number = index;
      final List<Long> numbers = new ArrayList<>();
      Boolean isHappyNumber = happyNumbers.get(number);
      long firstDigit = getFirstDigit(number);
      while (firstDigit != 1 && firstDigit != 4 && isHappyNumber == null) {
        numbers.add(number);
        number = digitSquareSumCalculator(number);
        isHappyNumber = happyNumbers.get(number);
        firstDigit = getFirstDigit(number);
      }

      if (isHappyNumber || firstDigit == 1) {
        for (final Long num : numbers) {
          happyNumbers.put(num, true);
        }
        count += 1;
      }

      if (!isHappyNumber || firstDigit == 4) {
        for (final Long num : numbers) {
          happyNumbers.put(num, false);
        }
      }
    }
    return count;
  }
}
