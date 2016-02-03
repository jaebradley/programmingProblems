package problems.impl;


import problems.interfaces.BracketPairingValidation;

import java.util.Stack;

public class BracketPairingValidationImpl implements BracketPairingValidation {
    @Override
    public boolean validateBracketPairs(final String string) {
        final Stack<Character> bracketStack = new Stack<>();
        for (final char character : string.toCharArray()) {
            if ('{' == character || '[' == character || '(' == character) {
                bracketStack.push(character);
            }

            else if (!bracketStack.empty() &&
                    (('{' == bracketStack.peek() && '}' == character)
                        || ('[' == bracketStack.peek() && ']' == character)
                        || ('(' == bracketStack.peek() && ')' == character)))  {
                bracketStack.pop();
            }

            else if ('}' == character || ']' == character || ')' == character) {
                return false;
            }
        }

        return bracketStack.empty();
    }
}
