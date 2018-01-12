## Purpose

I recently came across an interview question that stumped me for a while
> Given a list of integers, write a function that returns the largest sum of non-adjacent numbers.

I am looking for feedback around both my implementation and the correctness of my proposed solution (I have some test
cases, but I could have missed a case).

## Approach

For arrays with `1` or `2` values, the answer is trivial.

For arrays with more than `2` values, keep track of the maximum sum from the preceding non-adjacent elements that
*includes the most recent non-adjacent element*, and the maximum sum from the preceding non-adjacent elements that
*excludes the most recent non-adjacent element*.

So for `[3, 1, 1, 5, 1]` at index `3`, the maximum sum from preceding non-adjacent elements that includes the most recent
non-adjacent element is `1`, while the maximum sum from preceding non-adjacent elements that excludes the most recent
non-adjacent element is `3`.

Taking the max of these two sums and adding them to the current value will produce the maximum sum for non-adjacent
elements up to that index. Continuing this process for each remaining index and then comparing the last two calculated
sums will produce the maximum sum.

Let's walk through this process with `[3, 1, 1, 5, 1]`.

* At index `0`, the max sum is `3`
* At index `1`, the max sum is `1`
* At index `2`, the max sum from including the most recent non-adjacent element is `3`, while the max sum from excluding
  the most recent non-adjacent element is `0`. Thus, we choose `3` and add that to the current value (`1`). `4` is now
  the max non-adjacent sum for index `2`.
* At index `3`, the max sum from including the most recent non-adjacent element is `1`, while the max sum from excluding
  the most recent non-adjacent element is `3`. Thus, we choose `3` and add that to the current value (`5`). `8` is now
  the max non-adjacent sum for index `3`.
* At index `4`, the max sum from including the most recent non-adjacent element is `4`, while the max sum from excluding
  the most recent non-adjacent element is `3`. Thus, we choose `4` and add that to the current value (`1`). `6` is now
  the max non-adjacent sum for index `4`.
* The final two sums were `8` and `6` - we take the max (`8`).

Apologies if this was confusing to follow, it was difficult to describe my thought process.

## Implementation

<!-- language: lang-java -->

    public class MaximumNonAdjacentElementSumIdentifier {
        public static int identify(int[] values) {
            if (values == null || values.length == 0) {
                throw new RuntimeException("Unable to identify sum");
            }

            if (values.length == 1) {
                return values[0];
            }

            int firstSum = 0;
            int secondSum = values[0];
            int previousValueSum = values[1];

            for (int i = 2; i < values.length; i++) {
                int value = values[i];
                int maximumCurrentElementSum = Math.max(firstSum, secondSum) + value;
                firstSum = Math.max(firstSum, secondSum);
                secondSum = previousValueSum;
                previousValueSum = maximumCurrentElementSum;
            }

            return Math.max(secondSum, previousValueSum);
        }
    }
