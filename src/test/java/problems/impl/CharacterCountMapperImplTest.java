package problems.impl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.CharacterCountMapper;

public class CharacterCountMapperImplTest {

  private final CharacterCountMapper characterCountMapper = new CharacterCountMapperImpl();
  private final String multiCharacterInvalidString = "a11BBBdddd";
  private final String validString = "aaBBcc";
  private final String invalidAlmostValidStringByRemoval1 = "aaaBBccc";
  private final String almostValidStringByRemoval1 = "aaabbbbccc";
  private final String almostValidStringByRemoval2 = "aaaabbbbc";
  private final String invalidAlmostValidStringByRemoval = "aaBBcd";
  private final String emptyString = "";


  @Test
  public void testCharacterCountMapping() {
    final Map<Character, Long> expectedCharacterCountMap = new HashMap<>();
    expectedCharacterCountMap.put('a', 1L);
    expectedCharacterCountMap.put('1', 2L);
    expectedCharacterCountMap.put('B', 3L);
    expectedCharacterCountMap.put('d', 4L);
    final Map<Character, Long> characterCountMap = characterCountMapper.mapCharacterCount(multiCharacterInvalidString);
    Assert.assertEquals(characterCountMap, expectedCharacterCountMap);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullInputStringForCharacterCountMapping() {
    characterCountMapper.mapCharacterCount(null);
  }

  @Test
  public void testIsValidString() {
    Assert.assertTrue(characterCountMapper.isValidString(validString));
    Assert.assertFalse(characterCountMapper.isValidString(multiCharacterInvalidString));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullInputStringForValidString() {
    characterCountMapper.isValidString(null);
  }

  @Test
  public void testIsAlmostValidStringByRemoval() {
    Assert.assertTrue(characterCountMapper.isAlmostValidStringByRemoval(almostValidStringByRemoval1));
    Assert.assertTrue(characterCountMapper.isAlmostValidStringByRemoval(almostValidStringByRemoval2));
    Assert.assertFalse(characterCountMapper.isAlmostValidStringByRemoval(validString));
    Assert.assertFalse(characterCountMapper.isAlmostValidStringByRemoval(multiCharacterInvalidString));
    Assert.assertFalse(characterCountMapper.isAlmostValidStringByRemoval(invalidAlmostValidStringByRemoval));
    Assert.assertFalse(characterCountMapper.isAlmostValidStringByRemoval(invalidAlmostValidStringByRemoval1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIsAlmostStringByRemoval() {
    characterCountMapper.isAlmostValidStringByRemoval(null);
  }

  @Test
  public void testIsAtLeastAlmostValidStringByRemoval() {
    Assert.assertTrue(characterCountMapper.isAlmostValidStringByRemoval(almostValidStringByRemoval1));
    Assert.assertTrue(characterCountMapper.isAlmostValidStringByRemoval(almostValidStringByRemoval2));
    Assert.assertTrue(characterCountMapper.isAtLeastAlmostValidStringByRemoval(validString));
    Assert.assertFalse(characterCountMapper.isAtLeastAlmostValidStringByRemoval(multiCharacterInvalidString));
    Assert.assertFalse(characterCountMapper.isAlmostValidStringByRemoval(invalidAlmostValidStringByRemoval));
    Assert.assertFalse(characterCountMapper.isAlmostValidStringByRemoval(invalidAlmostValidStringByRemoval1));
  }
}
