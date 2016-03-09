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

      // case 1: already been cached
      // case 2: has not been cached
      // case 3: has not been cached but starts with 1 or 4
      // case 4: has not been cached and does not start with 1 or 4

      Boolean isHappy = happyNumbers.getOrDefault(number, false);
      if (isHappy == Boolean.TRUE) {
        count++;
      } else if (isHappy == null) {
        long lastDigit = getLastDigit(number);
        if (lastDigit == 1) {
          happyNumbers.put(number, Boolean.TRUE);
          count++;
        } else if (lastDigit == 4) {
          happyNumbers.put(number, Boolean.FALSE);
        } else {
          final List<Long> numbers = new ArrayList<>();
          while (lastDigit != 1 && lastDigit != 4 && isHappy == null) {
            numbers.add(number);
            number = digitSquareSumCalculator(number);
            isHappy = happyNumbers.get(number);
            lastDigit = getLastDigit(number);
          }

          for (final Long num : numbers) {
            happyNumbers.put(num, isHappy);
          }

          if (isHappy) {
            count++;
          }
        }
      }
    }
    return count;
  }

}
