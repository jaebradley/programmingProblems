package problems.impl;

import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;

import problems.exceptions.NoRemainingTilesException;
import problems.interfaces.ScrabbleTileCounter;
import problems.models.ScrabbleTile;

public class ScrabbleTileCounterImplTest {

  private final ScrabbleTileCounter scrabbleTileCounter = new ScrabbleTileCounterImpl();

  @Test
  public void testTileCountCalculation() throws NoRemainingTilesException {
    Assert.assertEquals(ScrabbleTile.STARTING_SCRABBLE_TILE_COUNT, scrabbleTileCounter.calculateTileCount(Collections.EMPTY_LIST));
  }

  @Test
  public void testExpectedException() {

  }

  @Test
  public void testOutputTileCountCalculation() {

  }

}
