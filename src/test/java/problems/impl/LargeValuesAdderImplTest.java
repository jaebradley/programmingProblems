package problems.impl;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.LargeValuesAdder;

public class LargeValuesAdderImplTest {

    private final LargeValuesAdder largeValuesAdder = new LargeValuesAdderImpl();
    private final String largeValue1 = "99";
    private final String largeValue2 = "999";
    private final String largeValue3 = "1";

    @Test
    public void testExpected() {
        Assert.assertEquals(largeValuesAdder.largeValuesAdder(largeValue1, largeValue1), "198");
        Assert.assertEquals(largeValuesAdder.largeValuesAdder(largeValue1, largeValue2), "1098");
        Assert.assertEquals(largeValuesAdder.largeValuesAdder(largeValue3, largeValue3), "2");
        Assert.assertEquals(largeValuesAdder.largeValuesAdder("", ""), "");
        Assert.assertEquals(largeValuesAdder.largeValuesAdder("109", "1"), "110");
    }
}
