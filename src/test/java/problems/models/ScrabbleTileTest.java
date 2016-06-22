package problems.models;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class ScrabbleTileTest {

  @Test
  public void testStartingScrabbleTileCount() {
    final Map<ScrabbleTile, Integer> expectedTileCounts = new HashMap<>();
    expectedTileCounts.put(ScrabbleTile.A, 9);
    expectedTileCounts.put(ScrabbleTile.B, 2);
    expectedTileCounts.put(ScrabbleTile.C, 2);
    expectedTileCounts.put(ScrabbleTile.D, 4);
    expectedTileCounts.put(ScrabbleTile.E, 12);
    expectedTileCounts.put(ScrabbleTile.F, 2);
    expectedTileCounts.put(ScrabbleTile.G, 3);
    expectedTileCounts.put(ScrabbleTile.H, 2);
    expectedTileCounts.put(ScrabbleTile.I, 9);
    expectedTileCounts.put(ScrabbleTile.J, 1);
    expectedTileCounts.put(ScrabbleTile.K, 1);
    expectedTileCounts.put(ScrabbleTile.L, 4);
    expectedTileCounts.put(ScrabbleTile.M, 2);
    expectedTileCounts.put(ScrabbleTile.N, 6);
    expectedTileCounts.put(ScrabbleTile.O, 8);
    expectedTileCounts.put(ScrabbleTile.P, 2);
    expectedTileCounts.put(ScrabbleTile.Q, 1);
    expectedTileCounts.put(ScrabbleTile.R, 6);
    expectedTileCounts.put(ScrabbleTile.S, 4);
    expectedTileCounts.put(ScrabbleTile.T, 6);
    expectedTileCounts.put(ScrabbleTile.U, 4);
    expectedTileCounts.put(ScrabbleTile.V, 2);
    expectedTileCounts.put(ScrabbleTile.W, 2);
    expectedTileCounts.put(ScrabbleTile.X, 1);
    expectedTileCounts.put(ScrabbleTile.Y, 2);
    expectedTileCounts.put(ScrabbleTile.Z, 1);
    expectedTileCounts.put(ScrabbleTile.BLANK, 2);
    Assert.assertEquals(ScrabbleTile.STARTING_SCRABBLE_TILE_COUNT, expectedTileCounts);
  }

  @Test
  public void testConstruction() {
    Assert.assertEquals(ScrabbleTile.valueOf("C"), ScrabbleTile.C);
    Assert.assertEquals(ScrabbleTile.valueOf('C'), ScrabbleTile.C);
    try {
      ScrabbleTile.valueOf('-');
      Assert.fail();
    } catch (IllegalArgumentException e) {
      // expected
    }
  }

  @Test
  public void testGetters() {
    Assert.assertEquals(ScrabbleTile.C.getStartingCount(), 2);
    Assert.assertEquals(ScrabbleTile.C.getCharValue(), 'C');
  }

  @Test
  public void testScrabbleTileValidation() {
    Assert.assertTrue(ScrabbleTile.isScrabbleTile('C'));
    Assert.assertFalse(ScrabbleTile.isScrabbleTile('-'));
  }
}
