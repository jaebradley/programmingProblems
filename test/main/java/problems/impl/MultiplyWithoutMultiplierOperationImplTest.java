package main.java.problems.impl;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplyWithoutMultiplierOperationImplTest {
    private final MultiplyWithoutMultiplierOperationImpl multiplyWithoutMultiplierOperation = new MultiplyWithoutMultiplierOperationImpl();

    @Test
    public void testExpected() {
        Assert.assertEquals(0, multiplyWithoutMultiplierOperation.multiply(0, 0));
        Assert.assertEquals(22, multiplyWithoutMultiplierOperation.multiply(11, 2));
        Assert.assertEquals(22, multiplyWithoutMultiplierOperation.multiply(-11, -2));
        Assert.assertEquals(-22, multiplyWithoutMultiplierOperation.multiply(-11, 2));
        Assert.assertEquals(-22, multiplyWithoutMultiplierOperation.multiply(11, -2));
    }
}