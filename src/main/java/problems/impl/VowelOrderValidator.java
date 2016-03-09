package problems.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Validate that a string's vowels are ordered in alphabetical order (A before E before I before O before U before Y)
 */

public class VowelOrderValidator {
    private static final List<Character> VOWELS = new ArrayList<>(
            Arrays.asList('A', 'E', 'I', 'O', 'U', 'Y')
    );

    public static boolean areVowelsOrdered(final String candidate) {
        final char[] chars = candidate.toUpperCase(Locale.ROOT).toCharArray();
        int lastVowelIndex = 0;
        for (final char c : chars) {
            final int lookupIndex = VOWELS.indexOf(c);
            if (0 >= lookupIndex) {
                if (lookupIndex < lastVowelIndex) {
                    return false;
                } else {
                    lastVowelIndex = lookupIndex;
                }
            }

        }

        return true;
    }
}
