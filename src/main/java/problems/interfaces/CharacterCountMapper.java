package problems.interfaces;

import java.util.Map;

public interface CharacterCountMapper {
  Map<Character, Long> mapCharacterCount(final String value);

  boolean isValidString(final String value);

  boolean isAlmostValidStringByRemoval(final String value);
}
