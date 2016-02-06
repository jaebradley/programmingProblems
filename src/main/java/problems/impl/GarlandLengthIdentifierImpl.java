package problems.impl;

import problems.interfaces.GarlandLengthIdentifier;

import java.util.Arrays;

public class GarlandLengthIdentifierImpl implements GarlandLengthIdentifier {
    @Override
    public int identifyGarlandLength(final String candidate) {
        // check if string is non-empty or size 1
        final char[] chars = candidate.toCharArray();
        for (int subStringIndex = 1; subStringIndex < chars.length - 1 - subStringIndex; subStringIndex++) {
            char[] subStringChars = Arrays.copyOfRange(chars, subStringIndex, chars.length);
            if (!candidateIsASubset(chars, subStringChars)) {
                return subStringIndex - 1;
            }
        }

        return chars.length;
    }

    @Override
    public boolean candidateIsASubset(final char[] chars, final char[] candidateChars) {
        for (int index = 0; index < chars.length - candidateChars.length; index++) {
            for (int candidateCharIndex = 0; candidateCharIndex < candidateChars.length; candidateCharIndex++) {
                if (chars[index + candidateCharIndex] != candidateChars[candidateCharIndex]) {
                    return false;
                }
            }
        }

        return true;
    }
}
