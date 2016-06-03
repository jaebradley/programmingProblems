package problems.impl;

import problems.interfaces.FisherYatesShuffler;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Fisher-Yates Shuffle
 *
 * Write down the numbers from 1 through N.
 * Pick a random number k between one and the number of unstruck numbers remaining (inclusive).
 * Counting from the low end, strike out the kth number not yet struck out, and write it down at the end of a separate list.
 * Repeat from step 2 until all the numbers have been struck out.
 * The sequence of numbers written down in step 3 is now a random permutation of the original numbers.
 *
 * https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
 */

public class FisherYatesShufflerImpl implements FisherYatesShuffler {
  @Override
  public <T> List<T> shuffle(final List<T> values) {
    final List<T> valuesToShuffle = new ArrayList<>(values);
    final List<T> shuffledValues = new Stack<>();
    while(valuesToShuffle.size() > 0) {
      int randomIndex = (int) (Math.random() * (valuesToShuffle.size() - 1));
      T value = valuesToShuffle.get(randomIndex);
      shuffledValues.add(value);
      valuesToShuffle.remove(randomIndex);
    }
    return shuffledValues;
  }
}
