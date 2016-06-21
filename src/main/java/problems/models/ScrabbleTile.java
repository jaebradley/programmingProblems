package problems.models;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum ScrabbleTile {
  A('A', 9),
  B('B', 2),
  C('C', 2),
  D('D', 4),
  ;

  public static final Map<ScrabbleTile, Integer> STARTING_SCRABBLE_TILE_COUNT;
  static {
    final Map<ScrabbleTile, Integer> startingScrabbleTileCount = new HashMap<>();
    for (ScrabbleTile tile : ScrabbleTile.values()) {
      startingScrabbleTileCount.put(tile, tile.getStartingCount());
    }
    STARTING_SCRABBLE_TILE_COUNT = Collections.unmodifiableMap(startingScrabbleTileCount);
  }

  private final char charValue;
  private final int startingCount;

  ScrabbleTile(final char charValue, final int startingCount) {
    this.charValue = charValue;
    this.startingCount = startingCount;
  }

  public char getCharValue() {
    return charValue;
  }

  public int getStartingCount() {
    return startingCount;
  }
}
