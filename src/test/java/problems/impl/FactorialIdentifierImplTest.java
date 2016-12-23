package problems.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactorialIdentifierImplTest {

  FactorialIdentifierImpl factorialIdentifier = new FactorialIdentifierImpl();

  @Test
  public void testIsFactorial() {
    assertTrue(factorialIdentifier.isFactorial(1));
    assertTrue(factorialIdentifier.isFactorial(2));
    assertFalse(factorialIdentifier.isFactorial(3));
    assertTrue(factorialIdentifier.isFactorial(120));
    assertFalse(factorialIdentifier.isFactorial(0));
  }
}