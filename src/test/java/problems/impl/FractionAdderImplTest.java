package problems.impl;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.DivisorsCalculator;
import problems.utils.Fraction;

public class FractionAdderImplTest {
  private final DivisorsCalculator divisorsCalculator = new DivisorsCalculatorImpl();
  private final FractionAdderImpl fractionAdder = new FractionAdderImpl(divisorsCalculator);

  @Test
  public void testExpected() {
    final Fraction firstFraction = new Fraction(-1, 2);
    final Fraction secondFraction = new Fraction(7, 15);
    final Fraction result = fractionAdder.sumFractions(firstFraction, secondFraction);
    Assert.assertEquals(result.getNumerator(), -1);
    Assert.assertEquals(result.getDenominator(), 30);
    final Fraction thirdFraction = new Fraction(2, 8);
    final Fraction anotherResult = fractionAdder.sumFractions(firstFraction, thirdFraction);
    Assert.assertEquals(anotherResult.getNumerator(), -1);
    Assert.assertEquals(anotherResult.getDenominator(), 4);
  }

}
