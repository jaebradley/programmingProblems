package problems.interfaces;

public interface GarlandLengthIdentifier {
    int identifyGarlandLength(final String candidate);

    boolean candidateIsASubset(final char[] chars, final char[] candidateChars);
}
