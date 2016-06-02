package problems.interfaces;

public interface ShannonEntropyCalculator {
  double calculateShannonEntropy(final String value);

  double calculateEventInformation(final long frequency, final long sequenceLength);
}
