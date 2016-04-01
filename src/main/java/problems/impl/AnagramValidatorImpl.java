package problems.impl;

import problems.interfaces.AnagramValidator;
import problems.interfaces.CharacterCountGenerator;

public class AnagramValidatorImpl implements AnagramValidator {

  private final CharacterCountGenerator characterCountGenerator;

  public AnagramValidatorImpl(final CharacterCountGenerator characterCountGenerator) {
    this.characterCountGenerator = characterCountGenerator;
  }

  @Override
  public boolean areAnagrams(final String value1, final String value2) {
    return characterCountGenerator.generateAlphabeticCharacterCount(value1) == characterCountGenerator.generateAlphabeticCharacterCount(value2);
  }
}
