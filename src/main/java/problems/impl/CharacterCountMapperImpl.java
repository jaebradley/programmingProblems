package problems.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import problems.interfaces.CharacterCountMapper;

public class CharacterCountMapperImpl implements CharacterCountMapper {
  @Override
  public Map<Character, Long> mapCharacterCount(final String value) {
    if (null == value) {
      throw new IllegalArgumentException("input string cannot be null");
    }
    final Map<Character, Long> characterCountMap = new HashMap<>();
    for (char c : value.toCharArray()) {
      final Long keyValue = characterCountMap.get(c);
      long updatedKeyValue = keyValue == null ? 1L : keyValue + 1;
      characterCountMap.put(c, updatedKeyValue);
    }
    return characterCountMap;
  }

  @Override
  public boolean isValidString(final String value) {
    if (null == value) {
      throw new IllegalArgumentException("input string cannot be null");
    }
    final Map<Character, Long> characterCountMap = mapCharacterCount(value);
    return new HashSet<>(characterCountMap.values()).size() <= 1;
  }

  @Override
  public boolean isAlmostValidStringByRemoval(final String value) {
    if (null == value) {
      throw new IllegalArgumentException("input string cannot be null");
    }
    final Map<Character, Long> characterCountMap = mapCharacterCount(value);
    final Set<Long> distinctCounts = new HashSet<>(characterCountMap.values());
    final long minValue = Collections.min(distinctCounts);

    if (distinctCounts.size() == 0) {
      return false;
    }

    long minValueCount = 0;
    for (final long characterCount : characterCountMap.values()) {
      if (characterCount == minValue) {
        minValueCount++;
      }
    }

    final long absoluteCountsDifference = Math.abs(Collections.max(distinctCounts)) - Math.abs(Collections.min(distinctCounts));
    final boolean isOneMaxValueWithOneUnitDifference = absoluteCountsDifference == 1 && minValueCount == characterCountMap.values().size() - 1;
    final boolean isOneMinValue = minValue == 1 && minValueCount == 1;
    return distinctCounts.size() == 2 && (isOneMaxValueWithOneUnitDifference || isOneMinValue);
  }

  @Override
  public boolean isAtLeastAlmostValidStringByRemoval(final String value) {
    return isAlmostValidStringByRemoval(value) || isValidString(value);
  }
}
