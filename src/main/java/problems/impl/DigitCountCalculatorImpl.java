package problems.impl;

import problems.interfaces.DigitCountCalculator;

public class DigitCountCalculatorImpl implements DigitCountCalculator {

  /**
   * For a given integer, calculate the number of digits in that integer.
   *
   * @param number integer
   * @return number of digits in integer
   */
  @Override
  public int calculateDigitCount(final int number) {
    switch (number) {
      case 0: {
        return 1;
      }

      default: {
        return Double.valueOf(Math.log10(Math.abs(number))).intValue() + 1;
      }
    }
  }
}
