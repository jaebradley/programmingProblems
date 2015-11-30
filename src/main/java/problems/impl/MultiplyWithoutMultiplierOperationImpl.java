package main.java.problems.impl;

import main.java.problems.interfaces.MultiplyWithoutMultiplierOperation;

public class MultiplyWithoutMultiplierOperationImpl implements MultiplyWithoutMultiplierOperation {
    @Override
    public int multiply(final int multiplier, final int multiplicand) {
        if (0 == multiplier) {
            return 0;
        }

        int sum = 0;
        for (int multiplierCount = 0; multiplierCount < Math.abs(multiplier); multiplierCount++) {
            sum += Math.abs(multiplicand);
        }

        if ((multiplier < 0 && multiplicand < 0) || (multiplier > 0 && multiplicand > 0)) {
            return sum;
        } else {
            return -sum;
        }
    }
}
