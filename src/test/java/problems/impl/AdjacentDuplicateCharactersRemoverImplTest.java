package problems.impl;

import org.junit.Test;
import problems.interfaces.AdjacentDuplicateCharactersRemover;

import static org.junit.Assert.assertEquals;

public class AdjacentDuplicateCharactersRemoverImplTest {

  private final AdjacentDuplicateCharactersRemover adjacentDuplicateCharactersRemover = new AdjacentDuplicateCharactersRemoverImpl();

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