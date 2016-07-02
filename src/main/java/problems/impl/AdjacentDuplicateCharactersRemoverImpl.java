package problems.impl;

import problems.interfaces.AdjacentDuplicateCharactersRemover;

import java.util.ArrayList;
import java.util.Stack;

public class AdjacentDuplicateCharactersRemoverImpl implements AdjacentDuplicateCharactersRemover {
  @Override
  public String removeAdjacentDuplicateCharacters(final String candidate) {
    if (candidate.isEmpty()) {
      return candidate;
    }

    if (candidate.length() == 1) {
      return candidate;
    }

    final Stack<Character> originalCharacters = new Stack<>();
    for (char c : candidate.toCharArray()) {
      originalCharacters.push(c);
    }
    final Stack<Character> filteredCharacters = filterAdjacentDuplicateCharacters(originalCharacters);
    final StringBuilder stringBuilder = new StringBuilder();
    for (char c : new ArrayList<>(filteredCharacters)) {
      stringBuilder.append(c);
    }
    return stringBuilder.toString();
  }

  @Override
  public Stack<Character> filterAdjacentDuplicateCharacters(final Stack<Character> characters) {
    final Stack<Character> filteredCharacters = new Stack<>();
    while (!characters.empty()) {
      final char poppedChar = characters.pop();
      if (poppedChar != filteredCharacters.peek()) {
        filteredCharacters.push(poppedChar);
      } else {
        filteredCharacters.pop();
      }
    }

    return filteredCharacters;
  }
}
