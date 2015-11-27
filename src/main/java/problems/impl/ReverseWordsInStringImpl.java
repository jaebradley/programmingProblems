package main.java.problems.impl;

import main.java.problems.interfaces.ReverseWordsInString;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInStringImpl implements ReverseWordsInString {
    public String slice_start(String s, int startIndex) {
        if (startIndex < 0) startIndex = s.length() + startIndex;
        return s.substring(startIndex);
    }

    public String slice_end(String s, int endIndex) {
        if (endIndex < 0) endIndex = s.length() + endIndex;
        return s.substring(0, endIndex);
    }

    public String slice_range(String s, int startIndex, int endIndex) {
        if (startIndex < 0) startIndex = s.length() + startIndex;
        if (endIndex < 0) endIndex = s.length() + endIndex;
        return s.substring(startIndex, endIndex);
    }
    @Override
    public String reverseWordsInString(final String string) {
        final List<String> reversedWordsStringStore = new ArrayList<>();
        reversedWordsStringStore.add(0, string);
        int characterIndex = 0;
        int wordIndexStart = 0;
        int stringStoreIndex = 1;
        final StringBuilder stringBuilder = new StringBuilder();
        while (characterIndex < string.length()) {
            if (' ' != string.charAt(characterIndex)) {
                if (stringBuilder.length() == 0) {
                    wordIndexStart = characterIndex;
                }
                stringBuilder.append(string.charAt(characterIndex));
            }

            if (' ' == string.charAt(characterIndex)) {
                if (stringBuilder.length() > 0) {
                    reversedWordsStringStore.add(stringStoreIndex, new StringBuilder().
                            append(reversedWordsStringStore.get(stringStoreIndex - 1).substring(0, wordIndexStart)).
                            append(stringBuilder.reverse().toString()).
                            append(reversedWordsStringStore.get(stringStoreIndex - 1).substring(characterIndex)).toString());
                    stringBuilder.setLength(0);
                    stringStoreIndex++;
                }
            }

            if (characterIndex == string.length() - 1) {
                if (stringBuilder.length() > 0) {
                    reversedWordsStringStore.add(stringStoreIndex, new StringBuilder().
                            append(reversedWordsStringStore.get(stringStoreIndex - 1).substring(0, wordIndexStart)).
                            append(stringBuilder.reverse().toString()).toString());
                    stringBuilder.setLength(0);
                    stringStoreIndex++;
                }
            }
            characterIndex++;
        }

        return reversedWordsStringStore.get(reversedWordsStringStore.size() - 1);
    }
}
