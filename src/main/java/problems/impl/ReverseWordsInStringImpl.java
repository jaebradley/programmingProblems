package main.java.problems.impl;

import main.java.problems.interfaces.ReverseWordsInString;

public class ReverseWordsInStringImpl implements ReverseWordsInString {
    @Override
    public String reverseWordsInString(final String string) {
        final String[] lastString = new String[1];
        lastString[0] = string;

        int characterIndex = 0;
        int wordIndexStart = 0;
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
                    lastString[0] = new StringBuilder().
                            append(lastString[0].substring(0, wordIndexStart)).
                            append(stringBuilder.reverse().toString()).
                            append(lastString[0].substring(characterIndex)).toString();
                    stringBuilder.setLength(0);
                }
            }

            if (characterIndex == string.length() - 1) {
                if (stringBuilder.length() > 0) {
                    lastString[0] = new StringBuilder().
                            append(lastString[0].substring(0, wordIndexStart)).
                            append(stringBuilder.reverse().toString()).toString();
                    stringBuilder.setLength(0);
                }
            }
            characterIndex++;
        }

        return lastString[0];
    }
}
