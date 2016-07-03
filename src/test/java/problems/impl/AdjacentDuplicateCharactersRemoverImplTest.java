package problems.impl;

import org.junit.Test;
import problems.interfaces.AdjacentDuplicateCharactersRemover;

import java.util.Arrays;
import java.util.Stack;

import static org.junit.Assert.*;

public class AdjacentDuplicateCharactersRemoverImplTest {

  private final AdjacentDuplicateCharactersRemover adjacentDuplicateCharactersRemover = new AdjacentDuplicateCharactersRemoverImpl();
  private final Stack<Character> emptyStack = new Stack<>();

  @Test
  public void testFilterAdjacentDuplicateCharacters() {
    assertEquals(adjacentDuplicateCharactersRemover.filterAdjacentDuplicateCharacters(emptyStack), emptyStack);

    final Stack<Character> singleElementStack = new Stack<>();
    singleElementStack.add('A');
    assertEquals(adjacentDuplicateCharactersRemover.filterAdjacentDuplicateCharacters(singleElementStack), singleElementStack);

    final Stack<Character> uniqueElementsStack = new Stack<>();
    uniqueElementsStack.addAll(Arrays.asList('A', 'B', 'C', 'D'));
    final Stack<Character> expectedUniqueElementsStack = new Stack<>();
    expectedUniqueElementsStack.addAll(Arrays.asList('D', 'C', 'B', 'A'));
    assertEquals(adjacentDuplicateCharactersRemover.filterAdjacentDuplicateCharacters(uniqueElementsStack), expectedUniqueElementsStack);

    final Stack<Character> allDuplicateElementsStack = new Stack<>();
    allDuplicateElementsStack.addAll(Arrays.asList('B', 'A', 'A', 'B'));
    assertEquals(adjacentDuplicateCharactersRemover.filterAdjacentDuplicateCharacters(allDuplicateElementsStack), emptyStack);
  }

  @Test
  public void testRemoveAdjacentDuplicateCharacters() {
    final String emptyString = "";
    assertEquals(adjacentDuplicateCharactersRemover.removeAdjacentDuplicateCharacters(emptyString), emptyString);

    final String oneElementString = "A";
    assertEquals(adjacentDuplicateCharactersRemover.removeAdjacentDuplicateCharacters(oneElementString), oneElementString);

    final String uniqueElementsString = "ABCD";
    assertEquals(adjacentDuplicateCharactersRemover.removeAdjacentDuplicateCharacters(uniqueElementsString), uniqueElementsString);

    final String allDuplicateElementsString = "BAAB";
    assertEquals(adjacentDuplicateCharactersRemover.removeAdjacentDuplicateCharacters(allDuplicateElementsString), emptyString);
  }
}