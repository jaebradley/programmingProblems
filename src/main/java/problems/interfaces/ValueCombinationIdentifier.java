package problems.interfaces;

import problems.exceptions.NoValueCombinationIdentifiedException;
import problems.models.TwoValueCombination;

import java.util.List;

public interface ValueCombinationIdentifier {
  TwoValueCombination identifyTwoValuesThatSumToTarget(final long target, List<Long> values) throws NoValueCombinationIdentifiedException;
}
