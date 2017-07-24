package problems.impl;

import java.util.*;

public class CoinChangeCalculator {
    private final Set<Integer> coinValues;

    public CoinChangeCalculator(Set<Integer> coinValues) {
        for (Integer coinValue : coinValues) {
            if (coinValue == null || coinValue < 0) {
                throw new IllegalArgumentException(String.format("Invalid coin value: {} ", coinValue));
            }
        }

        this.coinValues = coinValues;
    }

    public Map<Integer, Integer> calculateMinimumCoinValuesNecessaryToMakeChange(int value) {
        List<Map<Integer, Integer>> coinChangeCounts = CoinChangeCalculator.buildInitialCoinChangeCounts(value);

        for (int subValue = 1; subValue <= value; subValue++) {
            for (Integer coinValue : this.coinValues) {
                int previousCoinSubValue = subValue - coinValue;
                if (previousCoinSubValue >= 0) {
                    Map<Integer, Integer> previousCoinChangeCounts = coinChangeCounts.get(previousCoinSubValue);
                    int previousCoins = CoinChangeCalculator.sumEntries(previousCoinChangeCounts);

                    Map<Integer, Integer> subValueCoinChangeCounts = coinChangeCounts.get(subValue);
                    int subValueCoins = CoinChangeCalculator.sumEntries(subValueCoinChangeCounts);

                    if (subValueCoinChangeCounts.isEmpty() || previousCoins + 1 < subValueCoins) {
                        Map<Integer, Integer> updatedChangeCounts = new HashMap<>(previousCoinChangeCounts);
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

    private static List<Map<Integer, Integer>> buildInitialCoinChangeCounts(int value) {
        List<Map<Integer, Integer>> coinChangeCounts = new ArrayList<>();
        for (int index = 0; index <= value; index++) {
            coinChangeCounts.add(index, new HashMap<>());
        }
        return coinChangeCounts;
    }

    private static int sumEntries(Map<Integer, Integer> map) {
        int sum = 0;
        for (Integer value : map.values()) {
            if (value != null) {
                sum += value;
            }
        }
        return sum;
    }
}
