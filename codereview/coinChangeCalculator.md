## Purpose

Another take on the classic [`Change-making Problem`](https://en.wikipedia.org/wiki/Change-making_problem):

> Given some set of coins and a value, find the minimum number of coins necessary to add up to this value

In my implementation, instead of returning the number of coins, I'm returning a `Map` of the coin values and their
counts.

For example, given the coin values `[1, 5]`, we'd expect my implementation to return `{1: 2, 5: 1}` for an input of 7.

## Implementation Details

I decided to memoize results from previous calculations so as to not redo the same work over and over again.
The idea here is that if an input value is greater than the size of the cache, we can use the cache to identify
all values between the current size of the cache and the input value itself.

For example, the initial cache size is `1` (index `0` is mapped to an empty `HashMap`). Let's say, I call
`calculateMinimumCoinChange` with `7`. Since the input value (`7`) is greater than the size of the cache (`1`),
empty `HashMap`s are mapped to index values `1` to `7`, inclusive.

Then, starting from the previous size index (`1`), I use the cache values to calculate the coin change counts
for index values `1` through `7`. Thus, the cache should now contain coin change counts from `0` through `7`.

So if I look up the coin change counts for `5`, I can just lookup the value in the cache. If I look up the coin change
counts for `10`, I would expand my cache and use the coin change counts from `0` through `7` to inform my counts for
`8` through `10`.

There are a few things about my implementation that give me pause.

1. I think it makes sense for the `CoinChangeCalculator` to take a `Set` of `Integer` coin values as an instance variable.
But does it make sense to check this `Set` for `null`s or negative values in the constructor? Again, I think it does
(obviously) but I'm open to alternative suggestions.
2. Is there a better way to implement my memoization?
3. I had a really tough time with naming, especially when talking about counts, so open to alternative naming suggestions.

## Implementation

<!-- language: lang-java --!>

    package problems.impl;

    import java.util.*;

    public class CoinChangeCalculator {
        private final Set<Integer> coinValues;
        private final List<Map<Integer, Integer>> coinChangeCounts;

        public CoinChangeCalculator(Set<Integer> coinValues) {
            for (Integer coinValue : coinValues) {
                if (coinValue == null || coinValue < 0) {
                    throw new IllegalArgumentException(String.format("Invalid coin value: {} ", coinValue));
                }
            }

            this.coinValues = coinValues;
            this.coinChangeCounts = new ArrayList<>();
            this.coinChangeCounts.add(0, new HashMap<>());
        }

        public Map<Integer, Integer> calculateMinimumCoinChange(int value) {
            if (value > this.coinChangeCounts.size()) {
                int previousSize = this.coinChangeCounts.size();

                for (int index = previousSize; index <= value; index++) {
                    this.coinChangeCounts.add(index, new HashMap<>());
                }

                for (int subValue = previousSize; subValue <= value; subValue++) {
                    for (Integer coinValue : this.coinValues) {
                        int previousValue = subValue - coinValue;
                        if (previousValue >= 0) {
                            Map<Integer, Integer> previousValueChangeChange = coinChangeCounts.get(previousValue);
                            Map<Integer, Integer> subValueChangeCounts = coinChangeCounts.get(subValue);

                            int previousCoinCounts = previousValueChangeChange.values().stream()
                                    .filter((counts) -> counts != null)
                                    .mapToInt(Number::intValue)
                                    .sum();
                            int subValueCoinCounts = subValueChangeCounts.values().stream()
                                    .filter((counts) -> counts != null)
                                    .mapToInt(Number::intValue)
                                    .sum();

                            if (subValueChangeCounts.isEmpty() || previousCoinCounts + 1 < subValueCoinCounts) {
                                Map<Integer, Integer> updatedChangeCounts = new HashMap<>(previousValueChangeChange);

                                Integer coinValueCount = updatedChangeCounts.get(coinValue);
                                if (coinValueCount == null) {
                                    updatedChangeCounts.put(coinValue, 1);
                                } else {
                                    updatedChangeCounts.put(coinValue, coinValueCount + 1);
                                }

                                coinChangeCounts.set(subValue, updatedChangeCounts);
                            }
                        }
                    }
                }
            }

            return coinChangeCounts.get(value);
        }
    }
