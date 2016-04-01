package problems.impl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.CharacterCountGenerator;

public class CharacterCountGeneratorImplTest {
  private final CharacterCountGenerator characterCountGenerator = new CharacterCountGeneratorImpl();

  @Test
  public void itShouldIncrementCharacterCounts() {
    final Map<Character, Integer> characterCounts1 = new HashMap<>();
    characterCountGenerator.incrementCharacterCount(characterCounts1, 'A');
    final Map<Character, Integer> expectedCharacterCounts1 = new HashMap<>();
    expectedCharacterCounts1.put('A', 1);
    Assert.assertEquals(characterCounts1, expectedCharacterCounts1);
    characterCountGenerator.incrementCharacterCount(characterCounts1, 'A');
    expectedCharacterCounts1.put('A', 2);
    Assert.assertEquals(characterCounts1, expectedCharacterCounts1);
    characterCountGenerator.incrementCharacterCount(characterCounts1, 'B');
    expectedCharacterCounts1.put('B', 1);
    Assert.assertEquals(characterCounts1, expectedCharacterCounts1);
  }

  @Test
  public void itShouldGenerateCharacterCounts() {
    final Map<Character, Integer> characterCounts = new HashMap<>();
    characterCounts.put('A', 1);
    characterCounts.put('B', 1);
    characterCounts.put('C', 2);
    characterCounts.put(' ', 1);
    Assert.assertEquals(characterCountGenerator.generateCharacterCount("AC BC"), characterCounts);
    final Map<Character, Integer> emptyCharacterCounts = new HashMap<>();
    Assert.assertEquals(characterCountGenerator.generateCharacterCount(""), emptyCharacterCounts);
  }

}
