package problems.interfaces;

import java.util.List;

public interface FisherYatesShuffler {
  <T> List<T> shuffle(final List<T> values);
}
