package problems.impl;

import org.junit.Assert;
import org.junit.Test;

import problems.utils.Fraction;

public class FractionAdderImplTest {
  final FractionAdderImpl fractionAdder = new FractionAdderImpl();

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
    final Fraction fourthFraction = new Fraction(1, 3);
    final Fraction noCommonDivisor = fractionAdder.sumFractions(fourthFraction, fourthFraction);
    Assert.assertEquals(noCommonDivisor.getNumerator(), 2);
    Assert.assertEquals(noCommonDivisor.getDenominator(), 3);
  }

}
