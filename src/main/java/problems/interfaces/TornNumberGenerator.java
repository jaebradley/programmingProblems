package problems.interfaces;

import java.util.List;

import problems.exceptions.TornNumberCandidateOddDigitCountException;
import problems.utils.SplitInteger;

public interface TornNumberGenerator {
  List<Integer> generateTornNumbers(final int upperLimitInclusive);

  SplitInteger generateSplitIntegerFromTornNumberCandidate(final int tornNumberCandidate) throws
      TornNumberCandidateOddDigitCountException;
}
