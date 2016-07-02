package problems.impl;

import problems.interfaces.AdjacentDuplicateCharactersRemover;

import java.util.Stack;

public class AdjacentDuplicateCharactersRemoverImpl implements AdjacentDuplicateCharactersRemover {
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
