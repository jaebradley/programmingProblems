package problems.impl;

import java.util.Stack;

import problems.interfaces.ReverseWordOrderInString;

public class ReverseWordOrderInStringImpl implements ReverseWordOrderInString {

    @Override
    public String reverseWordOrder(final String string) {
        final Stack<String> wordStack = new Stack<>();
        final StringBuilder wordStringBuilder = new StringBuilder();
        for (int charIndex = 0; charIndex < string.length() - 1; charIndex++) {
            wordStringBuilder.append(string.charAt(charIndex));
            if (!Character.isAlphabetic(string.charAt(charIndex)) && Character.isAlphabetic(string.charAt(charIndex + 1))) {
                wordStack.push(wordStringBuilder.toString());
                wordStringBuilder.setLength(0);
            }
        }
        wordStack.push(wordStringBuilder.append(string.charAt(string.length() - 1)).append(" ").toString());

        final StringBuilder reverseWordOrderStringBuilder = new StringBuilder();
        while (!wordStack.empty()) {
            reverseWordOrderStringBuilder.append(wordStack.pop());
        }

        return reverseWordOrderStringBuilder.toString().substring(0, string.length());
    }
}
