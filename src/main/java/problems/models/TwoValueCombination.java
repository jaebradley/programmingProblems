package problems.models;

public class TwoValueCombination {
  private final long firstValue;
  private final long secondValue;

  public TwoValueCombination(final long firstValue, final long secondValue) {
    this.firstValue = firstValue;
    this.secondValue = secondValue;
  }

  public long getFirstValue() {
    return firstValue;
  }

  public long getSecondValue() {
    return secondValue;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    TwoValueCombination that = (TwoValueCombination) o;

    if (firstValue != that.firstValue) return false;
    return secondValue == that.secondValue;

  }

  @Override
  public int hashCode() {
    int result = (int) (firstValue ^ (firstValue >>> 32));
    result = 31 * result + (int) (secondValue ^ (secondValue >>> 32));
    return result;
  }
}
