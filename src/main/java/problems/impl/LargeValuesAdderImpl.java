package problems.impl;

import java.util.Stack;

import problems.interfaces.LargeValuesAdder;

public class LargeValuesAdderImpl implements LargeValuesAdder {

    /**
     * Returns a list of integers that represents the addition outcome after adding two large values represented by
     * a list of characters.
     *
     * @param largeValues1 a list of characters, which represent a large numerical value
     * @param largeValues2 a list of characters, which represent a large numerical value
     * @return list of integers that represents the addition outcome after adding two large values
     */
    @Override
    public String largeValuesAdder(final String largeValues1, final String largeValues2) {
        final int maxSize = Math.max(largeValues1.length(), largeValues2.length());
        final Stack<Integer> additionOutcomes = new Stack<>();
        boolean hasCarryValue = false;
        for (int index = 0; index < maxSize; index++) {
            int additionValue = numericalValueForIndex(index, largeValues1) + numericalValueForIndex(index, largeValues2);
            if (hasCarryValue) {
                additionValue++;
            }

            if (additionValue > 9) {
                hasCarryValue = true;
                additionOutcomes.push(additionValue - 10);
            } else {
                hasCarryValue = false;
                additionOutcomes.push(additionValue);
            }
        }

        if (hasCarryValue) {
            additionOutcomes.push(1);
        }

        final StringBuilder stringBuilder = new StringBuilder();
        while (!additionOutcomes.empty()) {
            stringBuilder.append(additionOutcomes.pop());
        }
        return stringBuilder.toString();
    }

    /**
     * For a given index value, return the numerical value for that index value
     * @param index an int representing the lookup index value for the inputted list
     * @param largeValues the list that the lookup is being performed on
     * @return an int representing the numerical value for a given index value
     */
    @Override
    public int numericalValueForIndex(final int index, final String largeValues) {
        if (index < largeValues.length()) {
            final Character firstChar = largeValues.charAt(largeValues.length() - 1 - index);
            if (!Character.isDigit(firstChar)) {
                throw new IllegalArgumentException("character is not digit");
            }
            return Character.getNumericValue(firstChar);
        }
        return 0;
    }
}
