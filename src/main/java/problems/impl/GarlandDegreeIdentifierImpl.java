package problems.impl;

import problems.interfaces.GarlandDegreeIdentifier;

import java.util.Arrays;

public class GarlandDegreeIdentifierImpl implements GarlandDegreeIdentifier {
    @Override
    public int identifyGarlandDegree(final String candidate) {
        switch (candidate.length()) {
            case 0: {
                return 0;
            }

            case 1: {
                return 1;
            }

            default: {
                final char[] chars = candidate.toCharArray();
                for (int subStringIndex = 1; subStringIndex <= chars.length - subStringIndex; subStringIndex++) {
                    final char[] startingChars = Arrays.copyOfRange(chars, 0, subStringIndex);
                    final char[] remainingChars = Arrays.copyOfRange(chars, subStringIndex, chars.length);
                    if (subsetIndexIdentifier(remainingChars, startingChars) == -1) {
                        return subStringIndex - 1;
                    }
                }

                return Math.floorDiv(chars.length, 2);
            }
        }
    }

    @Override
    public int subsetIndexIdentifier(final char[] chars, final char[] candidateChars) {
        for (int index = 0; index <= chars.length - candidateChars.length; index++) {
            int counter = 0;
            for (int candidateCharIndex = 0; candidateCharIndex < candidateChars.length; candidateCharIndex++) {
                if (chars[index + candidateCharIndex] != candidateChars[candidateCharIndex]) {
                    counter++;
                }
            }

            if (0 == counter) {
                return index;
            }
        }

        return -1;
    }
}
