package problems.interfaces;

import java.math.BigDecimal;

public interface ShannonEntropyCalculator {
  BigDecimal calculateShannonEntropy(final String value);

  BigDecimal calculateEventInformation(final long frequency, final long sequenceLength);
}
