package problems.impl;

/**
 * Take hexadecimal string and split into perfect squares based on decimal values
 */

public class HexadecimalPerfectSquareSplitter {
    public static int getMin(String s) {
        int substringEndIndex = s.length();
        while (substringEndIndex >= 1) {
            String substring = s.substring(0, substringEndIndex);
            if (isPerfectSquare(hexadecimalToDecimal(substring))) {
                if (substringEndIndex < s.length()) {
                    int otherSubstringMin = getMin(s.substring(substringEndIndex, s.length()));
                    if (otherSubstringMin >= 0) {
                        return otherSubstringMin + 1;
                    }
                } else {
                    return 1;
                }
            }
            substringEndIndex--;
        }
        return -1;
    }

    private static boolean isPerfectSquare(int value) {
        double sqrt = Math.sqrt(value);
        int integerSqrt = (int) sqrt;
        return Math.pow(sqrt, 2) == Math.pow(integerSqrt, 2);
    }

    private static int hexadecimalToDecimal(String value) {
        return Integer.parseInt(value, 16);
    }
}
