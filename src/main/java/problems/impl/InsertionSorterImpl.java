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
   */
  @Override
  public void sort(final int[] numbers) {
    for (int i = 1; i < numbers.length; i++) {
      int j = i - 1;
      int numberToInsert = numbers[i];
      while (j >= 0 && numberToInsert < numbers[j]) {
        numbers[j + 1] = numbers[j];
        j--;
      }
      j++;

      numbers[j] = numberToInsert;
    }
  }
}
