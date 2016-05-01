package problems.interfaces;

public interface LevenshteinDistanceCalculator {
  int calculateLevenshteinDistance(final String firstValue, final String secondValue);

  int calculateLevenshteinDistanceForEmptyStrings(final String firstValue, final String secondValue);

  int calculateIndexValue(final int[][] levenshteinMatrixValues, final int firstValueIndex, final int secondValueIndex,
                          final char firstValueChar, final char secondValueChar);
}
