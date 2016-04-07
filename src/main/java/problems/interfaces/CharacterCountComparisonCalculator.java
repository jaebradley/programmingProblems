package problems.interfaces;

import java.util.Map;

public interface CharacterCountComparisonCalculator {
  boolean allCharactersHaveEquivalentCountValue(final Map<Character, Long> characterCount);

  boolean allAlphabeticCharactersHaveEquivalentCountValue(final Map<Character, Long> characterCount);

  boolean oneCharacterHasAOneUnitGreaterCountValue(final Map<Character, Long> characterCount);

  boolean oneAlphabeticCharacterHasAOneUnitGreaterCountValue(final Map<Character, Long> characterCount);
}
