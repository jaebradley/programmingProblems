package problems.impl;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.DivisorsCalculator;
import problems.interfaces.FractionAdder;
import problems.utils.Fraction;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class FractionAdderImplTest {
  private final DivisorsCalculator divisorsCalculator = new DivisorsCalculatorImpl();
  private final FractionAdder fractionAdder1 = new FractionAdderImpl(divisorsCalculator);
  private final DivisorsCalculator divisorsCalculatorReturningZero = new DivisorsCalculator() {
    @Override
    public Set<Long> calculateDivisors(final long positiveInteger) {
      return null;
    }

    @Override
    public long calculateGreatestCommonDivisor(final List<Long> numbers) {
      return 0;
    }

    @Override
    public Map<Long, Integer> calculateDivisorCount(final List<Long> numbers) {
      return null;
    }

    @Override
    public Set<Long> calculateCommonDivisors(final List<Long> numbers) {
      return null;
    }
  };
  private final FractionAdder fractionAdder2 = new FractionAdderImpl(divisorsCalculatorReturningZero);
  private final Fraction firstFraction = new Fraction(-1, 2);
  private final Fraction secondFraction = new Fraction(7, 15);

  @Test
  public void testExpected() {
    final Fraction result = fractionAdder1.sumFractions(firstFraction, secondFraction);
    Assert.assertEquals(result.getNumerator(), -1);
    Assert.assertEquals(result.getDenominator(), 30);
    final Fraction thirdFraction = new Fraction(2, 8);
    final Fraction anotherResult = fractionAdder1.sumFractions(firstFraction, thirdFraction);
    Assert.assertEquals(anotherResult.getNumerator(), -1);
    Assert.assertEquals(anotherResult.getDenominator(), 4);
  }

  @Test
  public void itShouldReturnException() {
    try {
      fractionAdder2.sumFractions(firstFraction, secondFraction);
      Assert.fail();
    } catch (RuntimeException e) {
      // expected
    }
  }

}
