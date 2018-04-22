package problems.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class HungryRabbitTest {

    @Test
    public void shouldReturn27() {
        assertEquals(27, HungryRabbit.getConsumedCarrotCount(new int[][]{
                new int[]{5, 7, 8, 6, 3},
                new int[]{0, 0, 7, 0, 4},
                new int[]{4, 6, 3, 4, 9},
                new int[]{3, 1, 0, 5, 8},
        }));
    }

    @Test
    public void shouldReturn0ForSingleElementGardenWithZeroCarrots() {
        assertEquals(0, HungryRabbit.getConsumedCarrotCount(new int[][]{
                new int[]{0},
        }));
    }

    @Test
    public void shouldReturn1ForTwoElementGardenWith1Carrot() {
        assertEquals(1, HungryRabbit.getConsumedCarrotCount(new int[][]{
                new int[]{0, 1},
        }));
    }
}