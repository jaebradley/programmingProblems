package problems.impl;

import problems.interfaces.ShannonEntropyCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class ShannonEntropyCalculatorImpl implements ShannonEntropyCalculator {

  @Override
  public BigDecimal calculateShannonEntropy(final String value) {
    BigDecimal entropy = BigDecimal.ZERO;
    final List<Character> chars = new ArrayList<>();
    for (char c : value.toCharArray()) {
      chars.add(c);
    }
    final Set<Character> uniqueChars = new HashSet<>(chars);
    for (Character c : uniqueChars) {
      final int characterFrequency = Collections.frequency(chars, c);
      entropy = entropy.add(calculateEventInformation(characterFrequency, chars.size()));
    }
    return entropy.negate();
  }

  @Override
  public BigDecimal calculateEventInformation(final long frequency, final long sequenceLength) {
    final BigDecimal ratio = BigDecimal.valueOf(frequency).divide(BigDecimal.valueOf(sequenceLength), 25, RoundingMode.HALF_EVEN);
    final BigDecimal log2 = BigDecimal.valueOf(Math.log(ratio.doubleValue()) / Math.log(2));
    return ratio.multiply(log2);
  }
}
