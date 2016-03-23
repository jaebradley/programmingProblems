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
    public void itShouldAddProperly() {
        Assert.assertEquals(largeValuesAdder.largeValuesAdder(largeValue1, largeValue1), "198");
        Assert.assertEquals(largeValuesAdder.largeValuesAdder(largeValue1, largeValue2), "1098");
        Assert.assertEquals(largeValuesAdder.largeValuesAdder(largeValue3, largeValue3), "2");
        Assert.assertEquals(largeValuesAdder.largeValuesAdder("", ""), "");
        Assert.assertEquals(largeValuesAdder.largeValuesAdder("109", "1"), "110");
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldThrowException() {
        largeValuesAdder.numericalValueForIndex(2, largeValue1);
        largeValuesAdder.numericalValueForIndex(0, "A");
        largeValuesAdder.numericalValueForIndex(0, "a");
        largeValuesAdder.numericalValueForIndex(0, "/");
        largeValuesAdder.largeValuesAdder("A", "1");
        largeValuesAdder.largeValuesAdder("1", "B");
    }

    @Test
    public void itShouldTranslateDigitForIndexValue() {
        Assert.assertEquals(largeValuesAdder.numericalValueForIndex(0, largeValue1), 9);
    }
}
