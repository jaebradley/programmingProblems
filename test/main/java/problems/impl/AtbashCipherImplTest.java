package problems.impl;

import org.junit.Assert;
import org.junit.Test;

public class AtbashCipherImplTest {
  private final AtbashCipherImpl atbashCipherImpl = new AtbashCipherImpl();

  @Test
  public void testAtBashPair() {
    try {
      atbashCipherImpl.atbashCounterpart('1');
    } catch (RuntimeException e) {
      // expected
    }

    try {
      atbashCipherImpl.atbashCounterpart('/');
    } catch (RuntimeException e) {
      // expected
    }

    Assert.assertEquals(atbashCipherImpl.atbashCounterpart('A'), 'Z');
  }

  @Test
  public void testApplyCipher() {
    Assert.assertEquals(atbashCipherImpl.applyCipher('1'), '1');
    Assert.assertEquals(atbashCipherImpl.applyCipher('/'), '/');
    Assert.assertEquals(atbashCipherImpl.applyCipher('a'), 'z');
    Assert.assertEquals(atbashCipherImpl.applyCipher('A'), 'Z');
  }

}
