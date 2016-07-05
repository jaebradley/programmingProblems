package problems.impl;

import problems.interfaces.AdjacentDuplicateCharactersRemover;

import java.util.Stack;

/**
 * Related to this HackerRank problem https://www.hackerrank.com/challenges/reduced-string.
 *
 * The task is to remove all duplicate characters that are adjacent to each other in a given `String`, until no adjacent characters are the same.
 * If a `String` only contains adjacent duplicate characters then return an empty `String`.
 */

public class AdjacentDuplicateCharactersRemoverImpl implements AdjacentDuplicateCharactersRemover {

  /**
   * Given an input String, remove any Characters that are adjacent and the same.
   * @param s String to remove any adjacent duplicates from
   * @return String where no adjacent characters are identical
   */
  @Override
  public String removeAdjacentDuplicateCharacters(final String s) {
    final char[] chars = s.toCharArray();
    int len = 0;
    for (int i = 0; i < chars.length; i++) {
      if (len == 0 || chars[i] != chars[len - 1]) {
        chars[len++] = chars[i];
      } else {
        len--;
      }
    }
    return new String(chars, 0, len);
  }

}
