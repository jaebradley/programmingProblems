package problems.impl;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

import problems.exceptions.NoRemainingTilesException;
import problems.interfaces.ScrabbleTileCounter;
import problems.models.ScrabbleTile;

public class ScrabbleTileCounterImplTest {

  private final ScrabbleTileCounter scrabbleTileCounter = new ScrabbleTileCounterImpl();

  @Test
  public void testTileCountCalculation() throws NoRemainingTilesException {
    Assert.assertEquals(ScrabbleTile.STARTING_SCRABBLE_TILE_COUNT, scrabbleTileCounter.calculateTileCount(new ArrayList<>()));

    final Map<ScrabbleTile, Integer> expectedScrabbleTileCount = new HashMap<>();
    expectedScrabbleTileCount.putAll(ScrabbleTile.STARTING_SCRABBLE_TILE_COUNT);
    expectedScrabbleTileCount.put(ScrabbleTile.BLANK, 0);
    expectedScrabbleTileCount.put(ScrabbleTile.A, 8);
    Assert.assertEquals(scrabbleTileCounter.calculateTileCount(new ArrayList<>(Arrays.asList(ScrabbleTile.A, ScrabbleTile.BLANK, ScrabbleTile.BLANK))), expectedScrabbleTileCount);
  }

  @Test
  public void testExpectedException() {
    final List<ScrabbleTile> tooManyBlanks = new ArrayList<>(Arrays.asList(ScrabbleTile.BLANK, ScrabbleTile.BLANK, ScrabbleTile.BLANK));
    try {
      scrabbleTileCounter.calculateTileCount(tooManyBlanks);
      Assert.fail();
    } catch (NoRemainingTilesException e) {
      // expected
    }
  }

  @Test
  public void testOutputTileCountCalculation() {
    final Map<ScrabbleTile, Integer> tileCount = new HashMap<>();
    tileCount.put(ScrabbleTile.A, 1);
    tileCount.put(ScrabbleTile.B, 2);
    tileCount.put(ScrabbleTile.C, 2);
    final Map<Integer, Set<ScrabbleTile>> expectedOutputTileCount = new HashMap<>();
    expectedOutputTileCount.put(1, new HashSet<>(Arrays.asList(ScrabbleTile.A)));
    expectedOutputTileCount.put(2, new HashSet<>(Arrays.asList(ScrabbleTile.B, ScrabbleTile.C)));
    Assert.assertEquals(scrabbleTileCounter.calculateOutputTileCount(tileCount), expectedOutputTileCount);
  }

}
