package problems.interfaces;

import java.util.Map;
import java.util.Set;

public interface SubstringsGenerator {
  Map<Integer, Set<String>> generateLengthSortedSubstrings(final String value);

  Set<String> generateSubstrings(final String value, final int length);
}
