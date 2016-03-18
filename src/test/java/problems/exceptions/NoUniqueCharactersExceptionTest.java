package problems.exceptions;

import org.junit.Assert;
import org.junit.Test;

public class NoUniqueCharactersExceptionTest {

  @Test public void testExpected() {
    final NoUniqueCharactersException exception = new NoUniqueCharactersException();
    Assert.assertNotNull(exception);
  }
}
