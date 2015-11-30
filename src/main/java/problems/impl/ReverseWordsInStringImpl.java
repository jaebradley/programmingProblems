package main.java.problems.impl;

import main.java.problems.interfaces.ReverseWordsInString;
import main.java.problems.interfaces.ReverseWordsInStringUsingStack;

import java.util.Stack;

/**
 * Reverse the words in a string, while maintaining the order of the words in the string.
 * A word is defined as any collection of characters within a string that is separated by an arbitrary number of spaces.
 */
public class ReverseWordsInStringImpl implements ReverseWordsInString, ReverseWordsInStringUsingStack {
    /**
     * Returns a String where all the words of the input String are reversed.
     *
     * Does not take punctuation into account so " a  fox    jumped over a log! " will return " a  xof   depmuj revor a !gol "
     * @param string input String for word reversal
     * @return String where all words in the input String are reversed
     */
    @Override
    public String reverseWordsInString(final String string) {
        final char[] chars = string.toCharArray();
        int wordStartIndex = -1;

        for (int charIndex = 0; charIndex < chars.length; charIndex++) {
            if (Character.isWhitespace(chars[charIndex])) {
                continue;
            }

            if (0 > wordStartIndex) {
                    wordStartIndex = charIndex;
            }

            if (chars.length - 1 == charIndex || Character.isWhitespace(chars[charIndex + 1])) {
                for (int a = wordStartIndex, b = charIndex; a < b; a++, b--) {
                    final char aTempSwapChar = chars[a];
                    chars[a] = chars[b];
                    chars[b] = aTempSwapChar;
                }

                wordStartIndex = -1;
            }

        }

        return new String(chars);
    }

    /**
     * Returns a String with the words in the same order as the input String, but with each word's characters in reverse order
     * achieving this effect using a Stack implementation.
     *
     * For each character in the input String, if the character is not a whitespace, push to a Stack.
     * If the character is a whitespace, pop the Stack to a StringBuilder.
     *
     * Return the final String from the StringBuilder
     *
     * @param string input String
     * @return the input String, except each word is in reverse character order
     */
    @Override
    public String reverseWordsInStringUsingStack(final String string) {
        final Stack<Character> word = new Stack<>();
        final StringBuilder resultStringBuilder = new StringBuilder();
        for (final char c : string.toCharArray()) {
            if (Character.isWhitespace(c)) {
                while (!word.isEmpty()) {
                    resultStringBuilder.append(word.pop());
                }
                resultStringBuilder.append(c);
            } else {
                word.push(c);
            }
        }

        while (!word.isEmpty()) {
            resultStringBuilder.append(word.pop());
        }

        return resultStringBuilder.toString();
    }
}
