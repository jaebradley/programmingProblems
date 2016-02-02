package main.java.problems.impl;

import main.java.problems.interfaces.FibonacciModified;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Problem from https://www.hackerrank.com/challenges/fibonacci-modified
 * A series is defined in the following manner:

 Given the nth and (n+1)th terms, the (n+2)th can be computed by the following relation
 Tn+2 = (Tn+1)2 + Tn

 Given three integers A, B and N, such that the first two terms of the series (1st and 2nd terms)
 are A and B respectively, compute the Nth term of the series.
 */

public class FibonacciModifiedImpl implements FibonacciModified {

    @Override
    public BigInteger calculateNextTerm(final BigInteger currentTerm, final BigInteger lastTerm) {
        final BigInteger squaredTerm = new BigDecimal(Math.pow(currentTerm.doubleValue(), 2)).toBigInteger();
        return squaredTerm.add(lastTerm);
    }

    @Override
    public BigInteger calculateNthTerm(final BigInteger firstTerm, final BigInteger secondTerm, final int n) {
        int counter = 0;
        BigInteger currentTerm = secondTerm;
        BigInteger lastTerm = firstTerm;
        while (counter < n) {
            BigInteger nextTerm = calculateNextTerm(currentTerm, lastTerm);
            lastTerm = currentTerm;
            currentTerm = nextTerm;
        }

        return currentTerm;
    }
}
