package problems.impl;

public class HungryRabbit {
    public static int getConsumedCarrotCount(int[][] garden) {
        int[] startingCoordinates = getStartingCoordinate(garden);
        return eatCarrots(garden, 0, startingCoordinates[0], startingCoordinates[1]);
    }

    private static int[] getStartingCoordinate(int[][] garden) {
        int lowerBoundRowIndex = (garden.length - 1) / 2;
        int lowerBoundColumnIndex = (garden[0].length - 1) / 2;
        int upperBoundRowIndex = lowerBoundRowIndex;
        int upperBoundColumnIndex = lowerBoundColumnIndex;

        if (garden.length % 2 == 0) {
            upperBoundRowIndex++;
        }

        if (garden[0].length % 2 == 0) {
            upperBoundColumnIndex++;
        }

        int[] maxCoordinates = new int[2];
        int maxSum = 0;

        for (int i = lowerBoundRowIndex; i <= upperBoundRowIndex; i++) {
            for (int j = lowerBoundColumnIndex; j <= upperBoundColumnIndex; j++) {
                int sum = garden[i][j];
                if (sum > maxSum) {
                    maxSum = sum;
                    maxCoordinates[0] = i;
                    maxCoordinates[1] = j;
                }
            }
        }

        return maxCoordinates;
    }

    private static int eatCarrots(int[][] garden, int carrotCount, int currentRowIndex, int currentColumnIndex) {
        int carrotsAtCell = garden[currentRowIndex][currentColumnIndex];

        carrotCount += carrotsAtCell;

        garden[currentRowIndex][currentColumnIndex] = 0;

        int[] maxCoordinates = new int[2];
        int maxSum = 0;

        for (int i = -1; i <=  1 && i != 0; i++) {
            int sum = getSum(garden, currentRowIndex, currentColumnIndex + i);
            if (sum > maxSum) {
                maxSum = sum;
                maxCoordinates = new int[]{currentRowIndex, currentColumnIndex + i};
            }

            sum = getSum(garden, currentRowIndex + i, currentColumnIndex);
            if (sum > maxSum) {
                maxSum = sum;
                maxCoordinates = new int[]{currentRowIndex + i, currentColumnIndex};
            }
        }

        if (maxSum == 0) {
            return carrotCount;
        }

        return eatCarrots(garden, carrotCount, maxCoordinates[0], maxCoordinates[1]);
    }

    private static int getSum(int[][] garden, int rowIndex, int columnIndex) {
        if (rowIndex > garden.length - 1 || rowIndex < 0 || columnIndex > garden[rowIndex].length - 1 || columnIndex < 0) {
            return 0;
        }

        return garden[rowIndex][columnIndex];
    }
}
