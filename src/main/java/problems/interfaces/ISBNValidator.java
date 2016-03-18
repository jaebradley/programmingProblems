package problems.interfaces;

import java.util.List;

public interface ISBNValidator {
  boolean validateISBN(final long candidate);
  long sumISBNCandidateDigits(final List<Integer>candidateDigits);
}
