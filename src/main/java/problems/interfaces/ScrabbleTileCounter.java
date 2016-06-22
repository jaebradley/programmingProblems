package problems.interfaces;

import problems.exceptions.NoRemainingTilesException;
import problems.models.ScrabbleTile;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface ScrabbleTileCounter {
  Map<ScrabbleTile, Integer> calculateTileCount(final Collection<ScrabbleTile> tiles) throws NoRemainingTilesException;

  Map<Integer, Set<ScrabbleTile>> calculateOutputTileCount(final Map<ScrabbleTile, Integer> tileCount);
}
