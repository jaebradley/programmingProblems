package problems.impl;

import problems.exceptions.NoUniqueCharactersException;
import problems.interfaces.FirstUniqueCharacterInStringIdentifier;

public class FirstUniqueCharacterInStringIdentifierImpl implements FirstUniqueCharacterInStringIdentifier {
    @Override
    public Character identifyFirstUniqueCharacterInString(final String string) throws NoUniqueCharactersException {
        final char[] chars = string.toCharArray();
        final boolean[] repeatedCharacterIndices = new boolean[chars.length];
        for (int candidateCharacterIndex = 0; candidateCharacterIndex < chars.length; candidateCharacterIndex++) {
            for (int comparisonCharacterIndex = candidateCharacterIndex + 1; comparisonCharacterIndex < chars.length; comparisonCharacterIndex++) {
                if (chars[candidateCharacterIndex] == chars[comparisonCharacterIndex]) {
                    repeatedCharacterIndices[candidateCharacterIndex] = true;
                    repeatedCharacterIndices[comparisonCharacterIndex] = true;
                }
            }
        }
        for (int repeatedCharacterIndex = 0; repeatedCharacterIndex < repeatedCharacterIndices.length; repeatedCharacterIndex++) {
            if (!repeatedCharacterIndices[repeatedCharacterIndex]) {
                return chars[repeatedCharacterIndex];
            }
        }

        throw new NoUniqueCharactersException();
    }
}
