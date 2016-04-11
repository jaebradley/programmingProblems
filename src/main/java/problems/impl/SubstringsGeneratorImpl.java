package problems.impl;

import problems.interfaces.SubstringsGenerator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubstringsGeneratorImpl implements SubstringsGenerator {

  /**
   * For a given input string, return a map of substrings where the keys represent the substring length and the values
   * represent a set of substrings with the key length.
   *
   * @param value input string to evaluate substrings
   * @return a map of substring lengths to substrings
   */
  @Override
  public Map<Integer, Set<String>> generateLengthSortedSubstrings(final String value) {
    final Map<Integer, Set<String>> lengthSortedSubstrings = new HashMap<>();
    for (int length = 1; length <= value.length(); length++) {
      lengthSortedSubstrings.put(length, generateSubstrings(value, length));
    }
    return lengthSortedSubstrings;
  }

  /**
   * Identifies a set of all substrings for an input string and a substring length.
   *
   * Throws exceptions is substring length is negative or greater than the length of the input string.
   *
   * @param value input string
   * @param length substring length
   * @return a set of all substrings with the input substring length
   */
  @Override
  public Set<String> generateSubstrings(final String value, final int length) {
    if (length > value.length()) {
      throw new IllegalArgumentException("length value is greater than length of input string");
    }

    if (length < 0) {
      throw new IllegalArgumentException("length value must be non-negative");
    }

    final Set<String> substrings = new HashSet<>();

    if (length == 0) {
      return substrings;
    }

    for (int index = 0; index <= value.length() - length; index++) {
      substrings.add(value.substring(index, index + length));
    }
    return substrings;
  }
}
