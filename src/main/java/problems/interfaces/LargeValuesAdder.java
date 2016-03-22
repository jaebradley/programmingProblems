package problems.interfaces;

import java.util.List;

public interface LargeValuesAdder {
    List<Integer> largeValuesAdder(final List<Character> largeValues1, final List<Character> largeValues2);

    int numericalValueForIndex(final int index, List<Character> largeValues);
}
