package problems.impl;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class CoinChangeCalculatorTest {

    @Test
    public void itShouldReturnMinimumFor7() {
        Set<Integer> coinValues = new HashSet<>();
        coinValues.add(1);
        coinValues.add(5);
        coinValues.add(10);
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 2);
        expected.put(5, 1);
        CoinChangeCalculator calculator = new CoinChangeCalculator(coinValues);
        assertEquals(expected, calculator.calculateMinimumCoinValuesNecessaryToMakeChange(7));
    }
}