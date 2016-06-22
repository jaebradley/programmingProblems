package problems.impl;

import problems.exceptions.NoRemainingTilesException;
import problems.interfaces.ScrabbleTileCounter;
import problems.models.ScrabbleTile;

import java.util.*;

/**
 * Outputs remaining Scrabble tiles
 * Inspired by https://www.reddit.com/r/dailyprogrammer/comments/4oylbo/20160620_challenge_272_easy_whats_in_the_bag/
 */

public class ScrabbleTileCounterImpl implements ScrabbleTileCounter {

  /**
   * Given a Collection of tiles that have already been used, returns the remaining tile counts or a NoRemainingTilesException
   * if there are no more tiles of a given type.
   * @param tiles a Collection of tiles that have already been used
   * @return a Map of tiles to tile counts remaining
   * @throws NoRemainingTilesException
   */

  @Override
  public Map<ScrabbleTile, Integer> calculateTileCount(final Collection<ScrabbleTile> tiles) throws NoRemainingTilesException {
    final Map<ScrabbleTile, Integer> tileCount = new HashMap<>();
    tileCount.putAll(ScrabbleTile.STARTING_SCRABBLE_TILE_COUNT);
    for (ScrabbleTile tile : tiles) {
      if (tileCount.get(tile) < 1) {
        throw new NoRemainingTilesException();
      }

      final int nextVal = tileCount.get(tile) - 1;
      tileCount.put(tile, nextVal);
    }
    return tileCount;
  }

  @Override
  public Map<Integer, Set<ScrabbleTile>> calculateOutputTileCount(final Map<ScrabbleTile, Integer> tileCount) {
    final Map<Integer, Set<ScrabbleTile>> outputTileCount = new HashMap<>();
    for (Map.Entry<ScrabbleTile, Integer> entry : tileCount.entrySet()) {
      final Set<ScrabbleTile> scrabbleTiles = outputTileCount.get(entry.getValue());
      if (scrabbleTiles == null) {
        outputTileCount.put(entry.getValue(), new HashSet<>(Arrays.asList(entry.getKey())));
      } else {
        scrabbleTiles.add(entry.getKey());
        outputTileCount.put(entry.getValue(), scrabbleTiles);
      }
    }
    return outputTileCount;
  }
}
