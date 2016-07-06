package problems.impl;

import org.junit.Assert;
import org.junit.Test;
import problems.interfaces.InsertionSorter;

public class InsertionSorterImplTest {

  private final InsertionSorter insertionSorter = new InsertionSorterImpl();

  @Test
  public void testInsertionSort() {
    Assert.assertArrayEquals(insertionSorter.sort(new int[] {5}), new int [] {5});
    Assert.assertArrayEquals(insertionSorter.sort(new int[] {5, 4, 3, 2, 1}), new int [] {1, 2, 3, 4, 5});
    Assert.assertArrayEquals(insertionSorter.sort(new int[] {-1, -1, -1}), new int [] {-1, -1, -1});
    Assert.assertArrayEquals(insertionSorter.sort(new int[] {-1, 4, -2}), new int [] {-2, -1, 4});
  }

}