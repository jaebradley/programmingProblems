package problems.utils;

import java.util.ArrayList;
import java.util.List;

import problems.interfaces.OrderedAlphabeticCharacterListGenerator;

public class OrderedAlphabeticCharacterListGeneratorImpl implements OrderedAlphabeticCharacterListGenerator {
  @Override public List<Character> generateAlphabeticCharacterListFromAtoZ() {
    final List<Character> alphabeticChars = new ArrayList<>();
    for (char ch = 'A'; ch <= 'Z'; ++ch) {
      alphabeticChars.add(ch);
    }
    return alphabeticChars;
  }

  @Override public List<Character> generateAlphabeticCharacterListFromZtoA() {
    final List<Character> alphabeticChars = new ArrayList<>();
    for (char ch = 'Z'; ch >= 'A'; --ch) {
      alphabeticChars.add(ch);
    }
    return alphabeticChars;
  }

  @Override public List<Character> generateOrderedAlphabeticCharacterList(final AlphabeticCharacterListOrder order) {
    switch (order) {
      case FROM_A_TO_Z: {
        return this.generateAlphabeticCharacterListFromAtoZ();
      }

      case FROM_Z_TO_A: {
        return this.generateAlphabeticCharacterListFromZtoA();
      }

      default: {
        throw new RuntimeException("unexpected order");
      }
    }
  }
}
