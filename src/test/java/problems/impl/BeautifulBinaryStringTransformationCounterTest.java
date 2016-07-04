package problems.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class BeautifulBinaryStringTransformationCounterTest {

  @Test
  public void testCounter() {
    final String smallBinary = "01";
    assertEquals(BeautifulBinaryStringTransformationCounter.count(smallBinary), 0);

    final String singleBeautifulBinary = "010";
    assertEquals(BeautifulBinaryStringTransformationCounter.count(singleBeautifulBinary), 1);

    final String sharedBeautifulBinaries = "0101010";
    assertEquals(BeautifulBinaryStringTransformationCounter.count(sharedBeautifulBinaries), 2);
  }
}