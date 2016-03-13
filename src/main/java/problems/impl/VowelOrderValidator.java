package problems.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Validate that a string's vowels are ordered in alphabetical order (A before E before I before O before U before Y)
 *
 * Codereview Stackexchange thread: http://codereview.stackexchange.com/questions/119205/vowels-in-a-string-are-in-alphabetical-order
 */

public class VowelOrderValidator {
    private static final List<Character> VOWELS = new ArrayList<>(
            Arrays.asList('A', 'E', 'I', 'O', 'U', 'Y')
    );

    public static boolean areVowelsOrdered(final String candidate) {
        final List<Integer> seenVowelIndices = new ArrayList<>();
        for (final char c : candidate.toUpperCase(Locale.ROOT).toCharArray()) {
            final int lookupIndex = VOWELS.indexOf(c);
            if (lookupIndex > -1) {
                seenVowelIndices.add(lookupIndex);
                if (seenVowelIndices.size() > 1) {
                    if (seenVowelIndices.get(seenVowelIndices.size() - 2) > seenVowelIndices.get(seenVowelIndices.size() - 1)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
