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

    @Test
    public void itShouldThrowException() {
        try {
            largeValuesAdder.numericalValueForIndex(2, largeValue1);
            Assert.fail();
        } catch (IllegalArgumentException e) {
            // expected
        }

        try {
            largeValuesAdder.numericalValueForIndex(0, "A");
            Assert.fail();
        } catch (IllegalArgumentException e) {
            // expected
        }

        try {
            largeValuesAdder.numericalValueForIndex(0, "a");
            Assert.fail();
        } catch (IllegalArgumentException e) {
            // expected
        }

        try {
            largeValuesAdder.numericalValueForIndex(0, "/");
            Assert.fail();
        } catch (IllegalArgumentException e) {
            // expected
        }

    }

    @Test
    public void itShouldTranslateDigitForIndexValue() {
        Assert.assertEquals(largeValuesAdder.numericalValueForIndex(0, largeValue1), 9);
    }
}
