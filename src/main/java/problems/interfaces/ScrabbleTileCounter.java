package problems.interfaces;

import problems.exceptions.NoRemainingTilesException;
import problems.models.ScrabbleTile;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface ScrabbleTileCounter {
  Map<ScrabbleTile, Integer> calculateTileCount(final Collection<ScrabbleTile> tiles) throws NoRemainingTilesException;

  Map<Integer, List<ScrabbleTile>> calculateOutputTileCount(final Map<ScrabbleTile, Integer> tileCount);
}
