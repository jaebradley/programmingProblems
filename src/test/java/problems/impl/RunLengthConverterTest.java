package problems.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class RunLengthConverterTest {

    @Test
    public void itShouldReturnEmptyStringWhenEncodingEmptyString() {
        assertEquals(RunLengthConverter.encode(""), "");
    }

    @Test
    public void itShouldEncodeForSingleCharacter() {
        assertEquals(RunLengthConverter.encode("a"), "1a");
    }

    @Test
    public void itShouldEncodeForTwoSingleCharacters() {
        assertEquals(RunLengthConverter.encode("ab"), "1a1b");
    }

    @Test
    public void itShouldEncodeRepeatingCharacter() {
        assertEquals(RunLengthConverter.encode("aaaaaa"), "6a");
    }

    @Test
    public void itShouldEncodeRepeatingCharactersThatEndsWithADifferentCharacter() {
        assertEquals(RunLengthConverter.encode("aaaaab"), "5a1b");
    }

    @Test
    public void itShouldEncodeRepeatingCharactersThatEndsWithMultipleDifferentCharacters() {
        assertEquals(RunLengthConverter.encode("aaaaabb"), "5a2b");
    }

    @Test
    public void itShouldDecodeEmptyString() {
        assertEquals(RunLengthConverter.decode(""), "");
    }

    @Test
    public void itShouldDecodeSingleCharacter() {
        assertEquals(RunLengthConverter.decode("1a"), "a");
    }

    @Test
    public void itShouldDecodeTwoSingleCharacters() {
        assertEquals(RunLengthConverter.decode("1a1b"), "ab");
    }

    @Test
    public void itShouldDecodeRepeatingCharacters() {
        assertEquals(RunLengthConverter.decode("5a"), "aaaaa");
    }

    @Test
    public void itShouldDecodeRepeatingCharactersThatEndsWithADifferentCharacter() {
        assertEquals(RunLengthConverter.decode("5a1b"), "aaaaab");
    }

    @Test
    public void itShouldDecodeRepeatingCharactersThatEndWithMultipleDifferentCharacters() {
        assertEquals(RunLengthConverter.decode("5a2b"), "aaaaabb");
    }

}