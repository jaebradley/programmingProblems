package problems.impl;

import problems.interfaces.BinomialCoefficientCalculator;
import problems.interfaces.PascalsTriangleRowValuesCalculator;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleRowValuesCalculatorImpl implements PascalsTriangleRowValuesCalculator {
  private final BinomialCoefficientCalculator binomialCoefficientCalculator;

  public PascalsTriangleRowValuesCalculatorImpl(final BinomialCoefficientCalculator binomialCoefficientCalculator) {
    this.binomialCoefficientCalculator = binomialCoefficientCalculator;
  }

  /**
   * Calculate the row values for Pascal's Triangle for a given row index value
   * @param rowIndex a non-negative value that represents the row index to calculate values from
   * @return a List of row values
   */

  @Override
  public List<Integer> calculateRowValues(final int rowIndex) {
    if (rowIndex < 0) {
      throw new IllegalArgumentException("row index must be non-negative");
    }

    final List<Integer> rowValues = new ArrayList<>();
    for (int k = 0; k <= rowIndex; k++ ) {
      rowValues.add(binomialCoefficientCalculator.calculateBinomialCoefficient(rowIndex, k));
    }
    return rowValues;
  }
}
