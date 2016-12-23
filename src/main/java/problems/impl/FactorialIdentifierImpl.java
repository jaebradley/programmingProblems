package problems.impl;

import problems.interfaces.FactorialIdentifier;

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
