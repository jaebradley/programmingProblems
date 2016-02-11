package problems.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HappyNumberCounter {

  public static int getLastDigit(final long number) {
    return Math.toIntExact(number % 10);
  }

  public static long digitSquareSumCalculator(final long number) {
    int remainder = getLastDigit(number);
    long quotient = number / 10;
    long digitSum = remainder * remainder;
    while (quotient > 0) {
      remainder = getLastDigit(quotient);
      quotient = quotient / 10;
      digitSum = remainder * remainder;
    }

    return digitSum;
  }

  public static long countHappyNumbersInRange(final long startInclusive, final long endInclusive) {
    final Map<Long, Boolean> happyNumbers = new HashMap<>();
    long count = 0;
    for (long index = startInclusive; index <= endInclusive; index++) {
      long number = index;
      final List<Long> numbers = new ArrayList<>();
      Boolean isHappyNumber = happyNumbers.get(number);
      long lastDigit = getLastDigit(number);
      if (isHappyNumber != null) {
        if (lastDigit == 1) {
          count += 1;
        }
      } else {
        while (lastDigit != 1 && lastDigit != 4 && isHappyNumber == null) {
          numbers.add(number);
          number = digitSquareSumCalculator(number);
          isHappyNumber = happyNumbers.get(number);
          lastDigit = getLastDigit(number);
        }

        if (isHappyNumber) {
          for (final Long num : numbers) {
            happyNumbers.put(num, true);
          }
          count += 1;
        } else {
          for (final Long num : numbers) {
            happyNumbers.put(num, false);
          }
        }
      }
    }
    return count;
  }
}
