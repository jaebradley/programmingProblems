package problems.impl;

import org.junit.Assert;
import org.junit.Test;
import problems.interfaces.CoconutCalculator;

public class CoconutCalculatorImplTest {
    private final CoconutCalculator coconutCalculator = new CoconutCalculatorImpl();

    @Test
    public void testExpected() {
        Assert.assertEquals(coconutCalculator.calculateCoconuts(2), 11, 0);
        Assert.assertEquals(coconutCalculator.calculateCoconuts(5), 3121, 0);
    }

}