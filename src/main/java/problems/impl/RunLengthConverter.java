package problems.impl;

/**
 * Run-length encoding is a fast and simple method of encoding strings.
 * The basic idea is to represent repeated successive characters as a single count and character.
 * For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".
 * Implement run-length encoding and decoding.
 * You can assume the string to be encoded have no digits and consists solely of alphabetic characters.
 * You can assume the string to be decoded is valid.
 */

public class RunLengthConverter {
    public static String encode(String value) {
        if (value.isEmpty()) {
            return "";
        }

        char[] chars = value.toCharArray();

        StringBuilder encodedValue = new StringBuilder();

        char currentChar = chars[0];
        int charCount = 1;

        for (int i = 0; i < chars.length - 1; i++) {
            char nextChar = chars[i + 1];

            if (nextChar == currentChar) {
                charCount++;
            } else {
                encodedValue.append(charCount).append(currentChar);
                charCount = 1;
            }

            currentChar = nextChar;
        }

        encodedValue.append(charCount).append(currentChar);

        return encodedValue.toString();
    }

    public static String decode(String value) {
        char[] chars = value.toCharArray();
        StringBuilder decodedValue = new StringBuilder();

        for (int i = 0; i < chars.length - 1; i += 2) {
            int count = Character.getNumericValue(chars[i]);
            char c = chars[i + 1];
            for (int j = 0; j < count; j++) {
                decodedValue.append(c);
            }
        }
        return decodedValue.toString();
    }
}
