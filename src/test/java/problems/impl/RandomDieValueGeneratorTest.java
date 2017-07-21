package problems.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomDieValueGeneratorTest {
  @Test
  public void itShouldReturnValueBetween1And6Inclusive() {
    // ugh not my favorite test in the world, but I'm not sure how else to test this
    for (int index = 0; index < 10000; index++) {
      int value = RandomDieValueGenerator.generateValue();
      assertTrue(value > 0);
      assertTrue(value < 7);
    }
  }
}