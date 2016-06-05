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

    if (distinctCounts.size() == 0) {
      return false;
    }

    final long absoluteCountsDifference = Math.abs(Collections.max(distinctCounts)) - Math.abs(Collections.min(distinctCounts));
    return distinctCounts.size() == 2 && absoluteCountsDifference == 1;
  }

  @Override
  public boolean isAtLeastAlmostValidStringByRemoval(final String value) {
    return isAlmostValidStringByRemoval(value) || isValidString(value);
  }
}
