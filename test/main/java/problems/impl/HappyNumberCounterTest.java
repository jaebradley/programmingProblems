package problems.impl;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class HappyNumberCounterTest {

  @Test
  public void testExpected() {
    Assert.assertEquals(2, HappyNumberCounter.countHappyNumbersInRange(1, 3));
  }

}
