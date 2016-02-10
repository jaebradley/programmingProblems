package problems.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BracketEnclosingValidator {

  public static final char OPEN_SQUARE_BRACKET = '[';
  public static final char CLOSED_SQUARE_BRACKET = ']';

  public static final char OPEN_CURLY_BRACKET = '{';
  public static final char CLOSED_CURLY_BRACKET = '}';

  public static final char OPEN_PARENTHESIS = '(';
  public static final char CLOSED_PARENTHESIS = ')';

  public static boolean validBracketEnclosing(final String candidate) {
    final char[] chars = candidate.toCharArray();
    final Stack<Character> bracketStack = new Stack<>();
    final Map<Character, Character> bracketMap = new HashMap<>();
    bracketMap.put(OPEN_SQUARE_BRACKET, CLOSED_SQUARE_BRACKET);
    bracketMap.put(OPEN_CURLY_BRACKET, CLOSED_CURLY_BRACKET);
    bracketMap.put(OPEN_PARENTHESIS, CLOSED_PARENTHESIS);
    for (final char ch : chars) {
      switch (ch) {
        case OPEN_SQUARE_BRACKET:case OPEN_CURLY_BRACKET:case OPEN_PARENTHESIS: {
          bracketStack.add(ch);
          break;
        }

        case CLOSED_SQUARE_BRACKET:case CLOSED_CURLY_BRACKET:case CLOSED_PARENTHESIS: {
          final Character nextChar = bracketStack.pop();
          if (ch != bracketMap.get(nextChar)) {
            return false;
          }
          break;
        }

        default: {
          break;
        }
      }
    }

    return true;
  }
}
