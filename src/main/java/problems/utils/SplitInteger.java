package problems.utils;

import java.util.List;

public class SplitInteger {
  private final List<Integer> leftDigits;
  private final List<Integer> rightDigits;

  public SplitInteger(final List<Integer> leftDigits, final List<Integer> rightDigits) {
    this.leftDigits = leftDigits;
    this.rightDigits = rightDigits;
  }

  public List<Integer> getLeftDigits() {
    return leftDigits;
  }

  public List<Integer> getRightDigits() {
    return rightDigits;
  }

}
