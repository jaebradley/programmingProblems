package main.java.problems.interfaces;

import java.math.BigInteger;

public interface FibonacciModified {
    BigInteger calculateNthTerm(final BigInteger firstTerm, final BigInteger secondTerm, final int n);
    BigInteger calculateNextTerm(final BigInteger currentTerm, final BigInteger lastTerm);
}
