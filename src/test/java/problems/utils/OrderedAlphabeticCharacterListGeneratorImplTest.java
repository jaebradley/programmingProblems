package problems.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.OrderedAlphabeticCharacterListGenerator;

public class OrderedAlphabeticCharacterListGeneratorImplTest {
  private final OrderedAlphabeticCharacterListGenerator orderedAlphabeticCharacterListGenerator = new OrderedAlphabeticCharacterListGeneratorImpl();
  private final List<Character> AtoZ = new ArrayList<>(
      Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
  );
  private final List<Character> ZtoA = new ArrayList<>(
      Arrays.asList('Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N', 'M', 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A')
  );

  @Test
  public void testGeneratedListFromAtoZ() {
    final List<Character> charsFromAtoZ = orderedAlphabeticCharacterListGenerator.generateAlphabeticCharacterListFromAtoZ();
    Assert.assertEquals(26, charsFromAtoZ.size());
    Assert.assertEquals(charsFromAtoZ, AtoZ);
  }

  @Test
  public void testGeneratedListFromZtoA() {
    final List<Character> charsFromZtoA = orderedAlphabeticCharacterListGenerator.generateAlphabeticCharacterListFromZtoA();
    Assert.assertEquals(26, charsFromZtoA.size());
    Assert.assertEquals(charsFromZtoA, ZtoA);
  }

  @Test
  public void testGenerateOrderedAlphabeticCharacterList() {
    try {
      orderedAlphabeticCharacterListGenerator.generateOrderedAlphabeticCharacterList(null);
      Assert.fail();
    } catch (RuntimeException e) {
      // expected
    }

    final List<Character> charsFromAtoZ = orderedAlphabeticCharacterListGenerator.generateOrderedAlphabeticCharacterList(AlphabeticCharacterListOrder.FROM_A_TO_Z);
    Assert.assertEquals(26, charsFromAtoZ.size());
    Assert.assertEquals(charsFromAtoZ, AtoZ);

    final List<Character> charsFromZtoA = orderedAlphabeticCharacterListGenerator.generateOrderedAlphabeticCharacterList(AlphabeticCharacterListOrder.FROM_Z_TO_A);
    Assert.assertEquals(26, charsFromZtoA.size());
    Assert.assertEquals(charsFromZtoA, ZtoA);
  }

}
