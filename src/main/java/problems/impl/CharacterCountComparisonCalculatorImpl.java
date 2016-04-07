package problems.impl;

import problems.interfaces.CharacterCountComparisonCalculator;
import problems.interfaces.DistinctValuesCalculator;

import java.util.Collections;
import java.util.Map;

public class CharacterCountComparisonCalculatorImpl implements CharacterCountComparisonCalculator {
  private final DistinctValuesCalculator distinctValuesCalculator;

  public CharacterCountComparisonCalculatorImpl(final DistinctValuesCalculator distinctValuesCalculator) {
    this.distinctValuesCalculator = distinctValuesCalculator;
  }

  @Override
  public boolean allCharactersHaveEquivalentCountValue(final Map<Character, Long> characterCount) {
    if (characterCount == null) {
      throw new IllegalArgumentException("input can't be null");
    }

    if (characterCount.containsKey(null)) {
      throw new IllegalArgumentException("key values must be non-null");
    }

    if (characterCount.containsValue(null)) {
      throw new IllegalArgumentException("all values must be non-null");
    }

    if (Collections.min(characterCount.values()) < 0) {
      throw new IllegalArgumentException("all counts must be non-negative");
    }

    return distinctValuesCalculator.calculateDistinctNonNullValues(characterCount.values()) == 0;
  }

  @Override
  public boolean allAlphabeticCharactersHaveEquivalentCountValue(final Map<Character, Long> characterCount) {
    for (final Character c : characterCount.keySet()) {
      if (!Character.isAlphabetic(c)) {
        throw new IllegalArgumentException("character is non-alphabetic");
      }
    }
    return allCharactersHaveEquivalentCountValue(characterCount);
  }

  @Override
  public boolean oneCharacterHasAOneUnitGreaterCountValue(final Map<Character, Long> characterCount) {
    if (characterCount == null) {
      throw new IllegalArgumentException("input can't be null");
    }

    if (characterCount.containsKey(null)) {
      throw new IllegalArgumentException("key values must be non-null");
    }

    if (characterCount.containsValue(null)) {
      throw new IllegalArgumentException("all values must be non-null");
    }

    if (Collections.min(characterCount.values()) < 0) {
      throw new IllegalArgumentException("all counts must be non-negative");
    }

   return distinctValuesCalculator.calculateDistinctNonNullValues(characterCount.values()) == 2 && (Collections.max(characterCount.values()) - Collections.min(characterCount.values())) == 1;
  }

  @Override
  public boolean oneAlphabeticCharacterHasAOneUnitGreaterCountValue(final Map<Character, Long> characterCount) {
    for (final Character c : characterCount.keySet()) {
      if (!Character.isAlphabetic(c)) {
        throw new IllegalArgumentException("character is non-alphabetic");
      }
    }
   return oneCharacterHasAOneUnitGreaterCountValue(characterCount);
  }
}
