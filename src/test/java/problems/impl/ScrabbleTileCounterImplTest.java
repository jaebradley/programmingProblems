package problems.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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

  }

}
