package problems.impl;

import java.util.List;

import problems.interfaces.StringCharactersInAlphabeticalOrderEvaluator;
import problems.utils.AlphabeticalOrderState;

public class StringCharactersInAlphabeticalOrderEvaluatorImpl implements StringCharactersInAlphabeticalOrderEvaluator {
  private final List<Character> charactersFromAtoZ;

  public StringCharactersInAlphabeticalOrderEvaluatorImpl(final List<Character> charactersFromAtoZ) {
    this.charactersFromAtoZ = charactersFromAtoZ;
  }

  @Override public AlphabeticalOrderState evaluateAlphabeticalOrderOfCharacters(final String candidate) {
    final char[] stringChars = candidate.toUpperCase().toCharArray();
    int index = 0;
    boolean fromAtoZ = true;
    boolean fromZtoA = true;
    while (index < stringChars.length - 1) {
      if (charactersFromAtoZ.indexOf(stringChars[index]) > charactersFromAtoZ.indexOf(stringChars[index + 1])) {
        fromAtoZ = false;
      }

      if (charactersFromAtoZ.indexOf(stringChars[index]) < charactersFromAtoZ.indexOf(stringChars[index + 1])) {
        fromZtoA = false;
      }

      index++;
    }

    if (!fromAtoZ && !fromZtoA) {
      return AlphabeticalOrderState.IN_NEITHER_ALPHABETICAL_NOR_REVERSE_ALPHABETICAL_ORDER;
    }

    if (fromAtoZ && fromZtoA) {
      return AlphabeticalOrderState.IN_BOTH_ALPHABETICAL_AND_REVERSE_ALPHABETICAL_ORDER;
    }

    if (fromAtoZ) {
      return AlphabeticalOrderState.IN_ALPHABETICAL_ORDER;
    }

    else {
      return AlphabeticalOrderState.IN_REVERSE_ALPHABETICAL_ORDER;
    }
  }
}
