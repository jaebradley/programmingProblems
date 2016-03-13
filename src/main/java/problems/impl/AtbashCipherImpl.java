package problems.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import problems.interfaces.AtbashCipher;

/**
 * The Atbash cipher is a simple substitution cipher that replaces the first character of the alphabet with the last,
 * the second character with the second-to-last, the third character with the third-to-last, and so on.
 */

public class AtbashCipherImpl implements AtbashCipher {
  public static final List<Character> ALPHABET = new ArrayList<>(
      Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
  );

  @Override public char atbashCounterpart(final char c) {
    if (Character.isAlphabetic(c)) {
      return ALPHABET.get((ALPHABET.size() - 1) - ALPHABET.indexOf(c));
    }

    throw new RuntimeException("Cannot identify Atbash pair");
  }


  @Override public char applyCipher(final char c) {
    if (Character.isAlphabetic(c)) {
      final Character upperCaseChar = Character.toUpperCase(c);

      if (Character.isLowerCase(c)) {
        return Character.toLowerCase(atbashCounterpart(upperCaseChar));
      }

      else {
        return Character.toUpperCase(atbashCounterpart(upperCaseChar));
      }
    }

    return c;
  }
}
