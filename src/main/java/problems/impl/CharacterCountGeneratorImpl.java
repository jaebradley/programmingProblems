package problems.impl;

import java.util.HashMap;
import java.util.Map;

import problems.interfaces.CharacterCountGenerator;

public class CharacterCountGeneratorImpl implements CharacterCountGenerator {
  @Override public Map<Character, Integer> generateCharacterCount(final String value) {
    final Map<Character, Integer> characterCounts = new HashMap<>();
    for (final char c : value.toCharArray()) {
      Integer characterCount = characterCounts.get(c);
      if (null == characterCount) {
        characterCount = 0;
      }
      characterCounts.put(c, ++characterCount);
    }
    return characterCounts;
  }
}
