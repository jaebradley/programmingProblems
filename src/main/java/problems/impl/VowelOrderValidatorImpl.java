package problems.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VowelOrderValidatorImpl {
    private static final List<Character> vowels = new ArrayList<>(
            Arrays.asList('A', 'E', 'I', 'O', 'U', 'Y')
    );

    public static boolean areVowelsOrdered(final String candidate) {
        final char[] chars = candidate.toUpperCase().toCharArray();
        int lastVowelIndex = 0;
        for (final char c : chars) {
            final int lookupIndex = vowels.indexOf(c);
            if (-1 != lookupIndex) {
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
