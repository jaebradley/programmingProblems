package main.java.problems.impl;

import main.java.problems.interfaces.ReverseWordsInString;

/**
 * Reverse the words in a string, while maintaining the order of the words in the string.
 * A word is defined as any collection of characters within a string that is separated by an arbitrary number of spaces.
 */
public class ReverseWordsInStringImpl implements ReverseWordsInString {
    /**
     * Returns a String where all the words of the input String are reversed.
     *
     * Does not take punctuation into account so " a  fox    jumped over a log! " will return " a  xof   depmuj revor a !gol "
     * @param string input String for word reversal
     * @return String where all words in the input String are reversed
     */
    @Override
    public String reverseWordsInString(final String string) {
        final String[] candidateReversedWordsString = new String[1];
        candidateReversedWordsString[0] = string;
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
                candidateReversedWordsString[0] = new StringBuilder().
                        append(candidateReversedWordsString[0].substring(0, wordStartIndex)).
                        append(reverseWordStringBuilder.reverse().toString()).
                        append(candidateReversedWordsString[0].substring(stringCharacterIndex)).toString();
                reverseWordStringBuilder.setLength(0);
            }

            if (stringCharacterIndex == string.length() - 1 && reverseWordStringBuilder.length() > 0) {
                candidateReversedWordsString[0] = new StringBuilder().
                        append(candidateReversedWordsString[0].substring(0, wordStartIndex)).
                        append(reverseWordStringBuilder.reverse().toString()).toString();
            }
            stringCharacterIndex++;
        }

        return candidateReversedWordsString[0];
    }
}
