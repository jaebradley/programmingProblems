package problems.impl;


import org.junit.Assert;
import org.junit.Test;
import problems.exceptions.NoUniqueCharactersException;

public class FirstUniqueCharacterInStringIdentifierImplTest {
    private final FirstUniqueCharacterInStringIdentifierImpl firstUniqueCharacterInStringIdentifier = new FirstUniqueCharacterInStringIdentifierImpl();

    @Test
    public void testExpected() throws NoUniqueCharactersException {
        final String testString = "abca";
        final Character expectedCharacter = new Character('b');
        final Character returnedCharacter = firstUniqueCharacterInStringIdentifier.identifyFirstUniqueCharacterInString(testString);
        Assert.assertEquals(expectedCharacter, returnedCharacter);
        try {
            firstUniqueCharacterInStringIdentifier.identifyFirstUniqueCharacterInString("");
            Assert.fail();
        } catch (NoUniqueCharactersException e) {
            // expected
        }

        try {
            firstUniqueCharacterInStringIdentifier.identifyFirstUniqueCharacterInString("aaaa");
            Assert.fail();
        } catch (NoUniqueCharactersException e) {
            // expected
        }
    }
}
