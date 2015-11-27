package main.java.problems.impl;

import main.java.problems.interfaces.ReverseWordsInString;

public class ReverseWordsInStringImpl implements ReverseWordsInString {
    @Override
    public String reverseWordsInString(final String string) {
        final String[] lastString = new String[1];
        lastString[0] = string;
        int stringCharacterIndex = 0;
        int wordStartIndex = 0;
        final StringBuilder reverseWordStringBuilder = new StringBuilder();
        while (stringCharacterIndex < string.length()) {
            if (' ' != string.charAt(stringCharacterIndex)) {
                if (reverseWordStringBuilder.length() == 0) {
                    wordStartIndex = stringCharacterIndex;
                }
                reverseWordStringBuilder.append(string.charAt(stringCharacterIndex));
            }

            if (' ' == string.charAt(stringCharacterIndex) && reverseWordStringBuilder.length() > 0) {
                lastString[0] = new StringBuilder().
                        append(lastString[0].substring(0, wordStartIndex)).
                        append(reverseWordStringBuilder.reverse().toString()).
                        append(lastString[0].substring(stringCharacterIndex)).toString();
                reverseWordStringBuilder.setLength(0);
            }

            if (stringCharacterIndex == string.length() - 1 && reverseWordStringBuilder.length() > 0) {
                lastString[0] = new StringBuilder().
                        append(lastString[0].substring(0, wordStartIndex)).
                        append(reverseWordStringBuilder.reverse().toString()).toString();
            }
            stringCharacterIndex++;
        }

        return lastString[0];
    }
}
