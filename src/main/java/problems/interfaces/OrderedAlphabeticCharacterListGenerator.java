package problems.interfaces;

import java.util.List;

import problems.utils.AlphabeticCharacterListOrder;

public interface OrderedAlphabeticCharacterListGenerator {
  List<Character> generateOrderedAlphabeticCharacterList(final AlphabeticCharacterListOrder order);
  List<Character> generateAlphabeticCharacterListFromAtoZ();
  List<Character> generateAlphabeticCharacterListFromZtoA();
}
