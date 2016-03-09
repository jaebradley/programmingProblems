package problems.impl;

import org.junit.Assert;
import org.junit.Test;
import problems.interfaces.GarlandDegreeCalculator;

public class GarlandDegreeCalculatorImplTest {
    private final GarlandDegreeCalculator garlandDegreeCalculator = new GarlandDegreeCalculatorImpl();

    @Test
    public void testExpected() {
        Assert.assertEquals(garlandDegreeCalculator.calculateGarlandDegree("undergrounder"), 5);
    }

}