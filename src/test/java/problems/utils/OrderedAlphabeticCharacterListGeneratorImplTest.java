package problems.utils;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.OrderedAlphabeticCharacterListGenerator;

public class OrderedAlphabeticCharacterListGeneratorImplTest {
  private final OrderedAlphabeticCharacterListGenerator orderedAlphabeticCharacterListGenerator = new OrderedAlphabeticCharacterListGeneratorImpl();

  @Test
  public void testGeneratedListFromAtoZ() {
    final List<Character> charsFromAtoZ = orderedAlphabeticCharacterListGenerator.generateAlphabeticCharacterListFromAtoZ();
    Assert.assertEquals(26, charsFromAtoZ.size());
  }

  @Test
  public void testGeneratedListFromZtoA() {
    final List<Character> charsFromZtoA = orderedAlphabeticCharacterListGenerator.generateAlphabeticCharacterListFromZtoA();
    Assert.assertEquals(26, charsFromZtoA.size());
  }

}
