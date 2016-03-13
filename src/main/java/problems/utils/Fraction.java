package problems.utils;

public class Fraction {
  private final int numerator;
  private final int denominator;

  public Fraction(final int numerator, final int denominator) {
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public int getNumerator() {
    return numerator;
  }

  public int getDenominator() {
    return denominator;
  }
}
