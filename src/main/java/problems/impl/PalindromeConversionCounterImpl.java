package problems.impl;

import problems.interfaces.PalindromeConversionCounter;

/**
 * Inspired by this HackerRank challenge https://www.hackerrank.com/challenges/the-love-letter-mystery
 *
 * Basically, count the minimum number of operations to convert a String to a palindrome. An additional rule is that
 * each operation must reduce the "value" of the character. So, can convert "d" to "c" but not "c" to "d".
 */
public class PalindromeConversionCounterImpl implements PalindromeConversionCounter {
  /**
   * Counts the number of character replacements necessary to convert the input String to a palindrome. Characters must
   * be replaced by a character that is of a lesser "value" of the current character. So "c" can be replaced with "b"
   * but not "d".
   * @param s String to convert
   * @return count of character replacements
   */
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
