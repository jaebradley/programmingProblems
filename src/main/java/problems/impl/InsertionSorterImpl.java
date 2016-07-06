package problems.impl;

import problems.interfaces.InsertionSorter;

/**
 * Implement insertion sort https://en.wikipedia.org/wiki/Insertion_sort
 */
public class InsertionSorterImpl implements InsertionSorter {
  /**
   * Implements insertion sort by iterating through the array values from index 1 onwards.
   * For the given value at the specified index, working backwards from that index, find the first value
   * that is less than the given value at the specified index. Increment the index of all the values before that index
   * and slot the given value into that index.
   * @param numbers an array of integers
   * @return a sorted array of integers
   */
  @Override
  public int[] sort(final int[] numbers) {
    final int[] sorted = numbers.clone();
    for (int i = 1; i < sorted.length; i++) {
      int j = i - 1;
      int numberToInsert = sorted[i];
      while (j >= 0 && numberToInsert < sorted[j]) {
        sorted[j + 1] = sorted[j];
        sorted[j] = numberToInsert;
        j--;
      }
    }
    return sorted;
  }
}
