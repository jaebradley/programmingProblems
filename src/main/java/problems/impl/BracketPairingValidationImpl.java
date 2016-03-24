package problems.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import problems.interfaces.BracketPairingValidation;

/**
 * Implements a bracket pair validation interface that checks if a string has valid open/closed bracket combinations
 */

public class BracketPairingValidationImpl implements BracketPairingValidation {

    private static final Set<Character> openBrackets = new HashSet<>(Arrays.asList('{', '[', '('));
    private static final Set<Character> closedBrackets = new HashSet<>(Arrays.asList('}', ']', ')'));

  /**
   * Iterate over each character in the candidate string.
   *
   * If the character is an open bracket, push it to the bracket stack.
   *
   * If the character is a closed bracket, check to see if the bracket stack is not empty and if the first element in
   * the bracket stack is the open bracket corresponding to the closed bracket. If so, pop the bracket stack, else,
   * return false.
   *
   * After iterating over all the characters, if there are any elements left in the bracket stack, then not all bracket
   * pairs are valid.
   *
   * @param candidate string that may or may not contain bracket characters
   * @return boolean that represents if the candidate string has valid bracket pairs
   */
  @Override
    public boolean validateBracketPairs(final String candidate) {
        final Stack<Character> bracketStack = new Stack<>();
        for (final char c : candidate.toCharArray()) {
            if (openBrackets.contains(c)) {
                bracketStack.push(c);
            }

            else if (closedBrackets.contains(c)) {
                if (!bracketStack.empty() &&
                    (('{' == bracketStack.peek() && '}' == c)
                        || ('[' == bracketStack.peek() && ']' == c)
                        || ('(' == bracketStack.peek() && ')' == c)))  {
                    bracketStack.pop();
                } else {
                    return false;
                }
            }
        }

        return bracketStack.empty();
    }
}
