package problems.impl;

import problems.interfaces.LargeValuesAdder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public List<Integer> largeValuesAdder(final List<Character> largeValues1, final List<Character> largeValues2) {
        final int maxSize = Math.max(largeValues1.size(), largeValues2.size());
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

        final List<Integer> additionOutput = new ArrayList<>();
        while (!additionOutcomes.empty()) {
            additionOutput.add(additionOutcomes.pop());
        }
        return additionOutput;
    }

    /**
     * For a given index value, return the numerical value for that index value
     * @param index an int representing the lookup index value for the inputted list
     * @param largeValues the list that the lookup is being performed on
     * @return an int representing the numerical value for a given index value
     */
    @Override
    public int numericalValueForIndex(final int index, final List<Character> largeValues) {
        if (index < largeValues.size()) {
            final Character firstChar = largeValues.get(index);
            if (!Character.isDigit(firstChar)) {
                throw new IllegalArgumentException("character is not digit");
            }
            return Character.getNumericValue(firstChar);
        }
        return 0;
    }
}
