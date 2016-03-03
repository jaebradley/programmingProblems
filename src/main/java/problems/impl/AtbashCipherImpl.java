package problems.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import problems.interfaces.AtbashCipher;

public class AtbashCipherImpl implements AtbashCipher {
  public static final List<Character> ALPHABET = new ArrayList<>(
      Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
  );

  @Override public char atbashPair(final char c) {
    if (Character.isAlphabetic(c)) {
      return ALPHABET.get((ALPHABET.size() - 1) - ALPHABET.indexOf(c));
    }

    throw new RuntimeException("Cannot identify Atbash pair");
  }


  @Override public char applyCipher(final char c) {
    if (Character.isAlphabetic(c)) {
      final Character upperCaseChar = Character.toUpperCase(c);

      if (Character.isLowerCase(c)) {
        return Character.toLowerCase(atbashPair(upperCaseChar));
      }

      if (Character.isUpperCase(c)) {
        return Character.toUpperCase(atbashPair(upperCaseChar));
      }

      throw new RuntimeException("Cannot identify case of alphabetic character");
    }

    return c;
  }
}
