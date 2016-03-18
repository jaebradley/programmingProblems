package problems.utils;

import org.junit.Assert;
import org.junit.Test;

public class AlphabeticCharacterListOrderTest {

  @Test
  public void testExpected() {
    Assert.assertNotNull(AlphabeticCharacterListOrder.FROM_A_TO_Z);
    Assert.assertNotNull(AlphabeticCharacterListOrder.FROM_Z_TO_A);
  }
}
