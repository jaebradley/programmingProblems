package problems.impl;

import java.util.Stack;

import problems.interfaces.LargeValuesAdder;

public class LargeValuesAdderImpl implements LargeValuesAdder {

    /**
     * Returns a String that represents the addition outcome after adding two large values represented by
     * two Strings.
     *
     * @param largeValues1 a String, which represent a large numerical value
     * @param largeValues2 a String, which represent a large numerical value
     * @return String that represents the addition outcome after adding two large values
     */
    @Override
    public String largeValuesAdder(final String largeValues1, final String largeValues2) {
        final int maxSize = Math.max(largeValues1.length(), largeValues2.length());
        final Stack<Integer> additionOutcomes = new Stack<>();
        boolean hasCarryValue = false;
        for (int index = 0; index < maxSize; index++) {
            int firstCharNumericalValue = 0;
            if (index < largeValues1.length()) {
                firstCharNumericalValue = numericalValueForIndex(index, largeValues1);
            }

            int secondCharNumericalValue = 0;
            if (index < largeValues2.length()) {
                secondCharNumericalValue = numericalValueForIndex(index, largeValues2);
            }
            int additionValue = firstCharNumericalValue + secondCharNumericalValue;

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
        if (index >= largeValues.length()) {
            throw new IllegalArgumentException("specified index is not less than the length of the input string");
        }

        final Character firstChar = largeValues.charAt(largeValues.length() - 1 - index);
        if (!Character.isDigit(firstChar)) {
            throw new IllegalArgumentException("character is not digit");
        }
        return Character.getNumericValue(firstChar);
    }
}
