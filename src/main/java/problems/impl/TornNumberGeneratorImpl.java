package problems.impl;

import java.util.ArrayList;
import java.util.List;

import problems.interfaces.SplitIntegerGenerator;
import problems.interfaces.TornNumberGenerator;
import problems.interfaces.TornNumberValidator;
import problems.utils.SplitInteger;

/**
 *https://www.reddit.com/r/dailyprogrammer/comments/230m05/4142014_challenge_158_easy_the_torn_number/
 *
 * I had the other day in my possession a label bearing the number 3 0 2 5 in large figures.
 * This got accidentally torn in half, so that 3 0 was on one piece and 2 5 on the other.
 * On looking at these pieces I began to make a calculation, when I discovered this little peculiarity.
 * If we add the 3 0 and the 2 5 together and square the sum we get as the result, the complete original number on the label!
 * Thus, 30 added to 25 is 55, and 55 multiplied by 55 is 3025. Curious, is it not?
 *
 * Now, the challenge is to find another number, composed of four figures, all different,
 * which may be divided in the middle and produce the same result.
 */

public class TornNumberGeneratorImpl implements TornNumberGenerator {
  private final TornNumberValidator tornNumberValidator;
  private final SplitIntegerGenerator splitIntegerGenerator;

  public TornNumberGeneratorImpl(final TornNumberValidator tornNumberValidator,
                                 final SplitIntegerGenerator splitIntegerGenerator) {
    this.tornNumberValidator = tornNumberValidator;
    this.splitIntegerGenerator = splitIntegerGenerator;
  }

  @Override public List<Integer> generateTornNumbers(final int upperLimitInclusive) {
    if (upperLimitInclusive < 1) {
      throw new IllegalArgumentException("positive upper limit");
    }

    final List<Integer> tornNumbers = new ArrayList<>();
    int squareRoot = 1;
    int tornNumberCandidate = Math.multiplyExact(squareRoot, squareRoot);
    while (tornNumberCandidate <= upperLimitInclusive) {
      final SplitInteger splitInteger = splitIntegerGenerator.generateSplitInteger(tornNumberCandidate);
      if (tornNumberValidator.isTornNumber(splitInteger)) {
        tornNumbers.add(tornNumberCandidate);
      }

      squareRoot++;
      tornNumberCandidate = Math.multiplyExact(squareRoot, squareRoot);
    }
    return tornNumbers;
  }
}
