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
   * @param candidate String to remove any adjacent duplicates from
   * @return String where no adjacent characters are identical
   */
  @Override
  public String removeAdjacentDuplicateCharacters(final String candidate) {
    if (candidate.length() < 2) {
      return candidate;
    }

    final Stack<Character> originalCharacters = new Stack<>();
    for (char c : candidate.toCharArray()) {
      originalCharacters.push(c);
    }
    final Stack<Character> filteredCharacters = filterAdjacentDuplicateCharacters(originalCharacters);
    final StringBuilder stringBuilder = new StringBuilder();
    while (!filteredCharacters.empty()) {
      stringBuilder.append(filteredCharacters.pop());
    }
    return stringBuilder.toString();
  }

  /**
   * Given an input Stack of Characters, remove any Characters that are adjacent and the same.
   * @param characters Stack of Characters to remove adjacent duplicates from
   * @return Stack of Characters where no adjacent Characters are the same
   */
  @Override
  public Stack<Character> filterAdjacentDuplicateCharacters(final Stack<Character> characters) {
    if (characters.size() < 2) {
      return characters;
    }

    final Stack<Character> filteredCharacters = new Stack<>();
    while (!characters.empty()) {
      final char poppedChar = characters.pop();
      if (filteredCharacters.empty() || poppedChar != filteredCharacters.peek()) {
        filteredCharacters.push(poppedChar);
      } else {
        filteredCharacters.pop();
      }
    }

    return filteredCharacters;
  }
}
