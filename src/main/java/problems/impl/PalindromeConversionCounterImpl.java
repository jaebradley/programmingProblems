package problems.impl;

import problems.interfaces.PalindromeConversionCounter;

public class PalindromeConversionCounterImpl implements PalindromeConversionCounter {
  @Override
  public int count(final String s) {
    int count = 0;
    final char[] chars = s.toCharArray();
    for (int i = 0; i < Math.ceil(chars.length / 2); i++) {
      final char currentChar = chars[i];
      final char oppositeChar = chars[chars.length - 1 - i];
      if (!Character.isAlphabetic(currentChar) || !Character.isAlphabetic(oppositeChar)) {
        throw new IllegalArgumentException("String should contain only alphabetic characters");
      }
      count += Math.abs(currentChar - oppositeChar);
    }
    return count;
  }
}
