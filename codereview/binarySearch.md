## Purpose

Implement a binary search algorithm that takes a sorted `int` array and some `int` target value and returns the index of the
target value, if it exists.

## Discussion

The way I thought about implementing a binary search algorithm was the following

1. Given an array of sorted `int` values, pick the first, last, and middle indices (round down if there is an even number of indices).
2. If the target value equals any of the values at the first/ last / middle index, return that index.
   Else, check to see if the target value is less / greater than the middle index value.
   1. If it's less than the middle index value, than we can assume that the target value, if it exists,
      is between the first index and the middle index (since the array should be sorted). Thus, we can call our search
      function on this sub-array, specifying a start index of the first index + 1 (since we already checked this)
      and an end index of the middle index - 1 (again, since we already checked this).
  2. If it's greater than the middle index value, we can assume that the target value is between the middle index and the last index.
     Thus, we can call the search function on this sub-array, specifying a start index of the middle index + 1 and an
     end index of the last index - 1.
3. We continue this process of analyzing the sub-arrays until our sub-array is empty, in which case a `NoSuchElementException`
   is thrown.


Things that I'm unsure about

* Does it make sense to have the `public` `search` method immediately call the `private` `searchSubArray` method?
  The reason I did this is to obfuscate the idea of a `leftIndex` / `rightIndex` from the API user.
* Does the `NoSuchElementException` make sense? Would returning `-1` make more sense?
* Any particular thoughts on my use of early returns?

## Implementation

    import java.util.NoSuchElementException;

    public class BinarySearcher {
        /**
         * Executes a binary search for some target value given an input array of sorted values
         * @param values a sorted array
         * @param target a value to search for
         * @return the index of the target value, if it exists. If the target value does not exist, a NoSuchElementException is thrown.
         */
        public static int search(int[] values, int target) {
            return searchSubArray(values, 0, values.length - 1, target);
        }

        private static int searchSubArray(int[] values, int leftIndex, int rightIndex, int target) {
            if (values.length == 0) {
                throw new NoSuchElementException(String.format("Unable to find target: {} in values", target));
            }

            if (target == values[leftIndex]) {
                return leftIndex;
            }

            if (target == values[rightIndex]) {
                return rightIndex;
            }

            int middleIndex = Double.valueOf(Math.floor((rightIndex - leftIndex) / 2)).intValue();

            int middleValue = values[middleIndex];

            if (target < middleValue) {
                return searchSubArray(values, leftIndex + 1, middleIndex + 1, target);
            }

            else if (target > middleValue) {
                return searchSubArray(values, middleIndex + 1, rightIndex - 1, target);
            }

            else {
                return middleIndex;
            }
        }
    }
