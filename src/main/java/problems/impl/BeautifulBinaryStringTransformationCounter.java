package problems.impl;

/**
 * Problem nearly identical to this HackerRank problem https://www.hackerrank.com/challenges/beautiful-binary-string
 *
 * A "beautiful" binary String is one that doesn't contain the substring "010". Given a String representing a binary
 * value (i.e. containing only 0s and 1s), count the minimum number of changes necessary to make the String beautiful.
 *
 */

public class BeautifulBinaryStringTransformationCounter {
  /**
   * Given a binary String, return the count of changes to the String necessary to make the String beautiful.
   * @param s String representing a binary value (contains only characters that are 0s and 1s)
   * @return count representing the minimum of changes necessary to remove all "010" substrings.
   */
  public static long count(String s) {
    if (s.length() < 3) {
      return 0;
    }

    long count = 0L;
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length - 2; i++) {
      if (chars[i] == '0' && chars[i+1] == '1' && chars[i+2] == '0') {
        chars[i+2] = '1';
        count++;
      }
    }

    return count;
  }
}
