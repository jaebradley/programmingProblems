package problems.impl;

import problems.interfaces.FactorialIdentifier;

/**
 * Solution for problem described here: https://www.reddit.com/r/dailyprogrammer/comments/55nior/20161003_challenge_286_easy_reverse_factorial/?utm_content=title&utm_medium=hot&utm_source=reddit&utm_name=dailyprogrammer
 */
public class FactorialIdentifierImpl implements FactorialIdentifier {

  @Override
  public boolean isFactorial(long value) {
    if (value < 1L) {
      return false;
    }

    long divisor = 1L;
    long remainder = 0;
    while (remainder == 0 && value > 1) {
      remainder = value % divisor;
      value /= divisor;
      divisor++;
    }

    return remainder == 0;
  }
}
