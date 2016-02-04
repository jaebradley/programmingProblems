package problems.impl;

import problems.interfaces.CoconutCalculator;

public class CoconutCalculatorImpl implements CoconutCalculator {
    @Override
    public double calculateCoconuts(final long sailors) {
        long factor = 1;
        final double multiplier = (double) sailors / (double) (sailors - 1);
        while (true) {
            double baseValue = (factor * sailors);
            long counter = 0;
            while ((0 == baseValue % (sailors - 1)) & (counter < sailors)) {
                baseValue = (baseValue * multiplier) + 1;
                counter++;
            }

            if (counter == sailors) {
                return baseValue;
            }

            factor++;
        }

    }
}
