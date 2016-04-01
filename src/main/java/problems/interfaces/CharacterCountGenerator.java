package problems.interfaces;

import java.util.Map;

public interface CharacterCountGenerator {
  Map<Character, Integer> generateCharacterCount(final String value);

  Map<Character, Integer> generateAlphabeticCharacterCount(final String value);

  Map<Character, Integer> incrementCharacterCount(final Map<Character, Integer> characterCount, char character);

  Map<Character, Integer> incrementAlphabeticCharacterCount(final Map<Character, Integer> characterCount, char character);
}
