package problems.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import problems.interfaces.DigitsIdentifier;

public class DigitsIdentifierImpl implements DigitsIdentifier {
  @Override
  public List<Integer> identifyDigits(final long number) {
    final List<Integer> digits = new ArrayList<>();
    final Stack<Integer> digitsStack = new Stack<>();

    if (number == 0) {
      digits.add(0);
      return digits;
    }

    long absNumber = Math.abs(number);
    while (absNumber > 0) {
      digitsStack.add(Math.toIntExact(absNumber % 10));
      absNumber = absNumber / 10;
    }

    while (!digitsStack.isEmpty()) {
      digits.add(digitsStack.pop());
    }

    return digits;
  }
}
