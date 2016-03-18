package problems.exceptions;

import org.junit.Assert;
import org.junit.Test;

public class TornNumberCandidateOddDigitCountExceptionTest {

  @Test
  public void testExpected() {
    final TornNumberCandidateOddDigitCountException exception = new TornNumberCandidateOddDigitCountException();
    Assert.assertNotNull(exception);
  }
}
