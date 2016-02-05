package problems.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import problems.interfaces.OrderedAlphabeticCharacterListGenerator;
import problems.interfaces.StringCharactersInAlphabeticalOrderEvaluator;
import problems.utils.AlphabeticalOrderState;
import problems.utils.OrderedAlphabeticCharacterListGeneratorImpl;

public class StringCharactersInAlphabeticalOrderEvaluatorImplTest {
  private final OrderedAlphabeticCharacterListGenerator orderedAlphabeticCharacterListGenerator = new OrderedAlphabeticCharacterListGeneratorImpl();
  private final List<Character> charsFromAtoZ = orderedAlphabeticCharacterListGenerator.generateAlphabeticCharacterListFromAtoZ();
  private final StringCharactersInAlphabeticalOrderEvaluator stringCharactersInAlphabeticalOrderEvaluator = new StringCharactersInAlphabeticalOrderEvaluatorImpl(charsFromAtoZ);

  private final String bothAlphabeticalAndReverseAlphabeticalOrder = "aaaa";
  private final String alphabeticalOrder = "abcd";
  private final String reverseAlphabeticalOrder = "dcba";
  private final String neitherAlphabeticalAndReverseAlphabeticalOrder = "abab";

  @Test
  public void testExpected() {
    Assert.assertEquals(AlphabeticalOrderState.IN_BOTH_ALPHABETICAL_AND_REVERSE_ALPHABETICAL_ORDER, stringCharactersInAlphabeticalOrderEvaluator.evaluateAlphabeticalOrderOfCharacters(bothAlphabeticalAndReverseAlphabeticalOrder));
    Assert.assertEquals(AlphabeticalOrderState.IN_ALPHABETICAL_ORDER, stringCharactersInAlphabeticalOrderEvaluator.evaluateAlphabeticalOrderOfCharacters(alphabeticalOrder));
    Assert.assertEquals(AlphabeticalOrderState.IN_REVERSE_ALPHABETICAL_ORDER, stringCharactersInAlphabeticalOrderEvaluator.evaluateAlphabeticalOrderOfCharacters(reverseAlphabeticalOrder));
    Assert.assertEquals(AlphabeticalOrderState.IN_NEITHER_ALPHABETICAL_NOR_REVERSE_ALPHABETICAL_ORDER, stringCharactersInAlphabeticalOrderEvaluator.evaluateAlphabeticalOrderOfCharacters(neitherAlphabeticalAndReverseAlphabeticalOrder));
  }

}
