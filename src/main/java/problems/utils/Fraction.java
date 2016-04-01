package problems.utils;

public class Fraction {
  private final long numerator;
  private final long denominator;

  public Fraction(final long numerator, final long denominator) {
    if (0 == denominator) {
      throw new RuntimeException("denominator value cannot be 0");
    }

    this.numerator = numerator;
    this.denominator = denominator;
  }

  public long getNumerator() {
    return numerator;
  }

  public long getDenominator() {
    return denominator;
  }
}
