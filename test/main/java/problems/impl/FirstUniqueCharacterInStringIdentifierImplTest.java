package main.java.problems.impl;

import main.java.problems.exceptions.NoUniqueCharactersException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FirstUniqueCharacterInStringIdentifierImplTest {
    private final FirstUniqueCharacterInStringIdentifierImpl firstUniqueCharacterInStringIdentifier = new FirstUniqueCharacterInStringIdentifierImpl();

    @Test
    public void testExpected() throws NoUniqueCharactersException {
        final String testString = "abca";
        final Character expectedCharacter = new Character('b');
        final Character returnedCharacter = firstUniqueCharacterInStringIdentifier.identifyFirstUniqueCharacterInString(testString);
        Assert.assertEquals(expectedCharacter, returnedCharacter);
    }
}