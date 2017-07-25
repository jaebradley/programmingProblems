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
        if (value < this.coinChangeCounts.size()) {
            return this.coinChangeCounts.get(value);
        }

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

        return coinChangeCounts.get(value);
    }
}
