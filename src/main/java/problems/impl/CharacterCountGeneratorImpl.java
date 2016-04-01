package problems.impl;

import java.util.HashMap;
import java.util.Map;

import problems.interfaces.CharacterCountGenerator;

public class CharacterCountGeneratorImpl implements CharacterCountGenerator {
  @Override
  public Map<Character, Integer> generateCharacterCount(final String value) {
    final Map<Character, Integer> characterCount = new HashMap<>();
    for (final char c : value.toCharArray()) {
      incrementCharacterCount(characterCount, c);
    }
    return characterCount;
  }

  @Override
  public Map<Character, Integer> incrementCharacterCount(final Map<Character, Integer> characterCount, final char character) {
    Integer count = characterCount.get(character);
    if (null == count) {
      count = 0;
    }
    characterCount.put(character, ++count);
    return characterCount;
  }
}
