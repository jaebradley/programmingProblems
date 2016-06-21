package problems.models;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum ScrabbleTile {
  A('A', 9),
  B('B', 2),
  C('C', 2),
  D('D', 4),
  E('E', 12),
  F('F', 2),
  G('G', 3),
  H('H', 2),
  I('I', 9),
  J('J', 1),
  K('K', 1),
  L('L', 4),
  M('M', 2),
  N('N', 6),
  O('O', 8),
  P('P', 2),
  Q('Q', 1),
  R('R', 6),
  S('S', 4),
  T('T', 6),
  U('U', 4),
  V('V', 2),
  W('W', 2),
  X('X', 1),
  Y('Y', 2),
  Z('Z', 1),
  BLANK('_', 2),
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

  public static boolean isScrabbleTile(final char c) {
    for (final ScrabbleTile tile : ScrabbleTile.values()) {
      if (tile.getCharValue() == c) {
        return true;
      }
    }
    return false;
  }

  public static ScrabbleTile valueOf(final char c) {
    for (final ScrabbleTile tile : ScrabbleTile.values()) {
      if (tile.getCharValue() == c) {
        return tile;
      }
    }

    throw new IllegalArgumentException(String.format("unable to get Scrabble Tile for character: %s", c));
  }
}
