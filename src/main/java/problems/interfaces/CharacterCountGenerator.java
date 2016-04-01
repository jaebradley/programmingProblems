package problems.interfaces;

import java.util.Map;

public interface CharacterCountGenerator {
  Map<Character, Integer> generateCharacterCount(final String value);

  Map<Character, Integer> incrementCharacterCount(final Map<Character, Integer> characterCount, char character);
}
