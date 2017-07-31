package problems.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumTripletProductCalculatorTest {

    @Test
    public void itShouldGetMaximumProduct() {
        int[] values = new int[] { 10, 3, 5, 6, 20 };
        assertEquals(1200, MaximumTripletProductCalculator.calculateMaximumTripletProduct(values));
    }

    @Test
    public void itShouldGetMaximumProductForNegativeNumbers() {
        int[] values = new int[] { -10, -3, -5, -6, -20 };
        assertEquals(-90, MaximumTripletProductCalculator.calculateMaximumTripletProduct(values));
    }

    @Test
    public void itShouldGetMaximumProductUsingTwoNegativeNumbers() {
        int[] values = new int[] { 1, -4, 3, -6, 7, 0 };
        assertEquals(168, MaximumTripletProductCalculator.calculateMaximumTripletProduct(values));
    }
}