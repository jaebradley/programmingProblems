package problems.impl;

import problems.interfaces.ShannonEntropyCalculator;

import java.util.*;

public class ShannonEntropyCalculatorImpl implements ShannonEntropyCalculator {

  private static final double LOG2 = 0.69314718056;

  @Override
  public double calculateShannonEntropy(final String value) {
    double entropy = 0;
    final List<Character> chars = new ArrayList<>();
    for (char c : value.toCharArray()) {
      chars.add(c);
    }
    final Set<Character> uniqueChars = new HashSet<>(chars);
    for (Character c : uniqueChars) {
      final int characterFrequency = Collections.frequency(chars, c);
      entropy += calculateEventInformation(characterFrequency, chars.size());
    }
    return -entropy;
  }

  @Override
  public double calculateEventInformation(final long frequency, final long sequenceLength) {
    final double ratio = (double) frequency / sequenceLength;
    return ratio * Math.log(ratio) / LOG2;
  }
}
