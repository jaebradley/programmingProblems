package problems.impl;

import problems.interfaces.FibonacciModified;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Problem from https://www.hackerrank.com/challenges/fibonacci-modified
 * A series is defined in the following manner:

 Given the nth and (n+1)th terms, the (n+2)th can be computed by the following relation
 Tn+2 = (Tn+1)2 + Tn

 Given three integers A, B and N, such that the first two terms of the series (1st and 2nd terms)
 are A and B respectively, compute the Nth term of the series.

 Input Constraints
 0 <= A,B <= 2
 3 <= N <= 20
 */

public class FibonacciModifiedImpl implements FibonacciModified {

    @Override
    public BigInteger calculateNextTerm(final BigInteger currentTerm, final BigInteger lastTerm) {
        if (-1 == lastTerm.compareTo(BigInteger.ZERO) ) {
            throw new IllegalArgumentException("last term must be non-negative");
        }

        if (-1 == currentTerm.compareTo(lastTerm)) {
            throw new IllegalArgumentException("current term must be greater than or equal to last term");
        }

        final BigInteger squaredTerm = new BigDecimal(Math.pow(currentTerm.doubleValue(), 2)).toBigInteger();
        return squaredTerm.add(lastTerm);
    }

    @Override
    public BigInteger calculateNthTerm(final BigInteger firstTerm, final BigInteger secondTerm, final int n) {
        if (-1 == firstTerm.compareTo(BigInteger.ZERO) ) {
            throw new IllegalArgumentException("first term must be non-negative");
        }

        if (-1 == secondTerm.compareTo(firstTerm)) {
            throw new IllegalArgumentException("second term must be greater than or equal to last term");
        }

        if (n < 1) {
            throw new IllegalArgumentException("number of terms must be greater than 0");
        }

        switch (n) {
            case 1: {
                return firstTerm;
            }

            case 2: {
                return secondTerm;
            }

            default: {
                int counter = 2;
                BigInteger currentTerm = secondTerm;
                BigInteger lastTerm = firstTerm;
                while (counter < n) {
                    BigInteger nextTerm = calculateNextTerm(currentTerm, lastTerm);
                    lastTerm = currentTerm;
                    currentTerm = nextTerm;
                    counter++;
                }

                return currentTerm;
            }
        }
    }
}
