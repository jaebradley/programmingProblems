package problems.impl;

import problems.interfaces.AlmostEquivalentCharacterFrequencyValidator;

import java.util.*;

public class AlmostEquivalentCharacterFrequencyValidatorImpl implements AlmostEquivalentCharacterFrequencyValidator {
    public boolean validateAlmostEquivalentCharacterFrequency(final String candidate) {
        if (0 == candidate.trim().length()) {
            throw new IllegalArgumentException("string candidate must have non-zero non-whitespace length");
        }

        final Map<Character, Integer> characterCountMap = new HashMap<>();
        for (final char c : candidate.toLowerCase().toCharArray()) {
            final Integer value = characterCountMap.get(c);
            if (null == value) {
                characterCountMap.put(c, 1);
            } else {
                characterCountMap.put(c, value + 1);
            }
        }

        final Map<Integer, Integer> characterCountCountMap = new HashMap<>();
        for (final Map.Entry<Character, Integer> entry : characterCountMap.entrySet()) {
            final Integer value = characterCountCountMap.get(entry.getValue());
            if (null == value) {
                characterCountCountMap.put(entry.getValue(), 1);
            } else {
                characterCountCountMap.put(entry.getValue(), value + 1);
            }
        }
        return (1 == characterCountCountMap.size()) | (2 == characterCountCountMap.size() && characterCountCountMap.containsKey(1) && 1 == characterCountCountMap.get(1));
    }
}
