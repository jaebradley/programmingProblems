package problems.impl;

import org.junit.Test;
import problems.interfaces.FisherYatesShuffler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FisherYatesShufflerImplTest {

  private final FisherYatesShuffler shuffler = new FisherYatesShufflerImpl();

  @Test
  public void testShuffle() {
    final List<Integer> firstFiveNaturalNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    final List<Integer> shuffledFirstFiveNaturalNumbers = shuffler.shuffle(firstFiveNaturalNumbers);
    assertEquals(firstFiveNaturalNumbers.size(), shuffledFirstFiveNaturalNumbers.size());
    assertTrue(shuffledFirstFiveNaturalNumbers.containsAll(firstFiveNaturalNumbers));
  }
}