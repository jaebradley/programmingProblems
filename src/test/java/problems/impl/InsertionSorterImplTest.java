package problems.impl;

import org.junit.Assert;
import org.junit.Test;
import problems.interfaces.InsertionSorter;

public class InsertionSorterImplTest {

  private final InsertionSorter insertionSorter = new InsertionSorterImpl();

  @Test
  public void testInsertionSort() {
    final int[] singleElementArray = new int[] {5};
    insertionSorter.sort(singleElementArray);
    Assert.assertArrayEquals(singleElementArray, new int [] {5});

    final int[] unsortedArray = new int[] {5, 3, 4, 2, 1};
    insertionSorter.sort(unsortedArray);
    Assert.assertArrayEquals(unsortedArray, new int [] {1, 2, 3, 4, 5});

    final int[] sameElementArray = new int[] {-1, -1, -1};
    insertionSorter.sort(sameElementArray);
    Assert.assertArrayEquals(sameElementArray, new int [] {-1, -1, -1});
  }

}