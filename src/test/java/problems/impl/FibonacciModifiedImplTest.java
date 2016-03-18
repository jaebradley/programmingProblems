package problems.impl;

import org.junit.Assert;
import org.junit.Test;
import problems.interfaces.FibonacciModified;

import java.math.BigInteger;

public class FibonacciModifiedImplTest {

    private final FibonacciModified fibonacciModified = new FibonacciModifiedImpl();

    @Test
    public void testCalculateNextTerm() throws Exception {
        try {
            fibonacciModified.calculateNextTerm(BigInteger.ONE, BigInteger.valueOf(-1));
        } catch (IllegalArgumentException e) {
            // expected
        }

        try {
            fibonacciModified.calculateNextTerm(BigInteger.ZERO, BigInteger.ONE);
        } catch (IllegalArgumentException e) {
            // expected
        }

        Assert.assertEquals(fibonacciModified.calculateNextTerm(BigInteger.ONE, BigInteger.ZERO), BigInteger.ONE);
        Assert.assertEquals(fibonacciModified.calculateNextTerm(BigInteger.valueOf(2), BigInteger.ONE), BigInteger.valueOf(5));
    }

    @Test
    public void testCalculateNthTerm() throws Exception {
        try {
            fibonacciModified.calculateNthTerm(BigInteger.valueOf(-1), BigInteger.ONE, 10);
        } catch (IllegalArgumentException e) {
            // expected
        }

        try {
            fibonacciModified.calculateNthTerm(BigInteger.ONE, BigInteger.ZERO, 10);
        } catch (IllegalArgumentException e) {
            // expected
        }

        try {
            fibonacciModified.calculateNthTerm(BigInteger.ZERO, BigInteger.ONE, 0);
        } catch (IllegalArgumentException e) {
            // expected
        }

        Assert.assertEquals(fibonacciModified.calculateNthTerm(BigInteger.ONE, BigInteger.TEN, 1), BigInteger.ONE);
        Assert.assertEquals(fibonacciModified.calculateNthTerm(BigInteger.ONE, BigInteger.TEN, 2), BigInteger.TEN);

        try {
            fibonacciModified.calculateNthTerm(BigInteger.ZERO, BigInteger.ONE, -1);
        } catch (IllegalArgumentException e) {
            // expected
        }

        Assert.assertEquals(fibonacciModified.calculateNthTerm(BigInteger.ZERO, BigInteger.ONE, 5), BigInteger.valueOf(5));
    }
}
