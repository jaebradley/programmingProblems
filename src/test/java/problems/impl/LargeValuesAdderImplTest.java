package problems.impl;

import org.junit.Assert;
import org.junit.Test;
import problems.interfaces.LargeValuesAdder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargeValuesAdderImplTest {

    private final LargeValuesAdder largeValuesAdder = new LargeValuesAdderImpl();
    private final List<Character> characterList1 = new ArrayList<>(Arrays.asList('9', '9'));
    private final List<Character> characterList2 = new ArrayList<>(Arrays.asList('9', '9', '9'));
    private final List<Character> characterList3 = new ArrayList<>(Arrays.asList('1'));

    @Test
    public void testExpected() {
        final List<Integer> output1 = largeValuesAdder.largeValuesAdder(characterList1, characterList1);
        Assert.assertEquals(output1, new ArrayList<>(Arrays.asList(1, 9, 8)));

        final List<Integer> output2 = largeValuesAdder.largeValuesAdder(characterList1, characterList2);
        Assert.assertEquals(output2, new ArrayList<>(Arrays.asList(1, 0, 9, 8)));

        final List<Integer> output3 = largeValuesAdder.largeValuesAdder(characterList3, characterList3);
        Assert.assertEquals(output3, new ArrayList<>(Arrays.asList(2)));

        final List<Integer> output4 = largeValuesAdder.largeValuesAdder(characterList3, new ArrayList<>());
        Assert.assertEquals(output4, new ArrayList<>(Arrays.asList(1)));

        final List<Integer> output5 = largeValuesAdder.largeValuesAdder(new ArrayList<>(), new ArrayList<>());
        Assert.assertEquals(output5, new ArrayList<>());
    }
}