package problems.impl;

import problems.interfaces.MaximumPalindromeCreator;

import java.util.HashMap;
import java.util.Map;

public class MaximumPalindromeCreatorImpl implements MaximumPalindromeCreator {
  @Override
  public String createMaximumPalindrome(final String input, final int maxChangesCount) {
    final Map<Integer, Pair> palindromeChanges = new HashMap<>();
    for (int i = 0, j = input.length() - 1; i < j; i++, j--) {
      int firstValue = Character.getNumericValue(input.charAt(i));
      int secondValue = Character.getNumericValue(input.charAt(j));
      if (firstValue != secondValue) {
        palindromeChanges.put(i, new Pair(firstValue, secondValue));
      }
    }

    int extraChanges = maxChangesCount - palindromeChanges.entrySet().size();

    if (extraChanges < 0) {
      throw new IllegalStateException();
    }

    final char[] chars = input.toCharArray();
    if (extraChanges == 0) {
      for (Map.Entry<Integer, Pair> entry : palindromeChanges.entrySet()) {
        chars[entry.getKey()] = Character.forDigit(entry.getValue().getMaxValue(), 10);
        chars[chars.length - 1 - entry.getKey()] = Character.forDigit(entry.getValue().getMaxValue(), 10);
      }
      return new String(chars);
    }

    int beginning = 0;
    int end = input.length() - 1;
    while (extraChanges > 0 & beginning <= end) {
      final Pair pair = palindromeChanges.get(beginning);
      if (pair != null) {
        chars[beginning] = Character.forDigit(9, 10);
        chars[end] = Character.forDigit(9, 10);
        extraChanges -= 2;
      } else {
        if (extraChanges == 1) {
          if (pair.getValue1() == pair.getMaxValue()) {
            chars[end] = Character.forDigit(pair.getMaxValue(), 10);
          } else {
            chars[beginning] = Character.forDigit(pair.getMaxValue(), 10);
          }
          extraChanges--;
        }

        if (extraChanges > 1) {
          chars[beginning] = Character.forDigit(9, 10);
          chars[end] = Character.forDigit(9, 10);
          extraChanges -= 2;
        }
      }

      beginning++;
      end--;
    }

    return new String(chars);
  }

  public static class Pair {
    private final int value1;
    private final int value2;

    public Pair(final int value1, final int value2) {
      this.value1 = value1;
      this.value2 = value2;
    }

    public int getValue1() {
      return value1;
    }

    public int getValue2() {
      return value2;
    }

    public int getMaxValue() {
      if (value1 < value2) {
        return value2;
      }

      return value1;
    }
  }
}
