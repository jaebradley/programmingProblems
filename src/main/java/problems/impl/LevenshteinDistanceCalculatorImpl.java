package problems.impl;

import problems.interfaces.LevenshteinDistanceCalculator;

public class LevenshteinDistanceCalculatorImpl implements LevenshteinDistanceCalculator {
  @Override
  public int calculateLevenshteinDistance(final String firstValue, final String secondValue) {
    final int[][] levenshteinDistanceValues = new int[firstValue.length()][secondValue.length()];
    for (int i = 0; i < firstValue.length(); i++) {
      levenshteinDistanceValues[i][0] = i;
    }
    for (int j = 0; j < secondValue.length(); j++) {
      levenshteinDistanceValues[0][j] = j;
    }
    for (int i = 1; i < firstValue.length(); i++) {
      for (int j = 1; j < secondValue.length(); j++) {
        levenshteinDistanceValues[i][j] = calculateIndexValue(levenshteinDistanceValues, i, j, firstValue.charAt(i), secondValue.charAt(j));
      }
    }
    return levenshteinDistanceValues[firstValue.length() - 1][secondValue.length() - 1];
  }

  @Override
  public int calculateIndexValue(final int[][] levenshteinMatrixValues, final int firstValueIndex, final int secondValueIndex,
                                 final char firstValueChar, final char secondValueChar) {
    if (firstValueIndex < 0) {
      throw new IllegalArgumentException("index value cannot be negative");
    }

    if (secondValueIndex < 0) {
      throw new IllegalArgumentException("index value cannot be negative");
    }

    if (firstValueIndex > levenshteinMatrixValues.length) {
      throw new IllegalArgumentException("index value cannot be greater than length");
    }

    if (secondValueIndex > levenshteinMatrixValues[firstValueIndex].length) {
      throw new IllegalArgumentException("index value cannot be greater than row length");
    }
    
    if (firstValueChar == secondValueChar) {
      return levenshteinMatrixValues[firstValueIndex][secondValueIndex];
    }

    return Math.min(
            Math.min(
              levenshteinMatrixValues[firstValueIndex - 1][secondValueIndex] + 1,
              levenshteinMatrixValues[firstValueIndex][secondValueIndex - 1] + 1),
            levenshteinMatrixValues[firstValueIndex - 1][secondValueIndex - 1] + 1
          );

  }
}
