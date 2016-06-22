package problems.impl;

import problems.exceptions.NoRemainingTilesException;
import problems.interfaces.ScrabbleTileCounter;
import problems.models.ScrabbleTile;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ScrabbleTileCounterImpl implements ScrabbleTileCounter {

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
  public Map<Integer, ScrabbleTile> calculateOutputTileCount(final Map<ScrabbleTile, Integer> tileCount) {
    final Map<Integer, ScrabbleTile> outputTileCount = new HashMap<>();
    for (Map.Entry<ScrabbleTile, Integer> entry : tileCount.entrySet()) {
      outputTileCount.put(entry.getValue(), entry.getKey());
    }
    return outputTileCount;
  }
}
