package problems.impl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.AnagramValidator;
import problems.interfaces.CharacterCountGenerator;

public class AnagramValidatorImplTest {

  private final String value1 = "jae";
  private final String value2 = "bradley";
  private final Map<Character, Integer> characterMap1 = new HashMap<>();
  private final Map<Character, Integer> characterMap2 = new HashMap<>();
  private final CharacterCountGenerator characterCountGenerator1 = new CharacterCountGenerator() {
    @Override public Map<Character, Integer> generateCharacterCount(final String value) {
      return null;
    }

    @Override public Map<Character, Integer> generateAlphabeticCharacterCount(final String value) {
      if (0 == value.compareTo(value1)) {
        return characterMap1;
      }

      return characterMap2;
    }

    @Override public Map<Character, Integer> incrementCharacterCount(final Map<Character, Integer> characterCount,
        final char character) {
      return null;
    }

    @Override public Map<Character, Integer> incrementAlphabeticCharacterCount(
        final Map<Character, Integer> characterCount, final char character) {
      return null;
    }
  };

  private final AnagramValidator anagramValidator1 = new AnagramValidatorImpl(characterCountGenerator1);

  @Test
  public void itShouldReturnAnagramValidation() {
    characterMap1.put('A', 1);
    characterMap1.put('B', 2);
    characterMap1.put('C', 3);
    Assert.assertTrue(anagramValidator1.areAnagrams(value1, value1));

    characterMap2.put('Z', 5);
    Assert.assertFalse(anagramValidator1.areAnagrams(value1, value2));
  }

}
